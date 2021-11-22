package casino.games.slotmachines;

import java.util.List;

public class ReelDeck {
    private List<Reel> reels;

    // constructor
    public ReelDeck(List<Reel> reels) {
        this.reels = reels;
    }

    public void roll() {
        // voor iedere rell in het deck
        for (Reel r : reels) {
            // roll de reel
            r.roll();
        }
    }

    public String show() {
        String out = "";

        // voor iedere reel in het deck
        for (Reel r : reels) {
            out += r.show();
        }

        return out;
    }

    public boolean allHaveSymbol(Symbol symbol) {
        // voor iedere reel in het deck
        for (Reel r : reels) {
            if (r.getSymbol() != symbol) {
                return false;
            }
        }
        // als de code tot hier komt hebben ze allemaal hetzelfde symbool
        return true;
    }
}
