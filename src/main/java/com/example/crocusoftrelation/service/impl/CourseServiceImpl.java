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

        Course map = modelMapper.map(request, Course.class);

        for (Long item : request.getStudents()) {
//          The reason I'm writing if here is not to throw an exception when student_id isn't there
//          Because when a course is saved, it may not be any student
            if (item!=null) {
                var student = studentRepo.findById(item)
                        .orElseThrow(()-> new CustomNotFoundException("Student does not exist"));
                map.getStudents().add(student);
            }
        }

        courseRepo.save(map);

        return "Course Saved";
    }

    @Override
    public String updateCourse(Long id,CourseRequestDto request) {

        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("Course id:" + id + " does not exist"));

        if (request.getStudents().isEmpty()){
            throw new CustomNotFoundException("StudentList is Empty");
        }
        course.setName(request.getName());

        List<Student> students = course.getStudents();
        for (Long item : request.getStudents()) {
            Student student = studentRepo.findById(item)
                    .orElseThrow(() -> new CustomNotFoundException("Student id:"+id+" does not exist"));
            students.add(student);
        }
        course.setStudents(students);
        courseRepo.save(course);
        return "Course Saved";
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
