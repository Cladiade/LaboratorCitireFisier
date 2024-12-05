package com.example.laboratorjava2024.clase;

public class Student extends Persoana{

    int grupa;

    public Student(String nume, String prenume, int grupa) {
        super(nume,prenume);
        this.grupa = grupa;
    }
    public Student(){
        super();
        this.grupa = 0;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() + ", grupa=" +
                grupa + '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }
}
