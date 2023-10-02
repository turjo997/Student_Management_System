package com.suffixIT.StudentManagementSystem.Controller;

import com.suffixIT.StudentManagementSystem.Response.MessageResponse;
import com.suffixIT.StudentManagementSystem.Service.StudentService;
import com.suffixIT.StudentManagementSystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addStudent(@RequestBody Student student){
        MessageResponse addStudent = studentService.createStudent(student);
        return new ResponseEntity<>(addStudent, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{studentId}")
    public ResponseEntity<MessageResponse> updateStudent(@PathVariable("studentId") Integer studentId, Student student){
        MessageResponse updateStudent = studentService.updateStudent(studentId, student);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/find/{studentId}")
    public ResponseEntity<Student> getAppointmentById(@PathVariable("studentId") Integer studentId){
        Student student = studentService.getASingleStudent(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<MessageResponse> deleteAppointment(@PathVariable("studentId") Integer studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
