package se.javierdlc.cardgame;

import se.javierdlc.cardgame.decks.FrenchDeck;

public class main {
    public static void main(String[] args) {
        FrenchDeck myDeck = new FrenchDeck();
        myDeck.shuffleDeck();
        System.out.println(myDeck.getCardsInPlay().size());

    }
}
