package it.unimi.di.prog2.esame.model;

public class Ticket {
    final private int last;
    final private int next;
    final private String idOffice;

    public Ticket(int last, int next, String idOffice) {
        this.last = last;
        this.next = next;
        this.idOffice = idOffice;
    }

    public int getLast() {
        return last;
    }

    public int getNext() {
        return next;
    }

    public String getIdOffice() {
        return idOffice;
    }
}
