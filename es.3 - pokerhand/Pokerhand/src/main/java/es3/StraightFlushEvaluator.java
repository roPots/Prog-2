package es3;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import ca.mcgill.cs.stg.solitaire.cards.Suit;

public class StraightFlushEvaluator implements ChainedHandEvaluator {

    private final ChainedHandEvaluator next;

    public StraightFlushEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    @Override
    public HandRank evaluate(PokerHand hand) {
        if (hand.isStraight() && hand.isFlush()) return HandRank.STRAIGHT_FLUSH;
        else return next.evaluate(hand);
    }
}

class FourOfAKindEvaluator implements ChainedHandEvaluator {

    private final ChainedHandEvaluator next;

    public FourOfAKindEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    @Override
    public HandRank evaluate(PokerHand hand) {
        if (hand.xOfAKind(4)!=null) return HandRank.FOUR_OF_A_KIND;
        return next.evaluate(hand);
    }
}

class FullHouseEvaluator implements ChainedHandEvaluator {

    private final ChainedHandEvaluator next;

    public FullHouseEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    @Override
    public HandRank evaluate(PokerHand hand) {
        if (hand.xOfAKind(3)!=null && hand.xOfAKind(2)!=null) return HandRank.FULL_HOUSE;
        return next.evaluate(hand);
    }
}

class FlushEvaluator implements ChainedHandEvaluator {

    private final ChainedHandEvaluator next;

    public FlushEvaluator (ChainedHandEvaluator next) { this.next = next; }

    @Override
    public HandRank evaluate(PokerHand hand) {
        if (hand.isFlush()) return HandRank.FLUSH;
        return next.evaluate(hand);
    }
}

class StraightEvaluator implements ChainedHandEvaluator {

    private final ChainedHandEvaluator next;

    public StraightEvaluator (ChainedHandEvaluator next) { this.next = next; }

    @Override
    public HandRank evaluate(PokerHand hand) {
        if (hand.isStraight()) return HandRank.STRAIGHT;
        return next.evaluate(hand);
    }
}

class ThreeOfAKindEvaluator implements ChainedHandEvaluator {

    private final ChainedHandEvaluator next;

    public ThreeOfAKindEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    @Override
    public HandRank evaluate(PokerHand hand) {
        if (hand.xOfAKind(3)!=null) return HandRank.THREE_OF_A_KIND;
        return next.evaluate(hand);
    }
}

class TwoPairEvaluator implements ChainedHandEvaluator {

    private final ChainedHandEvaluator next;

    public TwoPairEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    @Override
    public HandRank evaluate(PokerHand hand) {
        hand.sortBy(PokerHand.RANK_COMPARATOR);

        Rank rank1 = hand.xOfAKind(2);
        if (rank1!=null) {
            hand.sortBy(PokerHand.RANK_COMPARATOR.reversed());
            Rank rank2 = hand.xOfAKind(2);
            if (rank2!=null && rank2!=rank1) {
                return HandRank.TWO_PAIR;
            } else return HandRank.ONE_PAIR;
        }
        return next.evaluate(hand);
    }
}

class HighCardEvaluator implements ChainedHandEvaluator {
    @Override
    public HandRank evaluate(PokerHand hand) {
        return HandRank.HIGH_CARD;
    }
}
