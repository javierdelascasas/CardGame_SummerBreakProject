package se.javierdlc.cardgame;

import se.javierdlc.cardgame.graphics.Window;
import se.javierdlc.cardgame.input.InputManager;
import se.javierdlc.cardgame.logic.GameLogic;
import se.javierdlc.cardgame.states.GameState;
import se.javierdlc.cardgame.states.MenuState;
import se.javierdlc.cardgame.states.State;
import se.javierdlc.cardgame.states.StateManager;


public class CardGame {
    private boolean running;
    private Window window;
    private GameLogic logic;
    private InputManager inputManager;
    private State gameState;
    private State menuState;

    public CardGame() {
        startGame();
        loopGame();
    }

    private void startGame() {
        this.running = true;
        this.window = new Window("Cardgame");
        this.logic = new GameLogic();
        this.inputManager = new InputManager(this, logic);
        this.menuState = new MenuState(this);
        this.gameState = new GameState(this);
        StateManager.setCurrentState(menuState);
        this.inputManager.setState((GameState)gameState);

    }

    private void update() {
        if (StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().update();
        }
    }

    private void render() {
        if (StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().render();
        }
    }

    private void loopGame() {
        while (running) {
            update();
            render();
            try {
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }

    public Window getWindow() {
        return window;
    }

    public InputManager getInputManager() {
        return inputManager;
    }

    public State getGameState() {
        return gameState;
    }

    public State getMenuState() {
        return menuState;
    }
}
