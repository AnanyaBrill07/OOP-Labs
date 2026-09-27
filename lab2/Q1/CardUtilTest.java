public class CardUtilTest {
    public static void main(String[] args) {
        Card aceOfSpades = new Card(Rank.ACE, Suite.SPADES);
        Card twoOfClubs = new Card(Rank.TWO, Suite.CLUBS);
        Card aceOfHearts = new Card(Rank.ACE, Suite.HEARTS);

        System.out.println("Is "+aceOfSpades + " the highest? " + CardUtil.isHighestCard(aceOfSpades));
        System.out.println("Is "+twoOfClubs + " the highest? " + CardUtil.isHighestCard(twoOfClubs));
        System.out.println("Is "+aceOfHearts + "  the highest? " + CardUtil.isHighestCard(aceOfHearts));

        System.out.println("Highest rank: " + CardUtil.HIGHEST_RANK);
        System.out.println("Highest suite: " + CardUtil.HIGHEST_SUITE);
    }
}