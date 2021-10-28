package com.example.crocusoftrelation.service.impl;

import com.example.crocusoftrelation.dao.entity.Course;
import com.example.crocusoftrelation.dao.entity.Student;
import com.example.crocusoftrelation.dao.repo.CourseRepo;
import com.example.crocusoftrelation.dao.repo.StudentRepo;
import com.example.crocusoftrelation.dto.request.CourseRequestDto;
import com.example.crocusoftrelation.dto.response.CourseResponsedto;
import com.example.crocusoftrelation.exception.CustomNotFoundException;
import com.example.crocusoftrelation.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        if (request.getStudents().isEmpty()){
            throw new CustomNotFoundException("StudentList is Empty");
        }
        for (Long item : request.getStudents()) {
            if (item!=0) {
                var student = studentRepo.findById(item)
                        .orElseThrow(()-> new CustomNotFoundException("Student does not exist"));
                map.getStudents().add(student);
            }
        }

        courseRepo.save(map);

        return "Course Saved";
    }

    @Override
    public String updateCourse(CourseRequestDto request) {


        courseRepo.findById(request.getId()).orElseThrow(()-> new CustomNotFoundException("Course Id does not exist"));

        if (request.getId()==0)
            throw new CustomNotFoundException("The id of the course must be 0 or null");

        Course map = modelMapper.map(request, Course.class);

        List<Student> students = studentRepo.findStudentsByCourseId(request.getId());

        for (Long item : request.getStudents()) {
            Student student = studentRepo.findById(item)
                    .orElseThrow(() -> new CustomNotFoundException("Student id does not exist"));
            students.add(student);
        }

        map.setStudents(students);
        courseRepo.save(map);
        return "Course Updated";
    }

    @Override
    public CourseResponsedto findCourseById(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(()-> new CustomNotFoundException("Course Id does not exist"));
        return modelMapper.map(course,CourseResponsedto.class);
    }

    @Override
    public List<CourseResponsedto> findCoursesByStudentId(Long id) {
        List<Course> coursesByStudentId = courseRepo.findCoursesByStudentId(id);
        List<CourseResponsedto> list = new ArrayList<>();

        for (Course item : coursesByStudentId) {
            list.add(modelMapper.map(item,CourseResponsedto.class));
        }
        return list;
    }

    @Override
    public List<CourseResponsedto> findAll() {
        List<Course> all = courseRepo.findAll();
        List<CourseResponsedto> list = new ArrayList<>();

        for (Course item : all) {
            list.add(modelMapper.map(item,CourseResponsedto.class));
        }
        return list;
    }


}
