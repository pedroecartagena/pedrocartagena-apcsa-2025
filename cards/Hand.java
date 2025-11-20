package cards;

public class Hand {
    private int size;
    private Card[] cards;

    public Hand(int maxSize) {
        cards = new Card[maxSize];
        size = 0;
    }

    public void add(Card card) {
        if (size < cards.length) {
            cards[size] = card;
            size++;
        }
    }

    public int length() {
        return size;
    }

    public Card get(int index) {
        return cards[index];
    }

    public Card remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Card removedCard = cards[index];
        for (int i = index; i < size - 1; i++) {
            cards[i] = cards[i + 1];
        }
        cards[size - 1] = null;
        size--;
        return removedCard;
    }
}
