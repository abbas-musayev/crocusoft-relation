package com.example.crocusoftrelation.service.impl;

import com.example.crocusoftrelation.dao.entity.Address;
import com.example.crocusoftrelation.dao.entity.Course;
import com.example.crocusoftrelation.dao.entity.Student;
import com.example.crocusoftrelation.dao.repo.AddressRepo;
import com.example.crocusoftrelation.dao.repo.CourseRepo;
import com.example.crocusoftrelation.dao.repo.StudentRepo;
import com.example.crocusoftrelation.dto.request.StudentRequestDto;
import com.example.crocusoftrelation.dto.response.StudentResponseDto;
import com.example.crocusoftrelation.exception.CustomNotFoundException;
import com.example.crocusoftrelation.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public String saveStudent(StudentRequestDto request) {

        Student map = modelMapper.map(request, Student.class);
        for (Long item : request.getCourses()) {
//          The reason I write if here is not to throw an exception directly when there is no course_id
//          Because when a student saves, he may not join any course
            if (item!=null || item!=0){
                Course course = courseRepo.findById(item).get();
                map.getCourses().add(course);
            }
        }
        studentRepo.save(map);
        return "Student Saved";
    }

    @Override
    public String updateStudent(Long id,StudentRequestDto request) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("Student id:" + id + " does not exist"));

        if (request.getCourses().isEmpty()){
            throw new CustomNotFoundException("CourseList is empty");
        }

        student.setName(request.getName());
        student.setSurname(request.getSurname());
        List<Course> courses = student.getCourses();
        for (Long item : request.getCourses()) {
            Course course = courseRepo.findById(item)
                    .orElseThrow(() -> new CustomNotFoundException("Course id:"+id+"does not exist"));
            courses.add(course);
        }
        student.setCourses(courses);
        studentRepo.save(student);
        return "Student Saved";
    }

    @Override
    public StudentResponseDto findStudentById(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("Student does not exist"));
        return modelMapper.map(student,StudentResponseDto.class);
    }

    @Override
    public List<StudentResponseDto> findAllStudents() {
        List<Student> all = studentRepo.findAll();
        List<StudentResponseDto> list = new ArrayList<>();
        for (Student item : all) {
            list.add(modelMapper.map(item,StudentResponseDto.class));
        }
        return list;
    }

    @Override
    public List<StudentResponseDto> findStudentsByCourseId(Long id) {
        List<Student> studentsByCourseId = studentRepo.findStudentsByCourseId(id);

        List<StudentResponseDto> list = new ArrayList<>();
        for (Student item : studentsByCourseId) {
            list.add(modelMapper.map(item,StudentResponseDto.class));
        }
        return list;
    }


}
