public class CardUtil {

    public static final Rank HIGHEST_RANK = Rank.ACE;
    public static final Suite HIGHEST_SUITE = Suite.SPADES;

    // Prevent instantiation since this is a utility class
    private CardUtil() {
    }

    public static boolean isHighestCard(Card card) {
        return card.getRank() == HIGHEST_RANK && card.getSuit() == HIGHEST_SUITE;
    }
}