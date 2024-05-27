package service.impl;

import model.Album;
import model.ListaAlbume;
import service.ServiciuListaAlbume;

public class ServiciuListaAlbumeImpl implements ServiciuListaAlbume {
    private final ListaAlbume listaAlbume;

    public ServiciuListaAlbumeImpl() {
        this.listaAlbume = new ListaAlbume();
    }

    @Override
    public void adaugaAlbum(Album album) {
        listaAlbume.adaugaAlbum(album);
    }

    @Override
    public void afiseazaAlbumeDetaliat() {
        System.out.println("Albumele ce se afla in lista sunt: ");
        for (Album album : listaAlbume.getAlbume()) {
            System.out.println("Nume album: " + album.getNume());
            System.out.println("Artist: " + album.getArtist().getNume() + " (" + album.getArtist().getNumeScena() + ")");
            System.out.println("Gen muzical: " + album.getGenMuzical().getGen());
            System.out.println("Durata: " + album.getDurata() + " secunde");
            System.out.println("Stream-uri totale: " + album.getNumarTotalStreamuri());
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void afiseazaAlbume() {
        System.out.println("Albumele ce se afla in lista sunt: ");
        for (Album album : listaAlbume.getAlbume()) {
            System.out.println(album.getNume());
        }
        System.out.println();
    }

    @Override
    public void stergeAlbum(Album album) {
        listaAlbume.stergeAlbum(album);
    }
}
