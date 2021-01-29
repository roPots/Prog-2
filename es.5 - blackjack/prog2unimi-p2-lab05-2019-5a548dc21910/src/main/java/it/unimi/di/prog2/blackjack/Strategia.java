package it.unimi.di.prog2.blackjack;

//TODO implementare almeno tre strategie di vostra invenzione per comporre il modo di giocare dei giocatori
// potranno basarsi sulle proprie carte o sulla carta iniziale del banco

public interface Strategia {
  // nullobject di strategia
  Strategia NULL = new Strategia() {
    @Override
    public boolean chiediCarta() {
      return false;
    }
  };


  boolean chiediCarta();

}

