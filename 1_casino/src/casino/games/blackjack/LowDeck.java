package casino.games.blackjack;

/**
 * Zie abstract klasse Deck
 */
public class LowDeck extends Deck {

    public LowDeck() {
        super(
                new CardSuit[] {
                        new CardSuit("ruiten", '\u2666', "rood"),
                        new CardSuit("schoppen", '\u2660', "zwart"),
                        new CardSuit("harten", '\u2665', "rood"),
                        new CardSuit("klaveren", '\u2663', "zwart")
                },
                new CardValue[] {
                        new CardValue("twee", 2), new CardValue("drie", 3),
                        new CardValue("vier", 4), new CardValue("vijf", 5),
                        new CardValue("zes", 6)
                },
                3
        );
    }
}
