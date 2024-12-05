package com.example.laboratorjava2024.clase;

public class Profesor extends Persoana{

    @Override
    public String toString() {
        return "Profesor{" + super.toString() + "}";
    }
    public Profesor(String nume, String prenume)
    {
        super(nume,prenume);
    }

    public Profesor() {
        super();
    }
}
