package com.klu.fsadskill9.controller;

import com.klu.fsadskill9.model.Student;
import com.klu.fsadskill9.service.StudentService;
import com.klu.fsadskill9.exception.InvalidInputException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid ID format. Please enter a number.");
        }

        return service.getStudentById(studentId);
    }
}