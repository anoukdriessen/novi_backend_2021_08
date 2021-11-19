package casino.games.blackjack;

import java.util.Scanner;

public abstract class BlackJackGame {
    // gebruik een Scanner voor de input
    protected Scanner in;

    // variabele om te controleren of het een actieve game is
    protected boolean isGameRunning;

    // variabele om te controleren of het spel gewonnen is
    protected boolean isGameWon;

    // de kaarten waarmee het spel gespeeld wordt
    protected Deck deck;

    // de spelers van het spel
    protected Player player;
    protected Dealer dealer;

    // constructor
    public BlackJackGame(Scanner in, Deck deck) {
        this.in = in;
        this.deck = deck;
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
        player.addCardFromDeck(deck.getNextCard(), deck.getNextCard());

        // zolang het spel actief is
        while (isGameRunning) {
            // speel een ronde
            playRound();
        }
    }

    /**
     * Methode om een ronde te spelen
     */
    abstract void playRound();
}
