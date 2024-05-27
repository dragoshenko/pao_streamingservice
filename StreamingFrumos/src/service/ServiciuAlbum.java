package service;

import model.Album;
import model.Melodie;

public interface ServiciuAlbum {
    void afiseazaAlbum(Album album);
    void adaugaMelodieLaAlbum(Album album, Melodie melodie);
    void actualizeazaNumeAlbum(Album album, String numeNou);
}
