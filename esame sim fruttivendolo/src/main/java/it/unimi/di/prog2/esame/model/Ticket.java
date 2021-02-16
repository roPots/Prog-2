package it.unimi.di.prog2.esame.model;

public class Ticket {
  //TODO: dire se questa classe è immutabile e perché
  // è immutabile in quanto:
  // > i prarametri che definiscono i suoi oggetti sono modificabili solo all'interno della classe, in quanto contrassegnati dalla clausola 'private'
  // > i parametri sono definiti come final, dunque non sono riassegnabili dopo la prima volta
  // > i parametri sono costituiti da elementi a loro volta immutabili (int)

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

 //TODO: se fosse necessario confrontare due Ticket, quale approccio sarebbe corretto (spiegando il perché):
 // - usare metodo equals dopo averlo ridefinito.
 // perché non due ticket distinti possono avere lo stesso valore

}
