package es3;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import ca.mcgill.cs.stg.solitaire.cards.Suit;

import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        ArrayList<Card> handpicked = new ArrayList<>();
        handpicked.add(Card.get(Rank.SIX,Suit.CLUBS));
        handpicked.add(Card.get(Rank.SIX,Suit.HEARTS));
        handpicked.add(Card.get(Rank.SIX,Suit.DIAMONDS));
        handpicked.add(Card.get(Rank.KING,Suit.SPADES));
        handpicked.add(Card.get(Rank.KING,Suit.HEARTS));

        PokerHand fullhouse = new PokerHand(handpicked);

        ArrayList<Card> handpicked2 = new ArrayList<>();
        handpicked2.add(Card.get(Rank.FIVE,Suit.SPADES));
        handpicked2.add(Card.get(Rank.FIVE,Suit.DIAMONDS));
        handpicked2.add(Card.get(Rank.FIVE,Suit.HEARTS));
        handpicked2.add(Card.get(Rank.FIVE,Suit.CLUBS));
        handpicked2.add(Card.get(Rank.TWO,Suit.DIAMONDS));

        PokerHand fourofakind = new PokerHand(handpicked2);

        ArrayList<Card> handpicked3 = new ArrayList<>();
        handpicked3.add(Card.get(Rank.JACK,Suit.SPADES));
        handpicked3.add(Card.get(Rank.TEN,Suit.SPADES));
        handpicked3.add(Card.get(Rank.NINE,Suit.SPADES));
        handpicked3.add(Card.get(Rank.EIGHT,Suit.SPADES));
        handpicked3.add(Card.get(Rank.SEVEN,Suit.SPADES));

        PokerHand straightflush = new PokerHand(handpicked3);

        Deck deck = new Deck();
        PokerHand rand = new PokerHand(deck);

        System.out.println(straightflush.getRank());
        System.out.println(fourofakind.getRank());
        System.out.println(fullhouse.getRank());
        System.out.println(rand.getRank());


        Scanner in = new Scanner(System.in);
/*
        boolean again = true;
        do{
            PokerHand hand = new PokerHand(deck);
            System.out.println(hand);
            System.out.println(hand.getRank());

            System.out.println("try again? [Y/N]");
            String ans = in.nextLine();
            if (ans.equals("N")) again = false;

        } while (again);
        */
    }
}

/*
public int compareTo(Card other) {
    if (this.aSuit.ordinal() > other.aSuit.ordinal()) return 1;
    if (this.aSuit.ordinal() > other.aSuit.ordinal()) return -1;
    if (this.aSuit.ordinal() == other.aSuit.ordinal()) {
        if (this.aRank.ordinal() > other.aRank.ordinal()) return 1;
        if (this.aRank.ordinal() < other.aRank.ordinal()) return -1;
        if (this.aRank.ordinal() == other.aRank.ordinal()) return 0;
    }
}
*/
