package casino.games.blackjack;

public class Dealer {
    // de kaarten van de speler
    public Hand hand;

    // variabele om moves te checken
    boolean isBust;
    boolean isStaying;

    // constructor
    public Dealer() {
        // maak een lege hand
        this.hand = new Hand();

        this.isBust = false;
        this.isStaying = false;
    }

    /**
     * Methode om een kaart te rapen
     */
    public void addCardFromDeck(Card... cardsToAdd) {
        // voor iedere kaart
        for (Card card : cardsToAdd) {
            // voeg toe aan hand
            hand.addCard(card);
        }
    }

    /**
     * Methode om te controleren of de dealer bust is
     */
    public boolean isBust() {
        // is bust als waarde over 21 heen gaat
        boolean valueOver21 = hand.getValue() > 21;
        if (valueOver21) {
            this.isBust = true;
        }
        return this.isBust;
    }

    /**
     * Methode om te controleren of de dealer staying is
     */
    public boolean isStaying() {
        return this.isStaying;
    }

    /**
     * Methode om de waarde van de kaarten van de dealer weer te geven
     */
    public int getValue() {
        return hand.getValue();
    }

    /**
     * Methode om een Move uit te voeren
     * @param deckToUse het kaarten deck wat gebruikt moet worden
     */
    public void doMove(Deck deckToUse) {
        boolean handValueLowerThan17 = hand.getValue() < 17;
        if (handValueLowerThan17) {
            hand.addCard(deckToUse.getNextCard());
            System.out.println("Dealer HITS\n");
        } else {
            System.out.println("Dealer STAYS\n");
            this.isStaying = true;
        }
    }

    /**
     * Methode om de kaarten van de dealer te tonen
     */
    public String showHand() {
        return hand.show();
    }
}
