package model;

public class Recenzie {
    private String text;
    private double nota;
    private String numeCritic;
    private Album album;
    private int id;

    public Recenzie(String text, double nota, String numeCritic, Album album) {
        this.text = text;
        this.nota = nota;
        this.numeCritic = numeCritic;
        this.album = album;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }

    public double getNota() {
        return nota;
    }

    public String getNumeCritic() {
        return numeCritic;
    }

    public Album getAlbum() {
        return album;
    }

    public String afiseazaRecenzie() {
        return numeCritic + ": Nota " + nota + " -" + " '" + text + "'";
    }
}
