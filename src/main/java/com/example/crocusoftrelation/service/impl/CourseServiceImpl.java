package com.example.crocusoftrelation.service.impl;

import com.example.crocusoftrelation.dao.entity.Course;
import com.example.crocusoftrelation.dao.entity.Student;
import com.example.crocusoftrelation.dao.repo.CourseRepo;
import com.example.crocusoftrelation.dao.repo.StudentRepo;
import com.example.crocusoftrelation.dto.request.CourseRequestDto;
import com.example.crocusoftrelation.dto.response.StudentResponseDto;
import com.example.crocusoftrelation.exception.CustomNotFoundException;
import com.example.crocusoftrelation.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    @Override
    public String saveCourse(CourseRequestDto request) {

        if (request.getId()>0)
            throw new CustomNotFoundException("The id of the course must be 0 or null");

        Course map = modelMapper.map(request, Course.class);

        for (Long item : request.getStudents()) {
            if (item!=0 || item!=null) {
                var student = studentRepo.findById(item).get();
                map.getStudents().add(student);
            }
        }

        courseRepo.save(map);

        return "Course Saved";
    }

    @Override
    public String updateCourse(CourseRequestDto request) { // Islemir
        if (request.getId()==0)
            throw new CustomNotFoundException("The id of the course must be 0 or null");

        Course map = modelMapper.map(request, Course.class);

        List<Student> students = studentRepo.findStudentsByCourseId(request.getId());
        log.info("CourseService -> findStudentsByCourseId DB dan geldii {}",students);

        for (Long item : request.getStudents()) {
            Student student = studentRepo.findById(item).orElseThrow(() -> new CustomNotFoundException("Student id does not exist"));
            students.add(student);
        }
        log.info("CourseService -> Course Yeni Studentler elave edildi{}",students);

        map.setStudents(students);
        courseRepo.save(map);
        return "Course Updated";
    }
}
