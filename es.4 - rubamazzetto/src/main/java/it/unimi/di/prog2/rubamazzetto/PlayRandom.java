package it.unimi.di.prog2.rubamazzetto;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayRandom implements PlayStrategy{

    private final PlayStrategy next;

    public PlayRandom(PlayStrategy next) {
        this.next = next;
    }

    public PlayRandom() {
        next = null;
    }

    @Override
    public Card choose(List<Card> hand, List<Card> table, List<Integer> piletops) {
        ArrayList<Integer> handranks = PlayStrategy.cardListToRankOrdinals(hand);

        ArrayList<Integer> options = new ArrayList<>();
        options.addAll(PlayStrategy.cardListToRankOrdinals(table));
        options.addAll(piletops);

        Collections.shuffle(options);
        for (Integer option : options) {
            for (Integer card : handranks) {
                if (option.equals(card)) return options.indexOf(option);
            }
        }
        return next.choose(hand, table, piletops);
    }
}
