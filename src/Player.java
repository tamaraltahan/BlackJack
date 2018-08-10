public class Player {
    private double startingCash;
    private double totalMoney;
    private double bet;
    private Card[] deck = new Card[5];
    private int deckSize = 0;

    public Player(double startingMoney) {
        totalMoney = startingMoney;
        startingCash = startingMoney;
    }

    public double getStartingCash() {
        return startingCash;
    }


    private static String faceCard(Card c) {
        switch (c.value) {
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 1:
                return "Ace";
            default:
                return Integer.toString(c.value);
        }
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void addCard(Card card) {
        deck[deckSize] = card;
        deckSize++;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public int getDeckSize() {
        return deckSize;
    }

    public int getDeckValue() {
        int aces = 0;
        int total = 0;
        for (Card card : deck) {
            if(card.value != 1)
            total += card.value;

            else{
                aces++;
            }
        }
        if(aces == 1){
            int withEleven = total + 11;
            int withOne = total + 1;
            if(withEleven > withOne && withEleven <= 21){
                total = withEleven;
            }
            else if(withOne > withEleven && withOne <= 21){
                total = withOne;
            }
            else{
                total = withOne;
            }
        }
        return total;
    }

    /**
     * prints every card in the player's deck
     */
    public void showAllCards() {
        for (Card c : deck) {
            System.out.print(faceCard(c) + " of " + c.suit + " ");
        }
        System.out.println();
    }

    /**
     * Prints the 2nd card (the visible one)
     */
    public void showCard() {
        System.out.println(faceCard(deck[1]) + " of " + deck[0].suit);
    }

}
