package model;
import java.util.ArrayList;
import java.util.List;
public class Utilizator {
    private String numeUtilizator;
    private String email;
    private List<Playlist> playlisturi;

    public Utilizator(String numeUtilizator, String email) {
        this.numeUtilizator = numeUtilizator;
        this.email = email;
        this.playlisturi = new ArrayList<>();
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public String getEmail() {
        return email;
    }

    public List<Playlist> getPlaylisturi() {
        return playlisturi;
    }

    public void adaugaPlaylist(Playlist playlist) {
        playlisturi.add(playlist);
    }

    public void stergePlaylist(Playlist playlist) {
        playlisturi.remove(playlist);
    }
}
