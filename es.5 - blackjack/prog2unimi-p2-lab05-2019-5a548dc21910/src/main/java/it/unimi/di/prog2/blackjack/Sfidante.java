package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sfidante implements GiocatoreBJ {
  final private String name;
  final private Mazziere banco;
  final private List<Card> mano = new ArrayList<>();
  private Strategia strategia;


  public Sfidante(String name, Mazziere banco) {
    this.name = name;
    this.banco = banco;
  }

  // spiegare in un commento di poche righe se e perché questo setter
  // è sufficiente a garantire la proprietà di immutabilità della strategia di un giocatore
  // -- vv ---
  // non è sufficente perché in una normale esecuzione gli assert sono ignorati
  // (sono solo considerati se specificato con opportuno parametro opzionale al momento del lancio del programma)
  // per garantire immutabilità si potrebbe aggiungere un controllo con if statement
  public void setStrategia(Strategia strategia) {
    assert this.strategia == null : "non puoi cambiare strategia se è già settata";
    this.strategia = strategia;
  }

  @Override
  public void carteIniziali() {
    mano.add(banco.draw());
    mano.add(banco.draw());
  }

  @Override
  public void gioca() {
    assert strategia != null : "Per giocare serve una strategia.";
    //TODO implementare il metodo assumendo il rispetto della precondizione

    strategia.chiediCarta();
  }

  @Override
  public Iterator<Card> getCards() {
    return null;
  }

  @Override
  public String getName() {
    return null;
  }
}
