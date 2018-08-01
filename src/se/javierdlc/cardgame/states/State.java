package se.javierdlc.cardgame.states;

import se.javierdlc.cardgame.CardGame;
import se.javierdlc.cardgame.graphics.CustomColors;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class State {
    protected CardGame game;
    protected List<Component> componentList = new ArrayList<>();

    public State(CardGame game) {
        this.game = game;
    }

    public void init() {
        for(Component c:componentList){
            c.setFont(new Font("Verdana",Font.PLAIN,18));
            c.setForeground(Color.WHITE);
            c.setBackground(CustomColors.DARK_ONE.getColor());
            game.getWindow().getLowerContainer().add(c);
        }
    }

    public void terminate() {
        game.getWindow().getUpperContainer().removeAll();
        game.getWindow().getMiddleContainer().removeAll();
        game.getWindow().getLowerContainer().removeAll();
        game.getWindow().getUpperContainer().revalidate();
        game.getWindow().getMiddleContainer().revalidate();
        game.getWindow().getLowerContainer().revalidate();
        game.getWindow().getUpperContainer().repaint();
        game.getWindow().getMiddleContainer().repaint();
        game.getWindow().getLowerContainer().repaint();
    }

    public abstract void update();

    public abstract void render();
}
