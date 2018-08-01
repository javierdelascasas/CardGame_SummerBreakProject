package se.javierdlc.cardgame.decks;

import se.javierdlc.cardframework.Card;

public class FrenchCard extends Card {
    private int value;
    private FrenchCategories category;

    public FrenchCard (FrenchCategories category, int value){
        super();
        setValue(value);
        setCategory(category);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public FrenchCategories getCategory() {
        return category;
    }

    public void setCategory(FrenchCategories category) {
        this.category = category;
    }

    public String toString(){
        return value + " " + category;
    }
}
