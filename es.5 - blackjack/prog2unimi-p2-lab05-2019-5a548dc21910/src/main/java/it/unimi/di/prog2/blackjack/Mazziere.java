package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mazziere implements GiocatoreBJ {
  private List<Card> mano = new ArrayList<>();
  private DeckInterface mazzo = new MultiMazzo(6);

  public Mazziere () {
  }

  public Card draw() {
    return mazzo.draw();
  }

  @Override
  public void carteIniziali() {
    mano.add(draw());
  }

  @Override
  public void gioca() {

  }

  @Override
  public Iterator<Card> getCards() {
    return mano.iterator();
  }

  @Override
  public String getName() {
    return null;
  }

}
