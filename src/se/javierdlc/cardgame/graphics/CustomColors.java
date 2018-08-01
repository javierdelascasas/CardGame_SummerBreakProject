package se.javierdlc.cardgame.graphics;

import java.awt.*;

public enum CustomColors {
    PRIMARY_ONE(new Color(86,187,255)),
    PRIMARY_TWO(new Color(204,203,49)),
    PRIMARY_THREE(new Color(178,178,51)),
    DARK_ONE(new Color(42,124,178)),
    CONTRAST_ONE(new Color(255,113,112)),;

    private Color color;

    CustomColors(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }
}
