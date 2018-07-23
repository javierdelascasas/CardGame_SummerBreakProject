package se.javierdlc.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Deck {
    private List<Card> cardsInPlay;

    // Methods
    public void shuffleDeck() {
        for (int i = 0; i < 20; i++) {
            shuffleDeckOneTime();
        }
    }

    public Card getCardOnTop() {
        if (cardsInPlay.size() > 0) {
            return cardsInPlay.remove(0);
        } else {
            return null;
        }
    }

    public void putCardOnTop(Card card) {
        cardsInPlay.add(0, card);
    }

    private void shuffleDeckOneTime() {
        List<Card> tempDeck = new ArrayList<>();
        List<Card> tempDeckA = new ArrayList<>();
        List<Card> tempDeckB = new ArrayList<>();
        Random rnd = new Random();
        copyDeck(getRandomCardPosition(), tempDeckA);
        copyDeck(0, tempDeckB);
        while (tempDeckA.size() > 0 && tempDeckB.size() > 0) {
            int probability = rnd.nextInt(2);
            if (probability == 0) {
                tempDeck.add(tempDeckA.remove(0));
            } else {
                tempDeck.add(tempDeckB.remove(0));
            }
        }
        while (tempDeckA.size() > 0) {
            tempDeck.add(tempDeckA.remove(0));
        }
        while (tempDeckB.size() > 0) {
            tempDeck.add(tempDeckB.remove(0));
        }
        cardsInPlay = tempDeck;
    }

    public void cutAndMergeDeck() {
        List<Card> tempDeck = new ArrayList<>();
        copyDeck(getRandomCardPosition(), tempDeck);
        copyDeck(0, tempDeck);
        cardsInPlay = tempDeck;
    }

    private int getRandomCardPosition() {
        Random rnd = new Random();
        return rnd.nextInt(cardsInPlay.size()) + 1;
    }

    private void copyDeck(int index, List<Card> tempDeck) {
        for (int i = index; i < cardsInPlay.size(); i++) {
            tempDeck.add(cardsInPlay.remove(i));
            i--;
        }
    }


    // Getters and Setters
    public List<? extends Card> getCardsInPlay() {
        return cardsInPlay;
    }

    public void setCardsInPlay(List<Card> cardsInPlay) {
        this.cardsInPlay = cardsInPlay;
    }
}
