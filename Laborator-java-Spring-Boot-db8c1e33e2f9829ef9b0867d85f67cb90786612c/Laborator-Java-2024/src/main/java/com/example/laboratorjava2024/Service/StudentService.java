package com.example.laboratorjava2024.Service;

import com.example.laboratorjava2024.clase.Student;
import com.example.laboratorjava2024.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;
    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }

    public Student getStudentByNumeAndPrenume(String nume, String prenume){
        return studentRepository.getStudentByNumeAndPrenume(nume,prenume);
    }
}
