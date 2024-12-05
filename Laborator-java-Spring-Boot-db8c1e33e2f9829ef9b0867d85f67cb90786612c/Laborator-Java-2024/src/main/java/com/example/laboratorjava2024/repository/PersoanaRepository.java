package com.example.laboratorjava2024.repository;

import com.example.laboratorjava2024.clase.Persoana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoanaRepository extends JpaRepository<Persoana,String> {

}
