package com.example.crocusoftrelation.controller;

import com.example.crocusoftrelation.dto.request.StudentRequestDto;
import com.example.crocusoftrelation.dto.response.StudentResponseDto;
import com.example.crocusoftrelation.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody StudentRequestDto request){
        return ResponseEntity.ok(studentService.saveStudent(request));
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestParam Long id,@RequestBody StudentRequestDto request){
        return ResponseEntity.ok(studentService.updateStudent(id,request));
    }
    @GetMapping("/byId")
    public ResponseEntity<StudentResponseDto> findStudentById(@RequestParam Long id){
        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @GetMapping("/findStudentsByCourseId")
    public ResponseEntity<List<StudentResponseDto>> findStudentsByCourseId(@RequestParam Long id){
        return ResponseEntity.ok(studentService.findStudentsByCourseId(id));
    }

    @GetMapping()
    public ResponseEntity<List<StudentResponseDto>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }
}
