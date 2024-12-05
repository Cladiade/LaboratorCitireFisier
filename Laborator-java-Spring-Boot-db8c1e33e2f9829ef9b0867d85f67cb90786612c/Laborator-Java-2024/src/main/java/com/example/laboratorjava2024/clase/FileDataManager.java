package com.example.laboratorjava2024.clase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataManager {
     public List<Student> CitireDinFisier(String filepath) {
         List<Student> students = new ArrayList<Student>();
        try {

            File f = new File(filepath);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            if (line != null) {
                line = br.readLine();
            }
            while (line != null) {
                String[] splituri = line.split(",");

                Student s = new Student(splituri[0], splituri[1].trim(), Integer.parseInt(splituri[2].trim()));
                students.add(s);
                line = br.readLine();
            }
            return students;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return students;
    }
    public void ScriereInFisier(String filepath, Student student) {
        try {
            File f = new File(filepath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
            try {
                    bw.write(student.getNume() + "," + student.getPrenume() + "," + student.getGrupa() + "\r\n");
                bw.flush();
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                bw.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
