package casino.games.blackjack;

public class Player {
    // de kaarten van de speler
    public Hand hand;

    // variabele om moves te checken
    boolean isBust;
    boolean isStaying;

    // constructor
    public Player() {
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
     * Methode om te controleren of de player bust is
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
     * Methode om te controleren of de player staying is
     */
    public boolean isStaying() {
        return this.isStaying;
    }

    /**
     * Methode om de waarde van de kaarten van de player weer te geven
     */
    public int getValue() {
        return hand.getValue();
    }

    /**
     * Methode om een Move uit te voeren
     * @param deckToUse het kaarten Deck dat gebruikt moet worden
     * @param moveToDo de Move die uitgevoerd moet worden
     */
    public void doMove(Deck deckToUse, String moveToDo) {
        boolean moveIsHit = moveToDo.equalsIgnoreCase("hit");
        boolean moveIsStay = moveToDo.equalsIgnoreCase("stay");

        if (moveIsHit) {
            this.hand.addCard(deckToUse.getNextCard());
            System.out.println("Player HITS\n");
        } else if (moveIsStay) {
            this.isStaying = true;
            System.out.println("Player STAYS\n");
        }
    }

    /**
     * Methode om de kaarten van de player te tonen
     */
    public String showHand() {
        return hand.show();
    }
}
