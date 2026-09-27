public class Card {
    private Rank rank;
    private Suite suit;

    public Card(Rank rank, Suite suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public Rank getRank() {
        return rank;
    }
    public void setRank(Rank rank) {
        this.rank = rank;
    }
    public Suite getSuit() {
        return suit;
    }
    public void setSuit(Suite suit) {
        this.suit = suit;
    }
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}