package it.unimi.di.prog2.rubamazzetto;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.CardStack;
import ca.mcgill.cs.stg.solitaire.cards.Deck;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private final Deck deck;
  public static Table table;
  private final List<Player> players;
  private Status status;
  private int turn;

  private enum Status {
    SET,
    IN_PROCESS,
    FINISHED,
  }

  public Game(List<Player> candidates) {
    deck = new Deck();

    players = candidates;
    for (Player player : players) {
      for (Player other : players) {
       if (!other.equals(player))
         player.initOpponent(other);
      }
    }

    table = new Table();
    status = Status.SET;
  }

  // gives n card to specified player. @pre deck has more than n cards
  private void giveCards(Player player, int n){
    assert deckSize() >= n;
    for (int i = 0; i < n; i++) {
      player.receiveCard(deck.draw());
    }
  }

  // deals n cards to each player in the game. @pre deck has more than n*players cards
  private void dealCards(int n){
    assert deckSize() >= n * players.size();

    for (Player player : players) {
      giveCards(player,n);
    }
  }

  // start game by dealing each player 3 cards, and placing 4 on the table. @pre game is not started and has a full deck
  public void initialize() {
    assert deckSize()==52 && status.equals(Status.SET) : "can't initialize a game that is already started and uses an incomplete deck";

    dealCards(3);

    for (int i = 0; i < 4; i++) {
      table.place(deck.draw());
    }

    turn = 1;
    status = Status.IN_PROCESS;
  }

  public void nextTurn() {
    // check if game could be finished
    int playedcards = table.size();
    for (Player player : players) {
      playedcards += player.getScore();
    }
    if (deckSize() < players.size() && 52 - playedcards == deckSize()) {
      status = Status.FINISHED;
    }

    else {
      dealCards(1);
      turn++;
    }
  }

  public boolean isFinished(){
    return status.equals(Status.FINISHED);
  }

  private int deckSize(){
    int s = 0;
    CardStack tmp = new CardStack();
    while (!deck.isEmpty()){
      tmp.push(deck.draw());
      s += 1;
    }
    while (!tmp.isEmpty()){
      deck.push(tmp.pop());
    }
    return s;
  }

  public ArrayList<Card> tableCards() {
    ArrayList<Card> ret = new ArrayList<>();
    for (Card card : table) {
      ret.add(card);
    }
    return ret;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();

    s.append("---// GAME TURN ").append(turn).append(" //---\n\n");
    s.append("Status: ").append(status).append("\n\n");
    s.append("Cards left in deck: ").append(deckSize()).append("\n\n");;

    s.append("Players [").append(players.size()).append("]:\n");
    for (Player player : players) {
      s.append(player);
      s.append("\n");
    }

    s.append("Table [").append(tableCards().size()).append("]: ");
    s.append(table);
    s.append("\n");

    return s.toString();
  }
}
