package com.example.laboratorjava2024.clase;

import java.sql.Connection;

public class ManagerCursuri {
    Curs[] cursuri;

    public ManagerCursuri() {
        Connection conn = null;
        cursuri = new Curs[0];
    }

    public void AddCurs(Curs curs) {
        int noualungime = cursuri.length + 1;
        Curs[] aux = new Curs[noualungime];
        int index = 0;
        for (Curs c : cursuri) {
            aux[index++] = c;
        }
//la final adaugam noul curs pe ultimul index
        aux[index] = curs;
//si realocam lista de curs cu aux;
        this.cursuri = new Curs[noualungime];
        System.arraycopy(aux, 0, cursuri, 0,
                noualungime);
    }

    public void DeleteCurs(Curs curs) {
        int noualungime = cursuri.length - 1;
        Curs[] aux = new Curs[noualungime];
        int index = 0;
        for (Curs c : cursuri) {
            if(!c.equals(curs))
                aux[index++] = c;
        }
        this.cursuri = new Curs[noualungime];
        System.arraycopy(aux, 0, cursuri, 0,
                noualungime);
    }

    public void UpdateCurs(Curs curs, Curs cursNou) {
        for (int i=0; i< cursuri.length; i++){
            if(cursuri[i].equals(curs)){
                cursuri[i] = cursNou;
            }
        }
    }

    public void afisareCursuri(){
        System.out.println("Cursurile existente sunt: ");
        for(Curs c : this.cursuri){
            System.out.println(c.nume + " ");
        }
    }

    public void AfiseazaCursuriLaConsola() {
        for (Curs c : cursuri)
            System.out.println(c);
    }

    public void AfisareMedieNoteProfesor(Profesor profesor){
        int sumaNote = 0;
        int nrNote = 0;
        for(Curs c : this.cursuri){
            if(c.profu.equals(profesor)){
                for(Integer nota : c.noteStudenti){
                    if(nota!= null){
                        sumaNote += nota;
                        nrNote++;
                    }
                }
            }
        }
        System.out.println("Media notelor date de profesorul " + profesor.nume + " " + profesor.prenume + "este: " + sumaNote/nrNote);
    }
}