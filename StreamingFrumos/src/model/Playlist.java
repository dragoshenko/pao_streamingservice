package model;

import java.util.HashMap;
import java.util.Map;

public class Playlist {
    private String nume;
    private Map<String, Album> albume;

    public Playlist(String nume) {
        this.nume = nume;
        this.albume = new HashMap<>();
    }
    public void adaugaAlbum(Album album) {
        albume.put(album.getNume(), album);
    }

    public Album getAlbum(String numeAlbum) {
        return albume.get(numeAlbum);
    }

    public void stergeAlbum(String numeAlbum) {
        albume.remove(numeAlbum);
    }

    public Map<String, Album> getAlbume() {
        return albume;
    }

    public void afiseazaPlaylist() {
        System.out.println("Playlist-ul \"" + nume + "\":");
        for (Map.Entry<String, Album> entry : albume.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
