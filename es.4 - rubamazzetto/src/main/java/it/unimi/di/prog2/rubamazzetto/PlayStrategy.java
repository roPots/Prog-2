package it.unimi.di.prog2.rubamazzetto;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.List;

public interface PlayStrategy {
    // chooses what card to play, given a certain list of cards (hand); and how, given a certain table to take cards from
    int choose(List<Integer> hand, List<Integer> table, List<Integer> piletops);

    static ArrayList<Integer> cardListToRankOrdinals(List<Card> cards) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (Card card : cards) {
            ret.add(card.getRank().ordinal());
        }
        return ret;
    }
}
