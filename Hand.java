import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private int num;

    public Hand() {
        this.cards = new ArrayList<Card>();
        num = -1;
    }

    public Hand(int num) {
        this.cards = new ArrayList<Card>();
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int getTotalValue() {
        int totalValue = 0;
        int currentValue = 0;
        int aces = 0;

        for (int i = 0; i < cards.size(); i++) {
            currentValue = cards.get(i).getValue();

            if (currentValue == -1) {
                return -1;
            } else if (currentValue == 1) {
                aces++;
            } else {
                totalValue += currentValue;
            }
        }

        while (aces > 0) {
            if (totalValue + 11 > 21 && aces < 2) {
                totalValue += 11;
                aces--;
            } else {
                totalValue++;
                aces--;
            }
        }

        return totalValue;
    }

    public String getNewestCard() {
        return cards.get(cards.size() - 1).toString();
    }

    public String toString() {
        String toReturn = "";

        for (int i = 0; i < cards.size(); i++) {
            if (i == cards.size() - 1) {
                toReturn += "and ";
            }

            toReturn += "a " + cards.get(i).toString() + ", ";
        }

        toReturn = toReturn.substring(0, toReturn.length() - 2);
        return toReturn;
    }
}