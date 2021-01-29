package it.unimi.di.prog2.rubamazzetto;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player {

  private final String name;
  private List<Card> hand = new ArrayList<>();
  private Rank pile_top;
  private final List<Player> opponents = new ArrayList<>();
  private int score;
  private PlayStrategy strategy = RANDO;

  //TODO definire opportunamente l'interfaccia
  public static final PlayStrategy RANDO= new PlayRandom(); // always take random
  public static final PlayStrategy TAKEY= new PlayRandom(); // take from table whichever > steal
  public static final PlayStrategy STEALO= new PlayRandom(); // steal > take from table safe card > take from table whichever
  public static final PlayStrategy SAFEY= new PlayRandom(); // take from table safe card > take random

  public Player(String name) { this.name = name; }

  public Rank getPileTop() {
    return pile_top;
  }

  public Iterator<Player> getOpponents() {
    return opponents.iterator();
  }

  public void initOpponent(Player g) {
    if (!opponents.contains(g))
      opponents.add(g);
  }

  public int getScore() {
    return score;
  }

  public void receiveCard(Card card) {
    hand.add(card);
  }

  public void setStrategy(PlayStrategy strategy) {
    this.strategy = strategy;
  }

  // returns a list of integer representing the ordinal of the rank of the card on top of each players pile
  // if an opponent doesn't have a pile it is ignored
  private ArrayList<Integer> getOpponentsPileTop() {
    ArrayList<Integer> ret = new ArrayList<>();
    for (Player opponent : opponents) {
      Rank r = opponent.getPileTop();
      if (r!=null) { ret.add(r.ordinal()); }
    }
    return ret;
  }

  // assuming the player has set a strategy
  // the player uses one card from his hand (thus removing it) to:
  // > take one card from the table
  // > take the pile of another player
  // > place the card on the table (if the previous actions are not available)
  // the player then updates its score and piletop and ends the turn
  public String playTurn(ArrayList<Card> table) {
    assert strategy != null;

    final Card card = strategy.choose(hand,table,getOpponentsPileTop());
    String turnlog = "";

    //TODO GIOCARE LA CARTA rispettando le regole

    return turnlog;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(name).append("\n");
    s.append("hand [").append(hand.size()).append("]: {");

    if (hand.size()==0) {
      s.append("EMPTY\n");
    } else {
        for (Card card : hand) {
          s.append(" ").append(card).append(" ;");
        }
      s.deleteCharAt(s.length()-1);
      s.append("}\n");
      }

    if (score > 0) {
      s.append("pile has ").append(score).append(" cards\n");
      s.append("pile top card is: ").append(pile_top);
      s.append("\n");
    }

    return s.toString();
  }
}
