package service;

import model.Album;

public interface ServiciuListaAlbume {
    void adaugaAlbum(Album album);
    void stergeAlbum(Album album);
    void afiseazaAlbumeDetaliat();
    void afiseazaAlbume();
}
