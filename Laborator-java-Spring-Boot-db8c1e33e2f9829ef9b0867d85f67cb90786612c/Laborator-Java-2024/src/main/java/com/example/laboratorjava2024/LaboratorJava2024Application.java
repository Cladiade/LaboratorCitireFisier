package com.example.laboratorjava2024;

import com.example.laboratorjava2024.Service.PersoanaService;
import com.example.laboratorjava2024.clase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaboratorJava2024Application implements CommandLineRunner {

    @Autowired
    private PersoanaService persoanaService;

    public static void main(String[] args) {
        SpringApplication.run(LaboratorJava2024Application.class, args);
    }


    @Override
    public void run(String... args) {
        //definire studenti
        Student[] studenti = new Student[]{new Student("Andrei", "Negoita", 2231), new Student("Ion", "Mateescu", 4221)};
        //definire profesor
        Profesor prof = new Profesor("Anton", "Panaitescu");
        //definire curs nou
        Curs curs = new Curs("Rezistenta Materialelor", "calculul reacţiunilor,\n" +
                "diagramele de eforturi, calculul caracteristicilor geometrice ale\n" +
                "suprafeţelor plane şi calculul elementelor de rezistenţă la solicitări simple\n"
                , prof, studenti);
        Curs curs2 = new Curs("Analiza Matematica", "calculul reacţiunilor,\n" +
                "diagramele de eforturi, calculul caracteristicilor geometrice ale\n" +
                "suprafeţelor plane şi calculul elementelor de rezistenţă la solicitări simple\n"
                , prof, studenti);
        //adaugare curs in lista de cursuri
        ManagerCursuri cursuri = new ManagerCursuri();
        cursuri.AddCurs(curs);
        cursuri.AddCurs(curs2);
        cursuri.AfiseazaCursuriLaConsola();
        System.out.println("\n\n\n");
        ////        cursuri.DeleteCurs(curs);
        //        cursuri.AfiseazaCursuriLaConsola();
        //        cursuri.UpdateCurs(curs2,curs);
        //        System.out.println("\n\n\n");

        //        curs2.DeleteStudent(studenti[1]);
        //        curs2.DeleteStudent(studenti[0]);
        cursuri.AfiseazaCursuriLaConsola();
        curs.afisareStudentiLaCurs();
        cursuri.afisareCursuri();
        curs2.AddStudent(studenti[0]);
        curs2.AddStudent(studenti[0]);
        curs.noteazaStudent(studenti[0], 10);
        curs.noteazaStudent(studenti[1], 4);
        curs.afisareMedieNote();

        System.out.println("\n\n\n" + prof);
        Persoana persoana = new Persoana("Patrascu", "Adrian");
        persoanaService.savePersoana(persoana);
    }

}