package casino.games.blackjack;

/**
 * Onderdeel van spel Blackjack
 */
public class Card {
    private CardSuit suit;
    private CardValue value;

    // constructor
    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public String render() {
        return String.format("%s %s ", suit.getSymbol(), value);
    }

    public int getValue() {
        return value.getValue();
    }

    @Override
    public String toString() {
        return suit + " " + this.value;
    }
}
