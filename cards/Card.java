package cards;

public class Card {
    private int suite;
    private int value;

    public Card(int suite, int value) {
        this.suite = suite;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String[] suites = {"♠️", "♣️", "♥️", "♦️"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String suiteValue = suites[suite] + values[value - 1];
        return suiteValue;
    }
}
