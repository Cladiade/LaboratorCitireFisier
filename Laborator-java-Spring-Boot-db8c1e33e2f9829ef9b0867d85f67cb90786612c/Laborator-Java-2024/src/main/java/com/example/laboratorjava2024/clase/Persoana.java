    package com.example.laboratorjava2024.clase;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.Id;
    import org.hibernate.annotations.GenericGenerator;

    @Entity
    public  class Persoana {
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        private String id;
        String nume;
        String prenume;

        public Persoana(String nume, String prenume) {
            this.nume = nume;
            this.prenume = prenume;
        }

        public Persoana() {
            this.nume = "";
            this.prenume = "";
        }

        @Override
        public String toString() {
            return  "nume=" + nume + ", prenume=" + prenume;
        }
    }
