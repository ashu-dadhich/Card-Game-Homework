package card_pack;

/**
 * Created by ashu on 19/4/18.
 */

public class Cards {
    public static final int SPADE = 4;
    public static final int HEART = 3;
    public static final int CLUB = 2;
    public static final int DIAMOND = 1;

    private static final String[] Suit = {"*", "d", "c", "h", "s"};
    private static final String[] Rank = {"*", "A", "2", "3", "4",
            "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private int cardSuit;
    private int cardRank;

    public Cards(int suit, int rank) {
        cardRank =  rank;
        cardSuit =  suit;
    }

    public String toString() {
        return (Rank[cardRank] + Suit[cardSuit]);

    }
}
