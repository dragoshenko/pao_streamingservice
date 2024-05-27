import model.*;
import service.impl.*;
import service.*;
import DataBase.*;
import CSV.*;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //CsvReaderService csvReaderService = CsvReaderService.getInstance();
        //AuditService auditService = AuditService.getInstance();


        ServiciuListaAlbumeImpl serviciuListaAlbume = new ServiciuListaAlbumeImpl();


        GenMuzical genMuzical = new GenMuzical("Experimental Hip Hop, Cloud Rap");
        Artist artist = new Artist("Barrington DeVaughn Hendricks", "JPEGMAFIA", 44);
        Album album = new Album("All My Heroes Are Cornballs", genMuzical, artist);
        ServiciuAlbumImpl serviciuAlbum = new ServiciuAlbumImpl();
        Melodie melodie1 = new Melodie("Jesus Forgive Me", 183, 14000000);
        serviciuAlbum.adaugaMelodieLaAlbum(album, melodie1);
        Melodie melodie2 = new Melodie("Kenan Vs. Kel", 241, 2800000);
        serviciuAlbum.adaugaMelodieLaAlbum(album, melodie2);
        Melodie melodie3 = new Melodie("Beta Male Strategies", 200, 2390000);
        serviciuAlbum.adaugaMelodieLaAlbum(album, melodie3);

        serviciuListaAlbume.adaugaAlbum(album);

        System.out.println();

        serviciuAlbum.afiseazaAlbum(album);

        ServiciuStreamingService serviciuStreamingService = new ServiciuStreamingServiceImpl();
        System.out.println();
        double profit = serviciuStreamingService.calculeazaProfit(album, "tidal");
        System.out.println("Profitul albumului : $" + profit);
        System.out.println();

        Recenzie recenzie = new Recenzie("A very good effort.", 9, "Anthony Fantano", album);
        Recenzie recenzie1 = new Recenzie("Un album memorabil, executat bine.", 8.5, "Bodi Vidra", album);
        System.out.println(recenzie.afiseazaRecenzie());
        System.out.println(recenzie1.afiseazaRecenzie());
        System.out.println();

        GenMuzical genMuzical_1 = new GenMuzical("Alternative Rock");
        Artist artist_1 = new Artist("Thom Yorke", "Radiohead", 53);
        Album album_1 = new Album("Kid A", genMuzical_1, artist_1);
        ServiciuAlbumImpl serviciuAlbum1 = new ServiciuAlbumImpl();
        Melodie melodie1_1 = new Melodie("Everything in Its Right Place", 269, 185000000);
        serviciuAlbum1.adaugaMelodieLaAlbum(album_1, melodie1_1);
        Melodie melodie2_1 = new Melodie("The National Anthem", 299, 15005000);
        serviciuAlbum1.adaugaMelodieLaAlbum(album_1, melodie2_1);
        Melodie melodie3_1 = new Melodie("How to Disappear Completely", 337, 2000000);
        serviciuAlbum1.adaugaMelodieLaAlbum(album_1, melodie3_1);

        serviciuListaAlbume.adaugaAlbum(album_1);

        System.out.println();

        serviciuAlbum1.afiseazaAlbum(album_1);

        double profit_1 = serviciuStreamingService.calculeazaProfit(album_1, "spotify");
        System.out.println("Profitul albumului: $" + profit_1);
        System.out.println();

        Recenzie recenzie2 = new Recenzie("A classic.", 10, "Anthony Fantano", album_1);
        Recenzie recenzie3 = new Recenzie("Aproape perfect.", 9.5, "Bodi Vidra", album_1);
        System.out.println(recenzie2.afiseazaRecenzie());
        System.out.println(recenzie3.afiseazaRecenzie());

        Playlist playlistRap = new Playlist("Rap");
        Playlist playlistRock = new Playlist("Rock");

        System.out.println();

        playlistRap.adaugaAlbum(album);
        playlistRock.adaugaAlbum(album_1);

        playlistRap.afiseazaPlaylist();
        System.out.println();
        playlistRock.afiseazaPlaylist();

        System.out.println();

        serviciuListaAlbume.afiseazaAlbumeDetaliat();
        serviciuListaAlbume.afiseazaAlbume();
        //serviciuListaAlbume.stergeAlbum(album_1);
        serviciuAlbum.actualizeazaNumeAlbum(album, "Veteran");
        serviciuListaAlbume.afiseazaAlbume();



        Connection connection = null;
        try {

            connection = DatabaseConnection.getConnection();
            System.out.println("Conexiunea la baza de date a avut succes.");

            AlbumDB albumDB = new AlbumDB(connection);
            ArtistDB artistDB = new ArtistDB(connection);
            GenMuzicalDB genmuzicalDB = new GenMuzicalDB(connection);
            MelodieDB melodieDB = new MelodieDB(connection);
            RecenzieDB recenzieDB = new RecenzieDB(connection);

            artistDB.create(artist);
            artistDB.create(artist_1);
            genmuzicalDB.create(genMuzical);
            genmuzicalDB.create(genMuzical_1);

            melodieDB.create(melodie1);
            melodieDB.create(melodie2);
            melodieDB.create(melodie3);
            melodieDB.create(melodie1_1);
            melodieDB.create(melodie2_1);
            melodieDB.create(melodie3_1);

            albumDB.create(album);
            albumDB.create(album_1);

            recenzieDB.create(recenzie);
            recenzieDB.create(recenzie1);
            recenzieDB.create(recenzie2);
            recenzieDB.create(recenzie3);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DatabaseConnection.closeConnection(connection);
        }



/*
    connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            DatabaseConnection.deleteInserts("melodie");
            DatabaseConnection.deleteInserts("recenzie");
            DatabaseConnection.deleteInserts("album");
            DatabaseConnection.deleteInserts("genmuzical");
            DatabaseConnection.deleteInserts("artist");
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea datelor: " + e.getMessage());
        }

 */
    }
}
