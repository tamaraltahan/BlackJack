import java.util.*;

public class Game {
    Player player;
    Player house;

    static Deck deck = new Deck();
    Scanner in = new Scanner(System.in);

    private static void hit(Player player) {
        player.addCard(deck.hit());
    }

    private static void playerWin(Player player) {
        player.setBet(player.getBet() * 2);
    }


    public void setUp() {

        System.out.println("How much you wanna start with, b?");
        double mun = in.nextDouble();
        player = new Player(mun);
        house = new Player(Double.MAX_VALUE);
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

    public void play() {
        boolean bust = false;
        System.out.println("House cards:" + house.toString());
        System.out.println("Your cards:" + player.toString());

        do {
            System.out.println("Hit or Hold?");
            String input = in.next().toLowerCase();
            if (input.equals("hit")) {
                hit(player);
            }
            if(player.getDeckValue() > 21){
                System.out.println("Bust!");
                bust = true;
                player.setTotalMoney(player.getTotalMoney() - player.getBet());
            }
            else{
                while(house.getDeckValue() < 15){
                    hit(house);
                }
                if(player.getDeckValue() > house.getDeckValue()){
                    System.out.println("Player wins!");
                    playerWin(player);
                }
            }
        } while (!bust);
    }


}



