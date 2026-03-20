package com.klu.fsadskill9.service;

import com.klu.fsadskill9.model.Student;
import com.klu.fsadskill9.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private static Map<Integer, Student> studentDB = new HashMap<>();

    static {
        studentDB.put(1, new Student(1, "Teja", "CSE"));
        studentDB.put(2, new Student(2, "Ravi", "ECE"));
    }

    public Student getStudentById(int id) {
        if (!studentDB.containsKey(id)) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
        return studentDB.get(id);
    }
}