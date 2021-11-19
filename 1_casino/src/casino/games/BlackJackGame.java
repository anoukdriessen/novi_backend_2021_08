package casino.games;

import casino.FunStuff;
import casino.games.blackjack.Dealer;
import casino.games.blackjack.Deck;
import casino.games.blackjack.Player;

import java.util.Scanner;

/**
 * Spel is onderdeel van het Casino
 * de speler speelt het kaart spel Blackjack
 */
public class BlackJackGame {
    // gebruik een Scanner voor de input
    private Scanner in;

    // variabele om te controleren of het een actieve game is
    private boolean isGameRunning;

    // de kaarten waarmee het spel gespeeld wordt
     private Deck deck;

    // de spelers van het spel
     private Player player;
     private Dealer dealer;

    /**
     * Main methode om het spel te testen
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Spel Blackjack");
        Scanner in = new Scanner(System.in);
        BlackJackGame game = new BlackJackGame(in);
        FunStuff fs = new FunStuff();
        fs.countdown(3);
        game.start();
    }

    // constructor
    public BlackJackGame(Scanner in) {
        this.in = in;
         this.deck = new Deck();
    }

    /**
     * Methode om het spel te starten
     */
    public void start() {
        // stel de controle variabele in
        isGameRunning = true;

        // maak de spelers
         player = new Player();
         dealer = new Dealer();

        // schud de kaarten
        deck.shuffle();

        // geef de dealer 1 kaart
         dealer.addCardFromDeck(deck.getNextCard());
        // geef de speler 2 kaarten
         player.addCardFromDeck(deck.getNextCard());
         player.addCardFromDeck(deck.getNextCard());

        // zolang het spel actief is
        while (isGameRunning) {
            // speel een ronde
            playRound();
        }
    }

    /**
     * Methode om een ronde te spelen
     */
    public void playRound(){
        showInfo();

        // senario 1. dealer isBust OF dealer isStaying EN player heeft een hogere waarde dan dealer
        boolean dealerIsBustOrStaying = dealer.isBust() || dealer.isStaying();
        boolean playerHasHigherValue = player.getValue() > dealer.getValue();

        if (dealerIsBustOrStaying && playerHasHigherValue) {
            // speler heeft gewonnen
            System.out.println("Gefeliciteerd! Je hebt gewonnen!");
            // stop het spel
            isGameRunning = false;
            return;
        }

        // senario 2. player isBust OF player isStaying EN player heeft een lagere of gelijke waarde dan dealer
        boolean playerIsBustOrStaying = player.isBust() || player.isStaying();
        boolean playerHasLowerOrEqualValue = player.getValue() <= dealer.getValue();
        if (playerIsBustOrStaying && playerHasLowerOrEqualValue) {
            // speler heeft gewonnen
            System.out.println("Helaas.. je hebt verloren!");
            // stop het spel
            isGameRunning = false;
            return;
        }

        // senario 3 player heeft niet gekozen voor Stay
        if (!player.isStaying()) {
             String move = getNextMove();
             player.doMove(deck,move);


        }

        // senario 4 dealer heeft niet gekozen voor Stay en de player is niet Bust
         dealer.doMove(deck);
    }

    /**
     * Methode om een volgende Move op te halen
     * @return de move die uitgevoerd moet worden
     */
    private String getNextMove() {
            while (true) {
                System.out.println("Wat wil je doen? [HIT] of [STAY]");
                String choice = in.nextLine();

                boolean isHit = choice.equalsIgnoreCase("hit");
                boolean isStay = choice.equalsIgnoreCase("stay");

                if (isHit || isStay) {
                    // valid choice
                    return choice;
                } else {
                    System.out.println("Dat is geen geldige keuze, kies 'stay' of 'hit'");
                }
            }
        }

    /**
     * Methode om de kaarten te tonen van de Dealer en Speler
     */
    private void showInfo() {
        System.out.println("\nDealer:");
        System.out.println(dealer.showHand());
        System.out.println("\nPlayer:");
        System.out.println(player.showHand());
        System.out.println("");
    }


}
