package com.example.laboratorjava2024.repository;

import com.example.laboratorjava2024.Service.StudentService;
import com.example.laboratorjava2024.clase.Persoana;
import com.example.laboratorjava2024.clase.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    public Student getStudentByNumeAndPrenume(String nume, String prenume);

}
