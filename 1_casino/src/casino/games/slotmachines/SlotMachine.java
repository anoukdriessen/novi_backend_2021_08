package casino.games.slotmachines;


import java.util.ArrayList;
import java.util.List;

public abstract class SlotMachine {
    // de naam van de machine
    private String name;
    // het deck dat op de reel zit
    protected ReelDeck reelDeck;

    public static void main(String[] args) {
        fancyLine();
//        System.out.println("\n" + this.name);
        System.out.println("\n naam");
        fancyLine();
        System.out.println("\n how to win");
//        System.out.println("\n" + howToWin());
        fancyLine();
    }

    // constructor
    public SlotMachine(String name, int numOfReels) {
        this.name = name;

        // alle reels samen in een lijst genaamd reels
        List<Reel> reels = new ArrayList<>();
        for (int i = 0; i < numOfReels; i++) {
            reels.add(new Reel());
        }

        // maak een reelDeck van de reels
//        this.reelDeck = new ReelDeck(reels);
    }

    public void intro() {
        fancyLine();
        System.out.println("\n" + this.name);
        fancyLine();
        System.out.println("\n how to win");
        System.out.println("\n" + howToWin());
        fancyLine();
    }

    public static void fancyLine() {
        for (int i = 0; i < 6; i++) {
            System.out.print("$__$__$");
        }
    }

    public int roll() {
        reelDeck.roll();
        return payout();
    }

    public String show() {
        return reelDeck.show();
    }

    public abstract int getPrice();
    protected abstract int payout();
    protected abstract String howToWin();
}
