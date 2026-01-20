import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Hand dealer = new Hand();
        dealer.addCard(deck.dealCard());        
        dealer.addCard(deck.dealCard());        

        ArrayList<Hand> players = new ArrayList<Hand>();

        Scanner stdin = new Scanner(System.in);

        System.out.printf("This is BlackJack!\nIn this game you are given two cards to start.")

    }
}