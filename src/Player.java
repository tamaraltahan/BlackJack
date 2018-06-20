public class Player {
    double totalMoney;
    double bet;
    Card[] deck = new Card[5];
    int deckSize = 0;

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Player(double startingMoney) {
        totalMoney = startingMoney;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public void addCard(Card card) {
        deck[deckSize] = card;
        deckSize++;
    }

    public double getBet() {
        return bet;
    }

    public int getDeckSize() {
        return deckSize;
    }

    public int getDeckValue(){
        int total = 0;
        for(Card card: deck){
            total += card.value;
        }
        return total;
    }

}
