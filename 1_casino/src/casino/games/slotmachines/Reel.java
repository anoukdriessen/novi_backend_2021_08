package casino.games.slotmachines;

import java.util.Random;

public class Reel {
    private Symbol current;
    private Symbol[] allPossibleValues;

    // constructor
    public Reel() {
        this.allPossibleValues = Symbol.values();
    }

    public void roll() {
        Random r = new Random();
        // random getal met als bound de lijst van mogelijke symbolen
        int i = r.nextInt(allPossibleValues.length);
        // selecteer een random symbool
        this.current = allPossibleValues[i];
    }

    public String show() {
        return this.current.toString();
    }

    public Symbol getSymbol() {
        return this.current;
    }
}
