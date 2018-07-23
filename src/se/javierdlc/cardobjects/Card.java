package se.javierdlc.cardobjects;

public abstract class Card {
    private boolean visible;

    public Card() {
        this.visible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
