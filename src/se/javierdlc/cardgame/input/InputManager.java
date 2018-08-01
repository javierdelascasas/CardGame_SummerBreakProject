package se.javierdlc.cardgame.input;

import se.javierdlc.cardgame.CardGame;
import se.javierdlc.cardgame.decks.FrenchCard;
import se.javierdlc.cardgame.states.StateManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputManager implements ActionListener {
    private CardGame game;

    public InputManager(CardGame cardGame) {
        this.game = cardGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int action = Integer.parseInt(e.getActionCommand());
        switch (action) {
            case 100:
                StateManager.setCurrentState(game.getGameState());
                break;
            case 200:
                break;
            case 300:
                System.exit(0);
                break;
            case 400:
                StateManager.setCurrentState(game.getMenuState());
                break;
            default:
                
        }
    }
}
