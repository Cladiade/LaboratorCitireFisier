package com.example.laboratorjava2024.clase;

public class Curs {
    String nume;
    String descriere;
    Profesor profu;
    Student[] studenti;

    Integer[] noteStudenti;

    public Curs(String nume, String descriere, Profesor profu, Student[] studenti) {
        this.nume = nume;
        this.descriere = descriere;
        this.profu = profu;
        this.studenti = studenti;
        this.noteStudenti = new Integer[studenti.length];
    }

    public void UpdateProfesor(Profesor profu) {
        this.profu = profu;
    }

    public void AddStudent(Student student) {
//lucrand cu array trebuie inserat folosind un sir auxiliar
        int noualungime = studenti.length + 1;
        Student[] auxStud = new Student[noualungime];
        Integer[] auxNote = new Integer[noualungime];
        int index = 0;
        for (Student s : studenti) {
            auxStud[index++] = s;
        }
        index = 0;
        for (Integer n : noteStudenti) {
            auxNote[index++] = n;
        }
//la final adaugam noul student pe ultimul index
        auxStud[index] = student;
        auxNote[index] = null;
//si realocam lista de studenti cu aux;
        this.studenti = new Student[noualungime];
        this.noteStudenti = new Integer[noualungime];
        System.arraycopy(auxStud, 0, studenti, 0, noualungime);
        System.arraycopy(auxNote, 0, noteStudenti, 0, noualungime);
    }

    public void DeleteStudent(Student student) {
        int noualungime = studenti.length - 1;
        Student[] auxStud = new Student[noualungime];
        Integer[] auxNote = new Integer[noualungime];
        int poz = -1;
        for (int i = 0; i < studenti.length; i++) {
            if (studenti[i].equals(student)) {
                poz = i;
                break;
            }
        }
        int index = 0;
        for (int i = 0; i < studenti.length; i++) {
            if (i == poz) {
                continue;
            }
            auxStud[index] = studenti[i];
            auxNote[index] = noteStudenti[i];
            index++;
        }
        this.studenti = new Student[noualungime];
        System.arraycopy(auxStud, 0, studenti, 0, noualungime);
        System.arraycopy(auxNote, 0, noteStudenti, 0, noualungime);
    }

    public void UpdateStudent(Student student, Student student_nou) {
        for (int i = 0; i < studenti.length; i++) {
            if (studenti[i].equals(student)) {
                studenti[i] = student_nou;
            }
        }
    }

    public void afisareStudentiLaCurs() {
        System.out.println("Studentii inscrisi la cursul " + this.nume + " sunt:");
        for (Student s : studenti) {
            System.out.println(s + " ");
        }
        System.out.println();
    }

    public void noteazaStudent(Student student, int nota){
        for (int i = 0; i < studenti.length; i++) {
            if(studenti[i].equals(student)){
                noteStudenti[i] = nota;
            }
        }
    }

    public void afisareNoteStud(){
        System.out.println("Notele studentilor sunt: ");
        for (int i = 0; i < studenti.length; i++) {
            System.out.println(studenti[i] + " are nota " + noteStudenti[i]);
        }
    }

    public void afisareMedieNote(){
        int suma = 0;
        int nrStud = 0;
        for (int i = 0; i < noteStudenti.length; i++) {
            if(noteStudenti[i] != null) {
                suma += noteStudenti[i];
                nrStud++;
            }
        }
        System.out.println("Media notelor studentilor la cursul " + nume + " este: " + suma/nrStud);
    }

    @Override
    public String toString() {
        String str = "Curs: " + "nume=" + nume + ", descriere = " + descriere + ",\nprofu = " + profu +
                ",\nstudenti:\n";
        for (Student s : studenti) {
            str += s + "\n";
        }
        return str;
    }
}
