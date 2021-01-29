package it.unimi.di.prog2.rubamazzetto;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table implements Iterable<Card>{

  private final List<Card> cards = new ArrayList<>();

  // true if card with same rank is on the table
  public boolean onTable(Card aCard) {
    for (Card card : this) {
      if (card.getRank() == aCard.getRank())
      return true;
    }
    return false;
  }

  // take card from table. game rules not verified
  public void take(Card aCard) {
    for (Card card : this) {
      if (card.getRank() == aCard.getRank()) {
        cards.remove(card);
        return;
      }
    }
  }

  // place card on table (when player can't take anything
  public void place(Card aCard) {
    cards.add(aCard);
  }

  // returns number of cards currently on table
  public int size() {
    return cards.size();
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("{");
    if (cards.size()==0) {
      s.append(" EMPTY }");
    } else {
      for (Card card : this) {
        s.append(" ").append(card).append(" ;");
      }
      s.deleteCharAt(s.length()-1);
      s.append(" }");
    }
    return s.toString();
  }

  @Override
  public Iterator<Card> iterator() { return cards.iterator(); }

}
