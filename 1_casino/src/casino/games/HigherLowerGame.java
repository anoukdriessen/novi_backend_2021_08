package casino.games;
import casino.FunStuff;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Spel is onderdeel van het Casino
 * De speler moet een getal raden
 */
public class HigherLowerGame {

    // gebruik een Scanner voor de input
    private Scanner in;
    // variabele om te controleren of het een actieve game is
    private boolean isGameRunning;

    // getal dat geraden moet worden
    private int toGuess;
    // het aantal rondes dat gespeeld is
    private int turns;

    // lijst voor de vorige geraden getallen in op te slaan
    private ArrayList<String> previousGuesses;

    /**
     * Main methode om het spel te testen
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Spel Higher Lower");
        Scanner in = new Scanner(System.in);
        HigherLowerGame game = new HigherLowerGame(in);
        FunStuff fs = new FunStuff();
        fs.countdown(3);
        game.start();
    }

    // constructor
    public HigherLowerGame(Scanner in) {
        // stel de scanner die gebruikt moet worden in
        this.in = in;
    }

    /**
     * Methode om het spel te starten
     */
    public void start() {
        // stel de controle variabele in
        isGameRunning = true;
        // genereer een random getal en stel de waarde in als toGuess
        toGuess = getRandomNumber(100);
        // begin met ronde 1
        turns = 1;
        // begin met een lege lijst
        previousGuesses = new ArrayList();

        // zolang het spel actief is
        while (isGameRunning) {
            // speel een ronde
            playRound();
        }
    }

    /**
     * Methode om een random getal te genereren
     * en terug te geven
     * @param bound de maximale waarde van het getal
     * @return int
     */
    public int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }

    /**
     * Methode om een ronde te spelen
     */
    public void playRound() {
        // toon info
        System.out.println("Ronde [" + turns + "]");
        System.out.println("Raad het getal...");

        if (turns != 1) {
            System.out.println("Het getal is: ");
            // niet de eerste ronde
            for (String guess : previousGuesses) {
                System.out.print(guess + " ");
            }
            System.out.println();
        }
        // haal de input op
        var userInput = in.nextInt();

        // kijk of het correct is
        checkGuess(userInput);
    }

    /**
     * Methode om te controleren of het juiste antwoord gegeven is
     */
    public void checkGuess(int guess) {
        // senario 1. gebruiker gokt goed
        // senario 2. gebruiker gokt te hoog
        // senario 3. gebruiker gokt te laag
        boolean correct = guess == toGuess;
        boolean tooHigh = guess > toGuess;

        if (correct) {
            // feliciteer de gebruiker
            System.out.print("\nCORRECT! je hebt het getal geraden in");
            if (turns == 1) {
                // enkelvoud
                System.out.print("de eerste beurt!");
            } else {
                // meervoud
                System.out.println(turns + " beurten!");
            }

            // stop het spel
            isGameRunning = false;
        } else if (tooHigh) {
            // voeg toe aan lijst
            previousGuesses.add("lager dan " + guess);
            // melding aan gebruiker
            System.out.println("Het getal is te hoog");
        } else {
            // voeg toe aan lijst
            previousGuesses.add("hoger dan " + guess);
            // melding aan gebruiker
            System.out.println("Het getal is te laag");
        }
        // speel volgende ronde
        turns++;
    }

}
