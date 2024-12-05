public class ManagerCursCSV extends ManagerCursuri implements IOperatiiManagerCurs {
    File studenti, profesori, cursuri;
    public ManagerCursCSV() {
        try {
            studenti = new File("studenti.txt");
            profesori = new File("profesori.csv");
            cursuri = new File("cursuri.csv");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public ManagerCursCSV(File studenti, File profesori, File cursuri) {
        this.studenti = studenti;
        this.profesori = profesori;
        this.cursuri = cursuri;
    }
    /*functia va aduce din fisiere, datele despre studenti, profesori, cursuri
    si va popula colectia din clasa Manager: lista*/
    public void CitesteDateDinFisiere() {
        try {
            ArrayList<Student> studentlist = PopuleazaStudenti();
            ArrayList<Profesor> proflist = PopuleazaProfesori();
            lista = PopuleazaCursuri(proflist, studentlist);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    static void CitireStudenti(String filepath) {
        try {
            File f = new File(filepath);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
//ignor prima linie (antetul)
            if (line != null) {
                line = br.readLine();
            }
            while (line != null) {
                String[] splituri = line.split(",");
                Student s = new Student(splituri[0], splituri[1].trim(), Integer.parseInt(splituri[2].trim()));
                studenti.add(s);
                line = br.readLine();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    static void CitireProfesor(String filepath) {
        try {
            File f = new File(filepath);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
//ignor prima linie (antetul)
            if (line != null) {
                line = br.readLine();
            }
            while (line != null) {
                String[] splituri = line.split(",");
                Profesor s = new Profesor(splituri[0], splituri[1].trim());
                profesori.add(s);
                line = br.readLine();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    static void CitireCursuri(String filepath) {
        try {
            File f = new File(filepath);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
//ignor prima linie (antetul)
            if (line != null) {
                line = br.readLine();
            }
            while (line != null) {
                String[] splituri = line.split(",");
                String[] nume=splituri[0];
                String[] denumire=splituri[1].trim();
                String[] numeprof=splituri[2].trim();
                String[] prenumeprof=splituri[3].trim();
                Profesor p = new Profesor(numeprof,prenumeprof);
                Student[] stud= new Student[];
                Student s = new Student();
                Integer[] note=new Integer[];
                int nr = 0;
                for(int i=0;i<=(studenti.length())*3;i=i+3)
                {
                    s.setNume(splituri[i+4].trim());
                    s.setPrenume(splituri[i+5].trim());
                    s.setGrupa(Integer.parseInt(splituri[i+6].trim()));
                    //Student s = new Student(splituri[i+4], splituri[i+5].trim(),Integer.parseInt(splituri[i+6].trim()));
                    stud[nr]=s;
                    nr++;
                }
                //notele nu sunt in constructorul pt Curs ar trebui adaugate din fisier??
                Curs c = new Curs(nume, denumire ,p ,stud) ;
                cursuri.add(c);
                line = br.readLine();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    static void ScriereStudent(String filepath,Student s) {
        try {
            File f = new File(filepath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            try {
                studenti.add(s);
                bw.write("nume, prenume, grupa\r\n"); //se scrie antetul
                for (Student stud : studenti) {
                    bw.write(stud.toString() + "\r\n");
                }
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
    static void ScriereProfesor(String filepath,Profesor s) {
        try {
            File f = new File(filepath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            try {
                profesor.add(s);
                bw.write("nume, prenume"); //se scrie antetul
                for (Profesor stud : profesori) {
                    bw.write(stud.toString() + "\r\n");
                }
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
    static void Scriere(String filepath,Curs s) {
        try {
            File f = new File(filepath);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            try {
                cursuri.add(s);
                bw.write("nume, descriere, profesor, studenti, note studenti\r\n"); //se scrie antetul
                for (Curs stud : cursuri) {
                    bw.write(stud.toString() + "\r\n");
                }
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