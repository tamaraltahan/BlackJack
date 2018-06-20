public class Player {
    double bet;
    Card[] deck = new Card[5];
    int deckSize = 0;

    public void setBet(double bet){
        this.bet = bet;
    }

    public void addCard(Card card){
        deck[deckSize] = card;
        deckSize++;
    }

    public double getBet() {
        return bet;
    }

    public int getDeckSize() {
        return deckSize;
    }

}
