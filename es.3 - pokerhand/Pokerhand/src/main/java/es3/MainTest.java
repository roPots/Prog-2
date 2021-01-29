package es3;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import ca.mcgill.cs.stg.solitaire.cards.Suit;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        /*
        PokerTable pt = new PokerTable(4);

        System.out.println(pt);
         */

        ArrayList<PokerHand> handpicked = new ArrayList<>();
        String sf = "KS QS JS 0S 9S";
        handpicked.add(new PokerHand(sf));
        String fk = "KS KD KH KC 9S";
        handpicked.add(new PokerHand(fk));
        String fh = "QS QC 3S 3H 3D";
        handpicked.add(new PokerHand(fh));
        String f = "2S 5S 0S AS QS";
        handpicked.add(new PokerHand(f));

        PokerTable pt = new PokerTable(handpicked);
        System.out.println(pt);
    }
}
