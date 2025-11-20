package cards;

public class Deck {
    private Card[] cards;
    private int top;

    public Deck() {
        cards = new Card[52];
        int idx = 0;
        for (int suite = 0; suite < 4; suite++) {
            for (int value = 0; value < 13; value++) {
                cards[idx++] = new Card(suite, value + 1);
            }
        }
        this.shuffle();
        top = 0;
    }

    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int randIndex = (int) (Math.random() * cards.length);
            Card temp = cards[i];
            cards[i] = cards[randIndex];
            cards[randIndex] = temp;
        }
    }

    public void cut(int pos) {
        int cutSize = cards.length - pos;
        for(int i = 0, j = cutSize; i < cutSize; i++, j++) {
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public Card draw() {
        if (top >= cards.length - 1) {
            return null;
        }
        return cards[top++];
    }

    public void print(int value) {
        for (int i = 0; i <= value; i++) {
            System.out.print(cards[i].toString());
            System.out.print(" ");
        }
    }
}
