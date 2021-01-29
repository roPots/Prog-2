package es3;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import ca.mcgill.cs.stg.solitaire.cards.Suit;

import java.util.*;

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

public class PokerHand implements Iterable<Card>, Comparable<PokerHand>{

    private final List<Card> hand;
    private final ChainedHandEvaluator EVALUATOR = new StraightFlushEvaluator(new FourOfAKindEvaluator(new FullHouseEvaluator(new FlushEvaluator(new StraightEvaluator(new ThreeOfAKindEvaluator(new TwoPairEvaluator(new HighCardEvaluator())))))));

    public static final Comparator<Card> SUIT_COMPARATOR = Comparator.comparing(Card::getSuit).thenComparing(Card::getRank);
    public static final Comparator<Card> RANK_COMPARATOR = Comparator.comparing(Card::getRank).thenComparing(Card::getSuit);

    // builds a 5 card poker hand from a given deck. throws exception if deck has not enough cards.
    public PokerHand(Deck deck) {
        hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (deck.isEmpty()) throw new IllegalArgumentException();
            else hand.add(deck.draw());
        }
    }

    public PokerHand(List<Card> cards) {
        hand = new ArrayList<>(cards);
    }

    // assuming string in format "7H JC 0H AC 4C", throws exception if card string is not valid (es. 22H or 4K or C4)
    public PokerHand(String input) throws IllegalArgumentException {
        hand = new ArrayList<>();
        for(String e : input.split(" ")) hand.add(parseCardInput(e));
    }

    private Card parseCardInput(String card_input) {
        Rank rank = switch (card_input.charAt(0)) {
            case 'A' -> Rank.ACE;
            case '2' -> Rank.TWO;
            case '3' -> Rank.THREE;
            case '4' -> Rank.FOUR;
            case '5' -> Rank.FIVE;
            case '6' -> Rank.SIX;
            case '7' -> Rank.SEVEN;
            case '8' -> Rank.EIGHT;
            case '9' -> Rank.NINE;
            case '0' -> Rank.TEN;
            case 'J' -> Rank.JACK;
            case 'Q' -> Rank.QUEEN;
            case 'K' -> Rank.KING;
            default -> null;
        };

        Suit suit = switch (card_input.charAt(1)) {
            case 'C' -> Suit.CLUBS;
            case 'D' -> Suit.DIAMONDS;
            case 'H' -> Suit.HEARTS;
            case 'S' -> Suit.SPADES;
            default -> null;
        };

        if (rank==null || suit==null) throw new IllegalArgumentException();
        return Card.get(rank,suit);
    }

    public PokerHand secureCopy() {
        return new PokerHand(this.hand);
    }

    //start evaluation chain to determine rank. it evaluates on a copy of the poker hand to preserve the order of the cards
    public HandRank getRank() {
        return EVALUATOR.evaluate(new PokerHand(this.hand));
    }

    public void sortBy(Comparator<Card> COMPARATOR) {
        hand.sort(COMPARATOR);
    }

    // if poker hand contains exactly x times a card with the same rank, returns the rank. else returns null
    // does not provide a way to identify 2 different ranks contained two times in the same poker hand.
    // since it returns THE FIRST RANK that satisfy the requirements, in the order the cards of the poker hand are when passed to the function,
    // (to identify a poker hand with 2 of 2 kinds) it could be wise to order by rank first, call the function and then doing it again but with the hand in the reverse order.
    public Rank xOfAKind(int x) {
        for (Card card : this) {
            Rank current = card.getRank();
            if (this.timesOfRank(current)==x) return current;
        }
        return null;
    }

    private int timesOfRank(Rank rank) {
        int times = 0;
        for (Card card : this) {
            if (card.getRank().equals(rank)) times++;
        }
        return times;
    }

    public boolean isFlush() {
        Suit flush = null;
        int correct = 0;

        for (Card card : this) {
            Suit current = card.getSuit();
            if (current==flush) correct++;
            flush = current;
        }

        return correct == 4;
    }

    public boolean isStraight() {
        this.sortBy(RANK_COMPARATOR);

        int straight = -1;
        int correct = 0;

        for (Card card : this) {
            int current = card.getRank().ordinal()+1;
            if (current==straight+1 || (current==10 && straight==1)) correct++;
            straight = current;
        }

        return correct == 4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : this) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Card> iterator() {
        return hand.iterator();
    }

    @Override
    public int compareTo(PokerHand other) {
        return this.getRank().compareTo(other.getRank());
    }
}