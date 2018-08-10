public class Card {
    Suit suit;
    short value;

    /**
     * @param value from 1-13
     * @param suit  value from 1-4 (Clubs, Diamonds, Hearts, Spades)
     */
    Card(short value, Suit suit) {
        if (value <= 0 || value > 13)
            throw new IllegalArgumentException("Card index out of bounds");
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
