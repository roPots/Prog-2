package it.unimi.di.prog2.esame.model;

public class Call {

    private String id;
    private int num;

    public Call(String id, int num) {
        this.id = id;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public int getNum() {
        return num;
    }
}
