package se.javierdlc.cardgame.logic;

import se.javierdlc.cardgame.decks.FrenchDeck;
import se.javierdlc.cardgame.players.Player;

public class GameLogic {
    public void startNewGame(FrenchDeck deck, Player player, Player hal9000){
        deck = new FrenchDeck();
        deck.shuffleDeck();
        for (int i = 0; i < 14; i++) {
            if (i % 2 == 0) {
                player.recieveCard(deck.getCardOnTop());
            } else {
                hal9000.recieveCard(deck.getCardOnTop());
            }
        }
    }
}
