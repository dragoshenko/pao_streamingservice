package model;

public class GenMuzical {

    private int id;
    private String gen;

    public GenMuzical() {

    }
    public GenMuzical(String gen) {
        this.gen = gen;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGen() {
        return gen;
    }
    public void setGen(String gen) {
        this.gen = gen;
    }
}

