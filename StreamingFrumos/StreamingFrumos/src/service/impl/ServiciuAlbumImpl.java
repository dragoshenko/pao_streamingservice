package service.impl;

import model.Album;
import model.Melodie;
import service.ServiciuAlbum;

public class ServiciuAlbumImpl implements ServiciuAlbum {
    public void adaugaMelodieLaAlbum(Album album, Melodie melodie) {
        album.adaugaMelodie(melodie);
        System.out.println("Melodia \"" + melodie.getNume() + "\" a fost adaugata cu succes la albumul \"" + album.getNume() + "\".");
    }
    @Override
    public void afiseazaAlbum(Album album) {
        System.out.println("Albumul \"" + album.getNume() + "\" de " + album.getArtist().getNumeScena() +
                " (" + album.getArtist().getNume() + ") (" + album.getGenMuzical().getGen() + ") :");
        for (int i = 0; i < album.getMelodii().size(); i++) {
            Melodie melodie = album.getMelodii().get(i);
            System.out.println("Track " + (i + 1) + ": " + melodie.getNume() +
                    " - Streamuri: " + melodie.getNumarStreamuri() +
                    " - Durata: " + melodie.getDurata() + " secunde");
        }

        System.out.println();

        System.out.println("Streamurile totale ale albumului: " + album.getNumarTotalStreamuri() + " streams");
        System.out.println("Durata totala a albumului: " + album.getDurata() + " secunde");
    }

    @Override
    public void actualizeazaNumeAlbum(Album album, String numeNou) {
        album.setNume(numeNou);
        System.out.println("Numele albumului a fost actualizat cu succes la \"" + numeNou + "\".");
        System.out.println();
    }

}
