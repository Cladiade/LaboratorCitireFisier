package com.example.laboratorjava2024.Service;

import com.example.laboratorjava2024.clase.Persoana;
import com.example.laboratorjava2024.repository.PersoanaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PersoanaService{
    private PersoanaRepository persoanaRepository;
    public void savePersoana(Persoana persoana){
        persoanaRepository.save(persoana);
    }
}
