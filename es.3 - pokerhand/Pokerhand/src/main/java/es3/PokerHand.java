package es3;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

enum HandRank {
    HIGH_CARD,
    ONE_PAIR,
    TWO_PAIR,
    THREE_OF_A_KIND,
    STRAIGHT,
    FLUSH,
    FULL_HOUSE,
    FOUR_OF_A_KIND,
    STRAIGHT_FLUSH
}

public class PokerHand implements Iterable<Card> {

    private final ArrayList<Card> hand;

    public PokerHand(Deck deck) {
        hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.draw());
        }
    }

    public PokerHand(ArrayList<Card> handpicked) {
        hand = handpicked;
    }

    public int getRank() {
        StraightFlushEvaluator eval = new StraightFlushEvaluator(this);
        return eval.evaluate();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            sb.append(card.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Card> iterator() {
        return hand.iterator();
    }

    public void sort() {
        Collections.sort(hand, Card.SUIT_THEN_RANK_COMPARATOR);
    }

    public void sortRankFirst() {
        Collections.sort(hand, Card.RANK_THEN_SUIT_COMPARATOR);
    }

    public Card at(int i) {
        return hand.get(i);
    }
}