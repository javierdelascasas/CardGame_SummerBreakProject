package se.javierdlc.cardgame.states;

import se.javierdlc.cardframework.Card;
import se.javierdlc.cardgame.CardGame;
import se.javierdlc.cardgame.decks.FrenchCard;
import se.javierdlc.cardgame.decks.FrenchDeck;
import se.javierdlc.cardgame.logic.GameLogic;
import se.javierdlc.cardgame.players.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState extends State {

    private GameLogic logic;
    private Player player;
    private Player hal9000;
    private FrenchDeck deck;
    private List<Component> playersButtons = new ArrayList<>();
    private List<Component> halsButtons = new ArrayList<>();
    private int playerFullSeries = 0;
    private int halFullSeries = 0;
    private int winCount = 0;
    private int loseCount = 0;
    private boolean gameover = false;
    private boolean newGame = true;
    private Random rnd = new Random();
    private Player playerOnTurn;

    public GameState(CardGame game) {
        super(game);
        this.player = new Player(true);
        this.hal9000 = new Player(false);
        this.logic = new GameLogic();
        this.playerOnTurn = player;

        JLabel win = new JLabel("W: " + winCount);
        JLabel lose = new JLabel("L: " + loseCount);
        JButton menu = new JButton("MENU");
        menu.addActionListener(game.getInputManager());
        menu.setActionCommand("400");
        componentList.add(win);
        componentList.add(lose);
        componentList.add(menu);
    }

    @Override
    public void update() {
        if (newGame) {
            this.deck = new FrenchDeck();
            logic.startNewGame(deck, player, hal9000);
            playerFullSeries = 0;
            halFullSeries = 0;
            newGame = false;
        }
        if (playerOnTurn.getCardsInHand().size() > 0) {
            List<Card> cardSeries;
            do {
                cardSeries = logic.checkIfFourInHand(playerOnTurn);
                if (cardSeries != null) {
                    for (Card card : cardSeries) {
                        playerOnTurn.getCardsInHand().remove(card);
                    }
                    if (playerOnTurn == player) {
                        playerFullSeries++;
                    } else {
                        halFullSeries++;
                    }
                }
            } while (cardSeries != null);
        } else {
            gameover = true;
            if(halFullSeries < playerFullSeries){
                winCount++;
            } else {
                loseCount++;
            }
            newGame = true;
            return;
        }
        if (playerOnTurn == hal9000 && hal9000.getCardsInHand().size() > 0) {
            System.out.println("Hal makes a move...");
            boolean hasCard;
            int halsChoice = rnd.nextInt(hal9000.getCardsInHand().size());
            if(halsChoice < 0){
                halsChoice = 0;
            }
            FrenchCard halsCard = (FrenchCard) hal9000.getCardsInHand().get(halsChoice);
            hasCard = logic.getCardsIfOpponentHasCards(hal9000,player,halsCard.getValue());
            logic.finishTurn(this,hasCard,deck,playerOnTurn);
            System.out.println("Player: " + playerFullSeries + " Hal9000: " + halFullSeries);
        }
        playersButtons.removeAll(playersButtons);
        halsButtons.removeAll(halsButtons);
        for (int i = 0; i < player.getCardsInHand().size(); i++) {
            FrenchCard card = (FrenchCard) player.getCardsInHand().get(i);
            JButton newBtn = new JButton(card.toString());
            newBtn.addActionListener(game.getInputManager());
            newBtn.setActionCommand(""+card.getValue());
            playersButtons.add(newBtn);
        }
        for (int i = 0; i < hal9000.getCardsInHand().size(); i++) {
            JButton newBtn = new JButton("Card");
            halsButtons.add(newBtn);
        }
    }

    @Override
    public void render() {
        game.getWindow().getUpperContainer().removeAll();
        game.getWindow().getMiddleContainer().removeAll();
        for (Component c : playersButtons) {
            if (c.getParent() == null) {
                game.getWindow().getMiddleContainer().add(c);
            }
        }
        for (Component c : halsButtons) {
            if (c.getParent() == null) {
                game.getWindow().getUpperContainer().add(c);
            }
        }
        game.getWindow().getUpperContainer().revalidate();
        game.getWindow().getMiddleContainer().revalidate();
        game.getWindow().getUpperContainer().repaint();
        game.getWindow().getMiddleContainer().repaint();
    }

    public Player getPlayer() {
        return player;
    }

    public Player getHal9000() {
        return hal9000;
    }

    public FrenchDeck getDeck() {
        return deck;
    }

    public Player getPlayerOnTurn() {
        return playerOnTurn;
    }

    public void setPlayerOnTurn(Player playerOnTurn) {
        this.playerOnTurn = playerOnTurn;
    }
}
