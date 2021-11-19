package casino.games.blackjack;

/**
 * Onderdeel van spel Blackjack
 */
public class CardValue {
    // de naam
    private String name;
    // de waarde
    private int value;

    // constructor
    public CardValue(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // getters
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
