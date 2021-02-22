package it.unimi.di.prog2.esame.model;

public class Ticket {
  private final int last;
  private final int next;

  public Ticket(int last, int next) {
    this.last = last;
    this.next = next;
  }

  public int getLastInQueue() {
    return last;
  }

  public int getNextToServe() {
    return next;
  }

}
