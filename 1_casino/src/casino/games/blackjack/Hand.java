package casino.games.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Onderdeel van spel blackjack
 */
public class Hand {
    // een lijst met kaarten
    public List<Card> cards;

    // constructor
    public Hand() {
        this.cards = new ArrayList<>();
    }

    public int getValue() {
        // begin bij 0
        int total = 0;

        // voor iedere kaart in hand
        for (Card c : cards) {
            // voeg waarde toe aan totaal
            total += c.getValue();
        }

        return total;
    }

    /**
     * Methode om een kaart toe te voegen
     */
    public void addCard(Card cardToAdd) {
        this.cards.add(cardToAdd);
    }

    /**
     * Methode om de kaarten te tonen die in de hand zitten
     */
    public String show() {
        String out = "";

        // voor iedere kaart in hand
        for (Card c : cards) {
            out += c.render();
        }
        return out;
    }
}
