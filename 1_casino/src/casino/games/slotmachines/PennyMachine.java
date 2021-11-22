package casino.games.slotmachines;

public class PennyMachine extends SlotMachine {

    public PennyMachine() {
        super("Penny Slot Machine", 3);
    }

    @Override
    public int getPrice() {
        return 1;
    }

    @Override
    protected int payout() {
        boolean allStars = this.reelDeck.allHaveSymbol(Symbol.STAR);
        boolean allYinYangs = this.reelDeck.allHaveSymbol(Symbol.YINYANG);
        boolean allSpades = this.reelDeck.allHaveSymbol(Symbol.SPADE);
        boolean allHearts = this.reelDeck.allHaveSymbol(Symbol.HEART);
        boolean allClubs = this.reelDeck.allHaveSymbol(Symbol.CLUB);

        if (allStars) {
            return 5;
        } else if (allYinYangs) {
            return 10;
        } else if (allSpades) {
            return 15;
        } else if (allHearts) {
            return 20;
        } else if (allClubs) {
            return 25;
        }

        return 0;
    }

    @Override
    protected String howToWin() {
        return  "3 x stars = 5 tokens\n" +
                "3 x yinyang = 10 tokens\n" +
                "3 x spades = 15 tokens\n" +
                "3 x heart = 20 tokens\n" +
                "3 x club = 25 tokens\n";
    }
}
