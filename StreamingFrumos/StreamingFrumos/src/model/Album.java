package model;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String nume;
    private Artist artist;
    private int durata;
    private List<Melodie> melodii;
    private GenMuzical genMuzical;
    private int numarTotalStreamuri;
    private int id;

    public Album(String nume, GenMuzical genMuzical, Artist artist) {
        super();
        this.nume = nume;
        this.artist = artist;
        this.durata = 0;
        this.numarTotalStreamuri = 0;
        this.melodii = new ArrayList<>();
        this.genMuzical = genMuzical;
    }

    public Album() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void adaugaMelodie(Melodie melodie) {
        melodii.add(melodie);
        durata += melodie.getDurata();
        numarTotalStreamuri += melodie.getNumarStreamuri();
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getDurata() {
        return durata;
    }

    public List<Melodie> getMelodii() {
        return melodii;
    }

    public GenMuzical getGenMuzical() {
        return genMuzical;
    }

    public int getNumarTotalStreamuri() {
        return numarTotalStreamuri;
    }

}
