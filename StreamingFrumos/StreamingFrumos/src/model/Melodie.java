package model;

public class Melodie {
    private String nume;
    private int durata;
    private int numarStreamuri;
    private int id;

    public Melodie(String nume, int durata, int numarStreamuri) {
        this.nume = nume;
        this.durata = durata;
        this.numarStreamuri = numarStreamuri;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getNumarStreamuri() {
        return numarStreamuri;
    }

    public void setNumarStreamuri(int numarStreamuri) {
        this.numarStreamuri = numarStreamuri;
    }

    @Override
    public String toString() {
        return "Melodie{" +
                "nume='" + nume + '\'' +
                ", durata=" + durata +
                ", numarStreamuri=" + numarStreamuri +
                '}';
    }
}

