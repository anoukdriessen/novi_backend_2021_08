package casino.games.blackjack;

import java.util.Random;
import java.util.Stack;

/**
 * onderdeel van spel blackjack
 */
public class Deck {
    // stack is een soort wachtrij
    // deck bevat een wachtrij van kaarten
    protected Stack<Card> cards;

    // constructor
    public Deck() {
        // stel de waardes en omslagen van de kaarten in
        CardSuit[] suits = createSuits();
        CardValue[] values = createValues();

        // maak een nieuwe Stack
        cards = new Stack<>();
        // voor iedere suit
        for (CardSuit suite : suits) {
            // voor iedere waarde
            for (CardValue value : values) {
                // voeg toe aan stack
                cards.add(new Card(suite, value));
            }
        }
    }

    /**
     * Methode om de Suits van de kaarten aan te maken
     * @return CardSuit[] lijst met beschikbare suits
     */
    public CardSuit[] createSuits() {
        return new CardSuit[] {
                new CardSuit("ruiten", '\u2666', "rood"),
                new CardSuit("klaveren", '\u2660', "zwart"),
                new CardSuit("harten", '\u2665', "rood"),
                new CardSuit("schoppen", '\u2663', "zwart")
        };
    }

    /**
     * Methode om de waardes van de kaarten aan te maken
     * @return CardValue[] lijst met beschikbare waardes
     */
    public CardValue[] createValues() {
        return new CardValue[] {
                new CardValue("twee", 2), new CardValue("drie", 3),
                new CardValue("vier", 4), new CardValue("vijf", 5),
                new CardValue("zes", 6), new CardValue("zeven", 7),
                new CardValue("acht", 8), new CardValue("negen", 9),
                new CardValue("tien", 10), new CardValue("boer", 10),
                new CardValue("vrouw", 10), new CardValue("koning", 10) };
    }

    /**
     * Methode om de kaarten te schudden
     */
    public void shuffle() {
        Random r = new Random();
        // de grote van het deck
        int sizeOfDeck = cards.size();

        // voor iedere kaart in het deck
        for (int i = 0; i < sizeOfDeck; i++) {
            // selecteer een random index
            int randomIndex = r.nextInt(sizeOfDeck);

            // de huidige kaart
            Card current = cards.get(i);
            // random geselecteerde kaart
            Card random = cards.get(randomIndex);

            // zet de random geselecteerde kaart op de huidige plek
            cards.set(i, random);
            // zet de huidige kaart op de plek van de random geselecteerde kaart
            cards.set(randomIndex, current);
        }
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card getNextCard() {
        return cards.pop();
    }
}
