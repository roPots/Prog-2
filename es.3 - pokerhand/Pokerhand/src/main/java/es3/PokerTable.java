package es3;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PokerTable implements Iterable<Integer>{
    public List<PokerHand> players;
    private Deck deck;
    private List<Card> discard_pile;

    // given players <= 10
    public PokerTable(int players) {
        deck = new Deck();
        this.players = new ArrayList<>();
        discard_pile = new ArrayList<>();

        for (int i=0; i<players; i++) {
            this.players.add(i,new PokerHand(deck));
        }
    }

    // for testing
    public PokerTable(ArrayList<PokerHand> handpicked) {
        deck = new Deck();
        this.players = handpicked;
        discard_pile = new ArrayList<>();
    }

    public PokerHand getHand(int player_index) {
        return players.get(player_index).secureCopy();
    }

    // assuming list len is less than the number of remaining cards in the deck
    // also assuming that given cards are indeed part of the player hand and are less than what the player has (5)
    // new cards will not be the same as the discarded ones (since are drawn from the same deck);
    public void changeCards(int player, List<Card> discard_cards) {
        PokerHand player_hand = this.getHand(player);
        ArrayList<Card> new_hand = new ArrayList<>();

        for (Card card : player_hand) {
            if (discard_cards.contains(card)) {
                new_hand.add(this.deck.draw());
                discard_pile.add(card);
            }
            else new_hand.add(card);
        }

        players.set(player,new PokerHand(new_hand));
    }

    @Override
    public Iterator<Integer> iterator() {
        ArrayList<PokerHand> ranking = new ArrayList<>(players);
        ranking.sort(Comparator.comparing(PokerHand::getRank).reversed());

        ArrayList<Integer> players_by_ranking = new ArrayList<>();

        for (PokerHand pokerHand : ranking) {
            players_by_ranking.add(players.indexOf(pokerHand));
        }

        return players_by_ranking.iterator();
    }

    // LEFT TO DO: TEST THE BEASTy; IMPLEMENT PRECISE POKER HAND RANKING (IN CASE OF PARITY BETWEEN HANDS)


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer playerID : this) {
            sb.append("Player ").append(playerID).append(":\n");
            sb.append(players.get(playerID));
            sb.append("Score: ").append(players.get(playerID).getRank()).append("\n").append("\n");
        }
        return sb.toString();
    }
}
