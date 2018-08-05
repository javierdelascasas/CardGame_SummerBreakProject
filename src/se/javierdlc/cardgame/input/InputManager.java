package se.javierdlc.cardgame.input;

import se.javierdlc.cardgame.CardGame;
import se.javierdlc.cardgame.logic.GameLogic;
import se.javierdlc.cardgame.states.GameState;
import se.javierdlc.cardgame.states.StateManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputManager implements ActionListener {
    private CardGame game;
    private GameLogic logic;
    private GameState state;

    public InputManager(CardGame cardGame, GameLogic logic) {
        this.game = cardGame;
        this.logic = logic;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("========================================================================================");
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
                System.out.println("You make a move...");
                boolean hasCard;
                hasCard = logic.getCardsIfOpponentHasCards(state.getPlayer(),state.getHal9000(),action);
                logic.finishTurn(state,hasCard,state.getDeck(),state.getPlayer());
        }
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
