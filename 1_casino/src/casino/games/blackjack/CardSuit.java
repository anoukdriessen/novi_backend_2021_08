package casino.games.blackjack;

/**
 * Onderdeel van het spel blackjack
 */
public class CardSuit {
    // de naam
    private String name;
    // het symbool
    private char symbol;
    // de kleur
    private String color;

    // constructor
    public CardSuit(String name, char symbol, String color) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
    }

    // getters
    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
