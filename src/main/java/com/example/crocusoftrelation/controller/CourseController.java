package com.example.crocusoftrelation.controller;

import com.example.crocusoftrelation.dto.request.CourseRequestDto;
import com.example.crocusoftrelation.dto.response.CourseResponsedto;
import com.example.crocusoftrelation.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody CourseRequestDto request){
        return ResponseEntity.ok(courseService.saveCourse(request));
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody CourseRequestDto request){
        return ResponseEntity.ok(courseService.updateCourse(request));
    }

    @GetMapping("/findCoursesByStudentId")
    public ResponseEntity<List<CourseResponsedto>>  findCoursesByStudentId(@RequestParam Long id){
        return ResponseEntity.ok(courseService.findCoursesByStudentId(id));
    }

    @GetMapping("/findById")
    public ResponseEntity<CourseResponsedto> findCourseById(@RequestParam Long id){
        return ResponseEntity.ok(courseService.findCourseById(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseResponsedto>>  findAll(){
        return ResponseEntity.ok(courseService.findAll());
    }


}
