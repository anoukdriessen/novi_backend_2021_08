package casino;
import casino.games.HigherLowerGame;
import casino.games.BlackJackGame;

import java.util.Scanner;

public class Main {
    private static FunStuff fn = new FunStuff();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welkom bij de Casino Opdracht");

        // spel 1. Higher Lower
//        System.out.println("Spel 1 HIGHER / LOWER");
//        try {
//            playHigherLower(in);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // spel 2. Blackjack
        System.out.println("Spel 2 Blackjack");
        try {
            playBlackJack(in);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to play Higher Lower
     * @param in de input die gebruikt moet worden
     * @throws InterruptedException vanuit Thread.sleep()
     */
    public static void playHigherLower(Scanner in) throws InterruptedException {
        HigherLowerGame hl = new HigherLowerGame(in);
        fn.countdown(3);
        hl.start();
    }

    /**
     * Method to play BlackJack
     * @param in de input die gebruikt moet worden
     * @throws InterruptedException vanuit Thread.sleep()
     */
    public static void playBlackJack(Scanner in) throws InterruptedException {
        BlackJackGame bj = new BlackJackGame(in);
        fn.countdown(3);
        bj.start();
    }
}
