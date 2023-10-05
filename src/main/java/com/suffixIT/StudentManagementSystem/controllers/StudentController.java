package com.suffixIT.StudentManagementSystem.controllers;

import com.suffixIT.StudentManagementSystem.model.APIResponse;
import com.suffixIT.StudentManagementSystem.model.StudentCreateRequest;
import com.suffixIT.StudentManagementSystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add/student")
    public ResponseEntity<String> addStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
        return studentService.addStudent(studentCreateRequest);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<APIResponse<?>> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/get/student/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

}
