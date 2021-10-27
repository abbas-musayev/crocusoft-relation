package com.example.crocusoftrelation.controller;

import com.example.crocusoftrelation.dto.request.CourseRequestDto;
import com.example.crocusoftrelation.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
