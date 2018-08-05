package se.javierdlc.cardgame.logic;

import se.javierdlc.cardframework.Card;
import se.javierdlc.cardgame.decks.FrenchCard;
import se.javierdlc.cardgame.decks.FrenchDeck;
import se.javierdlc.cardgame.players.Player;
import se.javierdlc.cardgame.states.GameState;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    public void startNewGame(FrenchDeck deck, Player player, Player hal9000) {
        deck.shuffleDeck();
        player.getCardsInHand().removeAll(player.getCardsInHand());
        hal9000.getCardsInHand().removeAll(hal9000.getCardsInHand());
        for (int i = 0; i < 14; i++) {
            if (i % 2 == 0) {
                player.recieveCard(deck.getCardOnTop());
            } else {
                hal9000.recieveCard(deck.getCardOnTop());
            }
        }
    }

    public List<Card> checkIfFourInHand(Player player) {
        List<Card> set;
        for (int j = 0; j < player.getCardsInHand().size(); j++) {
            set = new ArrayList<>();
            FrenchCard fCard = (FrenchCard) player.getCardsInHand().get(j);
            for (int i = 0; i < player.getCardsInHand().size(); i++) {
                FrenchCard fC = (FrenchCard) player.getCardsInHand().get(i);
                if (fC.getValue() == fCard.getValue()) {
                    set.add(fC);
                }
            }
            if (set.size() == 4) {
                return set;
            }
        }
        return null;
    }

    public boolean getCardsIfOpponentHasCards(Player receiver, Player giver, int value) {
        boolean hasCard = false;
        List<Card> toRemove = new ArrayList<>();
        for (Card card : giver.getCardsInHand()) {
            FrenchCard fCard = (FrenchCard) card;
            if (value == fCard.getValue()) {
                toRemove.add(card);
                hasCard = true;
            }
        }
        receiver.getCardsInHand().addAll(toRemove);
        giver.getCardsInHand().removeAll(toRemove);
        return hasCard;
    }

    public void finishTurn(GameState gameState, boolean opponentHadCard, FrenchDeck deck, Player player){
        if (!opponentHadCard){
            player.recieveCard(deck.getCardOnTop());
            System.out.println("Card from main deck, cards left on deck: " + deck.getCardsInPlay().size());
        } else  {
            System.out.println("Card from opponent");
        }
        if(player == gameState.getPlayer()){
            gameState.setPlayerOnTurn(gameState.getHal9000());
        } else {
            gameState.setPlayerOnTurn(gameState.getPlayer());
        }
    }
}
