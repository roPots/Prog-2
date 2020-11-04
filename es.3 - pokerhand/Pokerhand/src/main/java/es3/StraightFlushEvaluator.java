package es3;

public class StraightFlushEvaluator implements ChainedHandEvaluator<PokerHand> {
    private PokerHand hand;

    public StraightFlushEvaluator(PokerHand hand) {
        this.hand = hand;
    }

    @Override
    public int evaluate() {
        hand.sort();

        for (int i=0;i<4;i++) {
            if (!hand.at(i).getSuit().equals(hand.at(i+1).getSuit()) || (hand.at(i+1).getRank().ordinal()!=hand.at(i).getRank().ordinal()+1)) return nexteval(); // suit is different OR next rank is not this rank +1
        }
        return 1;
    }

    private int nexteval() {
        FourOfAKindEvaluator nexteval = new FourOfAKindEvaluator(hand);
        return nexteval.evaluate();
    }
}

class FourOfAKindEvaluator implements ChainedHandEvaluator<PokerHand> {

    private PokerHand hand;

    public FourOfAKindEvaluator(PokerHand hand) {
        this.hand = hand;
    }

    @Override
    public int evaluate() {
        hand.sortRankFirst();
        int eq = 0;
        boolean differed = false;

        for (int i=0;i<4;i++) {
            if (hand.at(i).getRank().equals(hand.at(i+1).getRank())) eq++;
            else if (i!=0) differed = true;
        }
        if (eq==3 && !differed) return 2;
        else return nexteval();
    }

    private int nexteval() {
        FullHouseEvaluator nexteval = new FullHouseEvaluator(hand);
        return nexteval.evaluate();
    }
}

class FullHouseEvaluator implements ChainedHandEvaluator<PokerHand> {

    private PokerHand hand;

    public FullHouseEvaluator(PokerHand hand) {
        this.hand = hand;
    }

    @Override
    public int evaluate() {
        hand.sortRankFirst();

        int eq = 0;

        for (int i=0; i<4; i++) {
            if (hand.at(i).getRank().equals(hand.at(i+1).getRank())) eq++;
        }

        if (eq==3) return 3;
        else return nexteval();
    }

    private int nexteval() {
        return 0;
    }
}
