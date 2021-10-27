package com.example.crocusoftrelation.controller;

import com.example.crocusoftrelation.dto.request.StudentRequestDto;
import com.example.crocusoftrelation.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody StudentRequestDto request){
        return ResponseEntity.ok(studentService.saveStudent(request));
    }
}
