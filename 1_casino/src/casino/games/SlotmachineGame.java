package casino.games;

import casino.games.slotmachines.PennyMachine;
import casino.games.slotmachines.SlotMachine;

import java.util.Scanner;

public class SlotMachineGame {
    private Scanner in;
    private SlotMachine[] slotMachines;
    private SlotMachine active;

    private boolean isGameRunning;
    private int startToken;
    private int tokens;

    public SlotMachineGame(Scanner in) {
        this.in = in;
        this.slotMachines = new SlotMachine[] {
                new PennyMachine(),
                new HighRoller(),
                new FiveReeler()
        };
    }

    public void start() {
        isGameRunning = true;
        startToken = 100;
        tokens = startToken;

        this.active = machineChoice(tokens);
        this.active.intro();

        while( isGameRunning ) {
            playRound();
        }
    }

    private void playRound() {
        boolean enoughTokens = tokens < active.getPrice();

        if (enoughTokens) {
            System.out.println("Je hebt niet genoeg munten");
            isGameRunning = false;
            return;
        }

        String move = getNextMove();
        boolean stopPlaying = move.equals("s");
        if (stopPlaying) {
            System.out.printf("Bedankt voor het spelen, je hebt %d munten", tokens);
            isGameRunning = false;
        } else {
            this.tokens = tokens - active.getPrice();
            int profit = active.roll();
            this.tokens = tokens + profit;

            System.out.println(active.show());
            System.out.printf("Je hebt %d munten gewonnen\n", profit);
            System.out.printf("Je hebt nu %d munten\n", tokens);
        }
    }

    private SlotMachine machineChoice(int tokens) {
        while (true) {
            System.out.println("Welke machine wil je spelen?");
            System.out.println("0 = Penny\n 1 = High Roller\n 2 = 5-Reeler");

            int i = in.nextInt();
            
        }
    }
}
