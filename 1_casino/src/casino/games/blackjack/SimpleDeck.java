package casino.games.blackjack;

public class SimpleDeck extends Deck {

    // constructor
    public SimpleDeck() {
        super(
                new CardSuit[] {
                    new CardSuit("ruiten", '\u2666', "rood"),
                    new CardSuit("klaveren", '\u2660', "zwart"),
                    new CardSuit("harten", '\u2665', "rood"),
                    new CardSuit("schoppen", '\u2663', "zwart")
                },
                new CardValue[] {
                    new CardValue("twee", 2), new CardValue("drie", 3),
                    new CardValue("vier", 4), new CardValue("vijf", 5),
                    new CardValue("zes", 6), new CardValue("zeven", 7),
                    new CardValue("acht", 8), new CardValue("negen", 9),
                    new CardValue("tien", 10), new CardValue("boer", 10),
                    new CardValue("vrouw", 10), new CardValue("koning", 10)
                },
                1
        );
    }
}
