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
        if (index < 0 || index >= size) {
            return null;
        }
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(cards[i].toString());
            if (i < size - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
