package se.javierdlc.cardgame.states;

import se.javierdlc.cardgame.CardGame;
import se.javierdlc.cardgame.decks.FrenchCard;
import se.javierdlc.cardgame.decks.FrenchDeck;
import se.javierdlc.cardgame.logic.GameLogic;
import se.javierdlc.cardgame.players.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameState extends State {

    private GameLogic logic;
    private Player player;
    private Player hal9000;
    private FrenchDeck deck;
    private List<Component> playersButtons = new ArrayList<>();
    private List<Component> halsButtons = new ArrayList<>();
    private int winCount = 0;
    private int loseCount = 0;
    private boolean gameover = false;
    private boolean newGame = true;
    private boolean playersTurn = true;

    public GameState(CardGame game) {
        super(game);
        this.player = new Player(true);
        this.hal9000 = new Player(false);
        this.logic = new GameLogic();
        this.deck = new FrenchDeck();

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
            logic.startNewGame(deck, player, hal9000);
            newGame = false;
        }
        playersButtons.removeAll(playersButtons);
        halsButtons.removeAll(halsButtons);
        for (int i = 0; i < player.getCardsInHand().size(); i++) {
            FrenchCard card = (FrenchCard) player.getCardsInHand().get(i);
            JButton newBtn = new JButton(card.toString());
            newBtn.addActionListener(game.getInputManager());
            newBtn.setActionCommand("" + i);
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
            if(c.getParent() == null) {
                game.getWindow().getMiddleContainer().add(c);
            }
        }
        for (Component c : halsButtons) {
            if(c.getParent() == null) {
                game.getWindow().getUpperContainer().add(c);
            }
        }
        game.getWindow().getUpperContainer().revalidate();
        game.getWindow().getMiddleContainer().revalidate();
        game.getWindow().getUpperContainer().repaint();
        game.getWindow().getMiddleContainer().repaint();
    }
}
