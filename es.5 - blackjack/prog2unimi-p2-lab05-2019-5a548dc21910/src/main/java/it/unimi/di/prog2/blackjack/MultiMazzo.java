package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MultiMazzo implements DeckInterface {
  private List<Card> mazzo = new ArrayList<>();

  public MultiMazzo(int numMazzi) {
    for (int i = 0; i < numMazzi; i++) {
      Deck unmazzo = new Deck();
      for (int j = 0; j < 52; j++) {
        mazzo.add(unmazzo.draw());
      }
    }
    Collections.shuffle(mazzo);
    assert mazzo.size()==numMazzi*52;
  }

  @Override
  public Card draw() {
    assert mazzo.size() > 0;
    return mazzo.remove(0);
  }

  @Override
  public boolean isEmpty() {
    return mazzo.size() == 0;
  }
}
