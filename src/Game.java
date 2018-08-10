import java.util.*;

public class Game {
    private Player player;
    private Player house;

    private static Deck deck;
    private Scanner in = new Scanner(System.in);

    private static void hit(Player player) {
        player.addCard(deck.hit());
    }

    private static void playerWin(Player player) {
        player.setBet(player.getBet() * 2);
    }

    /**
     * Prints both house and player's cards
     */
    private void showAll(){
        System.out.println("House:");
        house.showAllCards();
        System.out.println("Player:");
        player.showAllCards();
    }

    /**
     * Prompts for starting money and sets up the game
     */
    private void initialize(){
        System.out.println("How much you wanna start with, b?");
        double mun = in.nextDouble();
        if(mun < 1){
            do{
                System.out.println("Minimum buy in is $1");
                mun = in.nextDouble();
            }while(mun < 1);
        }
        player = new Player(mun);
        house = new Player(Double.MAX_VALUE);
        setUp();
    }

    /**
     * accepts bets and eals out two cards
     * also checks for dealt blackjacks
     */
    public void setUp() {
        System.out.println("Place your bet!");
        int bet;
        bet = in.nextInt();
        if(bet > player.getTotalMoney() || bet <= 0){
            System.out.println("Invalid bet - must be greater than 0 and less than or equal to your total money");
            while(bet > player.getTotalMoney()){
                bet = in.nextInt();
            }
        }

        deck = new Deck();
        hit(house);
        hit(player);
        hit(house);

        if (house.getDeckValue() == 21) {
            System.out.println("House BlackJack!");
        }
        hit(player);
        if (player.getDeckValue() == 21) {
            System.out.println("Blackjack!");
            playerWin(player);
            play();
        }
        play();
    }

    private void beginAgain(){
        if (player.getTotalMoney() > 1) {
            System.out.println("Would you like to continue?");
            char choice = in.next().charAt(0);
            if (choice == 'y') {
                setUp();
            } else {
                gameOver();
            }
        }
        else{
            gameOver();
        }
    }

    private static boolean assessWin(Player player, Player house){
        if(player.getDeckValue() <= 21 && player.getDeckValue() > house.getDeckValue()){
            return true;
        }
        return false;
    }

    /**
     * Assumes that both the player and house have 2 cards, and the player has made his bet.
     */
    public void play() {
        boolean bust = false;
        System.out.println("House cards: ");
        house.showCard();
        System.out.println("Your cards: ");
        player.showCard();

        do {
            System.out.println("Hit or Hold?");
            String input = in.next().toLowerCase();
            if(player.getDeckSize() == 5){
                if(assessWin(player,house)){
                    playerWin(player);
                }
                else{
                    System.out.println("House wins");
                    beginAgain();
                    break;
                }
            }
            if (input.equals("hit") && player.getDeckSize() <= 5) {
                hit(player);
            }
            if(player.getDeckValue() == 21){
                System.out.println("Blackjack!");
                playerWin(player);
                beginAgain();
            }
            if(player.getDeckValue() > 21){ //bust
                showAll();
                System.out.println("Bust!");
                bust = true;
                player.setTotalMoney(player.getTotalMoney() - player.getBet());
                beginAgain();
            }
            else{
                while(house.getDeckValue() < 15){
                    hit(house);
                }
                if(player.getDeckValue() > house.getDeckValue()){
                    System.out.println("Player wins!");
                    playerWin(player);
                    beginAgain();
                }
            }
        } while (!bust);
    }

    private void gameOver(){
        System.out.println("You started with: " + player.getStartingCash() + "\nYou finished with: "
        + player.getTotalMoney());
        System.out.println("Thanks for playing!");
        in.close();
        System.exit(0);
    }

}



