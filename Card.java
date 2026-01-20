public class Card {
    private final String face;
    private final String suit;

    public Card(String cardFace, String cardSuit) {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    public String toString() {
        return face + " of " + suit;
    }

    public int getValue() {
        switch(face) {
          case "Ace":
            return 11;
          case "Deuce":
            return 2;
          case "Three":
            return 3;
          case "Four":
            return 4;
          case "Five":
            return 5;
          case "Six":
            return 6;
          case "Seven":
            return 7;
          case "Eight":
            return 8;
          case "Nine":
            return 9;
          case "Ten":
            return 10;
          case "Jack":
            return 10;
          case "Queen":
            return 10;
          case "King":
            return 10;
          default:
            return -1;
        }
    }
}