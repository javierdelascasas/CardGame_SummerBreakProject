package se.javierdlc.cardgame;

import se.javierdlc.cardgame.graphics.Window;
import se.javierdlc.cardgame.input.InputManager;
import se.javierdlc.cardgame.states.GameState;
import se.javierdlc.cardgame.states.MenuState;
import se.javierdlc.cardgame.states.State;
import se.javierdlc.cardgame.states.StateManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class CardGame {
    private boolean running;
    private Window window;
//    private BufferStrategy bs;
//    private Graphics g;
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
        this.inputManager = new InputManager(this);
        this.menuState = new MenuState(this);
        this.gameState = new GameState(this);
        StateManager.setCurrentState(menuState);
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
