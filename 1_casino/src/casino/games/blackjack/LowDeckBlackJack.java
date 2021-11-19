package casino.games.blackjack;

import java.util.Scanner;

public class LowDeckBlackJack extends BlackJackGame {

    public LowDeckBlackJack(Scanner in) {
        super(in, new LowDeck());
    }

    public void playRound() {
        showInfo();

        // senario 1. player is bust of player is staying en de player's waarde is kleiner of gelijk aan de dealer's waarde
        boolean playerIsBustOrStaying = player.isBust() || player.isStaying();
        boolean playerValueLowerOrEqual = player.getValue() <= dealer.getValue();

        if (playerIsBustOrStaying && playerValueLowerOrEqual) {
            System.out.println("Helaas je hebt verloren");
            isGameRunning = false;
            isGameWon = false;
            return;
        }

        // senario 2. dealer is bust of dealer is staying en player heeft een hogere waarde dan dealer
        boolean dealerIsBustOrStaying = dealer.isBust() || dealer.isStaying();
        boolean playerHasHigherValue = player.getValue() > dealer.getValue();

        if (dealerIsBustOrStaying && playerHasHigherValue) {
            System.out.println("Gefelicteerd, je hebt gewonnen!");
            isGameRunning = false;
            isGameWon = true;
        }

        // senario 3. player doet move
        boolean playerDoesMove = !player.isStaying();
        if (playerDoesMove) {
            String move = getNextMove();
            player.doMove(deck, move);
        }

        // senario 4. dealer is niet staying en player is niet bust
        boolean dealerDoesMove = !dealer.isStaying() && !player.isBust();
        if (dealerDoesMove) {
            dealer.doMove(deck);
        }
    }

    /**
     * Methode om de volgende move van de gebruiker op te halen
     */
    public String getNextMove() {
        while(true) {
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

    public void showInfo(){
        System.out.println("\nDealer:");
        System.out.println(dealer.showHand());
        System.out.println("\nPlayer:");
        System.out.println(player.showHand());
        System.out.println("");
    }
}
