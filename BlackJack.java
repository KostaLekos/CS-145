import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Hand dealer = new Hand();
        dealer.addCard(deck.dealCard());        
        dealer.addCard(deck.dealCard());

        String choice;

        ArrayList<Hand> players = new ArrayList<Hand>();

        Scanner stdin = new Scanner(System.in);
        int numPlayers = 1;

        boolean p = true;
        while (p) {
            System.out.println("How many people are playing?");
            p = false;
            try {
                numPlayers = Integer.valueOf(stdin.next());
            } catch (Exception e) {
                p = true;
            }

            if (numPlayers > 10 | numPlayers < 1) p = true;
        }

        playing:
        while (true) {
            System.out.println("\nThe Dealer has " + dealer.toString() + 
            " totaling a value of " + dealer.getTotalValue() + ".\n");

            for (int i = 0; i < numPlayers; i++) {
                players.add(new Hand(i + 1));

                players.get(i).addCard(deck.dealCard());        
                players.get(i).addCard(deck.dealCard());

                System.out.println("Player " + players.get(i).getNum() + ", you have " + players.get(i).toString() + 
                " totaling a value of " + players.get(i).getTotalValue() + ".");
            }

            round:
            while (true) {
                turn:
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getTotalValue() < 21) {
                        System.out.println("\nPlayer " + players.get(i).getNum() + ", your current score is " + players.get(i).getTotalValue() + ". Would you like to hit? (y/n)");
                        choice = stdin.next();

                        if (choice.length() > 0 && choice.substring(0,1).toLowerCase().equals("y")) {
                            players.get(i).addCard(deck.dealCard());

                            System.out.println("\nPlayer " + players.get(i).getNum() + " drew a " + players.get(i).getNewestCard() + 
                            " and now has a total value of " + players.get(i).getTotalValue() + ".");

                            if (players.get(i).getTotalValue() > 21) {
                                System.out.println("Player " + players.get(i).getNum() + " has lost to the dealer.");
                                players.remove(i);
                            }
                        } else {
                            System.out.println("\nPlayer " + players.get(i).getNum() + " has " + ((players.get(i).getTotalValue() > dealer.getTotalValue()) ? ("won against ") : 
                            ((players.get(i).getTotalValue() < dealer.getTotalValue()) ? ("lost to ") : ("tied with "))) + "the dealer.");
                            players.remove(i);
                        }
                    } else if (players.get(i).getTotalValue() > dealer.getTotalValue()) {
                        System.out.println("\nPlayer " + players.get(i).getNum() + " has beat the dealer!");
                        players.remove(i);
                    } else {
                        System.out.println("\nPlayer " + players.get(i).getNum() + " has tied with the dealer!");
                        players.remove(i);
                    }
                }

                if (dealer.getTotalValue() < 17) {
                    dealer.addCard(deck.dealCard());

                    System.out.println("\nThe dealer hit and drew a " + dealer.getNewestCard() + 
                    " and now has a total value of " + dealer.getTotalValue() + ".");
                    if (dealer.getTotalValue() > 21) {
                        System.out.println("The dealer has lost. All players win!");

                        for (int i = 0; i < players.size(); i++) {
                            players.remove(i);
                        }
                    }
                }

                if (players.size() < 1) {
                    break round;
                }
            }
            System.out.println("\nWould you like to play again? (y/n)");
            choice = stdin.next();

            if (choice.length() > 0 && choice.substring(0,1).toLowerCase().equals("n")) {
                break playing;
            } else {
                dealer = new Hand();
                dealer.addCard(deck.dealCard());        
                dealer.addCard(deck.dealCard());
            }
        }
    }
}