package model;

public class Artist {
    private String numeArtist;
    private String numeScena;
    private int varsta;
    private int id;

    public Artist() {

    }
    public Artist(String nume, String numeScena, int varsta) {
        this.numeArtist = nume;
        this.numeScena = numeScena;
        this.varsta = varsta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNume() {
        return numeArtist;
    }

    public void setNume(String nume) {
        this.numeArtist = nume;
    }

    public String getNumeScena() {
        return numeScena;
    }

    public void setNumeScena(String numeScena) {
        this.numeScena = numeScena;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "nume='" + numeArtist + '\'' +
                ", numeScena='" + numeScena + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
