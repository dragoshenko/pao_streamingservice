package model;

import java.util.ArrayList;
import java.util.List;

public class ListaAlbume extends Album {
    private List<Album> albume;

    public ListaAlbume() {
        super();
        this.albume = new ArrayList<>();
    }

    public void adaugaAlbum(Album album) {
        albume.add(album);
    }

    public void stergeAlbum(Album album) {
        albume.remove(album);
    }

    public List<Album> getAlbume() {
        return albume;
    }
}
