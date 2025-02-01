package com.turkcell.turkcellcqrs.application.student.service;

import com.turkcell.turkcellcqrs.domain.entity.Student;
import com.turkcell.turkcellcqrs.persistence.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    @Override
    public Student findStudentById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }
}
