package se.javierdlc.cardgame.decks;

import se.javierdlc.cardframework.Card;
import se.javierdlc.cardframework.Deck;

import java.util.ArrayList;
import java.util.List;

public class FrenchDeck extends Deck {
    final private List<Card> STANDARD_FRENCHDECK = getStandard();
    private List<FrenchCard> cards;

    public FrenchDeck(){
        this.setCardsInPlay(STANDARD_FRENCHDECK);
    }

    private List<Card> getStandard(){
        List<Card> cards = new ArrayList<>();
        for (int i = 1; i < 14; i++) {
            Card newCard = new FrenchCard(FrenchCategories.HEARTS, i);
            cards.add(newCard);
            newCard = new FrenchCard(FrenchCategories.SPADES,i);
            cards.add(newCard);
            newCard = new FrenchCard(FrenchCategories.DIAMONDS, i);
            cards.add(newCard);
            newCard = new FrenchCard(FrenchCategories.CLOVES, i);
            cards.add(newCard);
        }
        return cards;
    }
}
