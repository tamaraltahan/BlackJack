import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;


public class Deck {
    private Card[] deck;
    private Stack<Card> stack = new Stack<>();

    Deck() {
        generateDeck();
    }

    public void generateDeck() {
        deck = new Card[52];
        populateDeck(deck);
        shuffle(deck);
        for (Card card : deck) {
            stack.push(card);
        }
    }

    public Card hit() {
        return stack.pop();
    }

    private void shuffle(Card[] deck) { //Durstenfeld shuffle implementation
        Random rng = ThreadLocalRandom.current(); //idk wtf this is
        for (int i = deck.length - 1; i > 0; i--) {
            int index = rng.nextInt(i + 1);
            Card temp = deck[index];
            deck[index] = deck[i];
            deck[i] = temp;
        }
    }

    private void populateDeck(Card[] deck) { //generates ordered deck
        for (short i = 1; i <= 4; i++) {
            for (short j = 0; j < 12; j++) {
                switch (i) {
                    case 1:
                        deck[j] = new Card(j, Suit.Clubs);
                        break;
                    case 2:
                        deck[j] = new Card(j, Suit.Diamonds);
                        break;
                    case 3:
                        deck[j] = new Card(j, Suit.Hearts);
                    case 4:
                        deck[j] = new Card(j, Suit.Spades);
                        break;
                }
            }
        }
    }


}
