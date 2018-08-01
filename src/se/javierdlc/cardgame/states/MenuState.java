package se.javierdlc.cardgame.states;

import se.javierdlc.cardgame.CardGame;
import se.javierdlc.cardgame.input.InputManager;

import javax.swing.*;

public class MenuState extends State {
    private InputManager inputManager;


    public MenuState(CardGame game) {
        super(game);
        this.inputManager = game.getInputManager();
        JButton start = new JButton("START");
        start.addActionListener(inputManager);
        start.setActionCommand("100");
        componentList.add(start);
        JButton highScore = new JButton("HIGH-SCORE");
        highScore.addActionListener(inputManager);
        highScore.setActionCommand("200");
        componentList.add(highScore);
        JButton quit = new JButton("QUIT");
        quit.addActionListener(inputManager);
        quit.setActionCommand("300");
        componentList.add(quit);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }
}
