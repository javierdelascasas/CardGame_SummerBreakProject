package se.javierdlc.cardframework;

import java.util.ArrayList;
import java.util.List;

public abstract class CardHolder {
    private boolean human;
    private List<Card> cardsInHand;

    public CardHolder(boolean human) {
        this.human = human;
        this.cardsInHand = new ArrayList<>();
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public void recieveCard(Card card) {
        this.cardsInHand.add(card);
    }
}
