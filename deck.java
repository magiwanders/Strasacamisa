package strasacamisa;

import java.util.*;

public class deck {

    private Vector<card> shuffledDeck;

    public deck() {
        shuffledDeck = getAllCards();
        shuffle();
    }

    public deck(Vector<card> partialDeck) {
        shuffledDeck = partialDeck;
        shuffle();
    }

    public deck(Vector<card> partialDeck, boolean shuffle) {
        shuffledDeck = partialDeck;
    }

    public deck(List<card> partialDeck) {
        shuffledDeck = toVector(partialDeck);
        shuffle();
    }

    private Vector<card> getAllCards() {
        Vector<card> listOfCards = new Vector<card>();

        listOfCards.add(new card("A", "Cuori"));
        listOfCards.add(new card("2", "Cuori"));
        listOfCards.add(new card("3", "Cuori"));
        listOfCards.add(new card("4", "Cuori"));
        listOfCards.add(new card("5", "Cuori"));
        listOfCards.add(new card("6", "Cuori"));
        listOfCards.add(new card("7", "Cuori"));
        listOfCards.add(new card("8", "Cuori"));
        listOfCards.add(new card("9", "Cuori"));
        listOfCards.add(new card("10", "Cuori"));
        listOfCards.add(new card("J", "Cuori"));
        listOfCards.add(new card("Q", "Cuori"));
        listOfCards.add(new card("K", "Cuori"));

        listOfCards.add(new card("A", "Quadri"));
        listOfCards.add(new card("2", "Quadri"));
        listOfCards.add(new card("3", "Quadri"));
        listOfCards.add(new card("4", "Quadri"));
        listOfCards.add(new card("5", "Quadri"));
        listOfCards.add(new card("6", "Quadri"));
        listOfCards.add(new card("7", "Quadri"));
        listOfCards.add(new card("8", "Quadri"));
        listOfCards.add(new card("9", "Quadri"));
        listOfCards.add(new card("10", "Quadri"));
        listOfCards.add(new card("J", "Quadri"));
        listOfCards.add(new card("Q", "Quadri"));
        listOfCards.add(new card("K", "Quadri"));

        listOfCards.add(new card("A", "Fiori"));
        listOfCards.add(new card("2", "Fiori"));
        listOfCards.add(new card("3", "Fiori"));
        listOfCards.add(new card("4", "Fiori"));
        listOfCards.add(new card("5", "Fiori"));
        listOfCards.add(new card("6", "Fiori"));
        listOfCards.add(new card("7", "Fiori"));
        listOfCards.add(new card("8", "Fiori"));
        listOfCards.add(new card("9", "Fiori"));
        listOfCards.add(new card("10", "Fiori"));
        listOfCards.add(new card("J", "Fiori"));
        listOfCards.add(new card("Q", "Fiori"));
        listOfCards.add(new card("K", "Fiori"));

        listOfCards.add(new card("A", "Picche"));
        listOfCards.add(new card("2", "Picche"));
        listOfCards.add(new card("3", "Picche"));
        listOfCards.add(new card("4", "Picche"));
        listOfCards.add(new card("5", "Picche"));
        listOfCards.add(new card("6", "Picche"));
        listOfCards.add(new card("7", "Picche"));
        listOfCards.add(new card("8", "Picche"));
        listOfCards.add(new card("9", "Picche"));
        listOfCards.add(new card("10", "Picche"));
        listOfCards.add(new card("J", "Picche"));
        listOfCards.add(new card("Q", "Picche"));
        listOfCards.add(new card("K", "Picche"));

        return listOfCards;
    }

    public void shuffle() { // Fa scambi nel vettore.
        Random rand = new Random();
        for(int i=0; i<(getNumberOfCards()*2); i++) {
            int thisOne = rand.nextInt(getNumberOfCards());
            int withThisOne = rand.nextInt(getNumberOfCards());
            swap(thisOne, withThisOne);
        }
    }

    public void swap(int thisOne, int withThisOne) {
        card externalHolder = shuffledDeck.elementAt(thisOne);
        shuffledDeck.set(thisOne, shuffledDeck.elementAt(withThisOne));
        shuffledDeck.set(withThisOne, externalHolder);
    }

    public int getNumberOfCards() {
        return shuffledDeck.size();
    }

    public deck getPartialDeck(int firstCard, int lastCard) {
        deck partialDeck = new deck(shuffledDeck.subList(firstCard, lastCard));
        shuffledDeck.subList(firstCard, lastCard).clear();
        return partialDeck;
    }

    public deck getHalfDeck() {
        return getPartialDeck(0, (getNumberOfCards()/2));
    }

    public card getTopCard() {
        card topCard = shuffledDeck.elementAt(0);
        shuffledDeck.removeElementAt(0);
        return topCard;
    }

    public void merge(deck loserDeck) {
        for(int i=0; i<loserDeck.getNumberOfCards(); i++) {
            shuffledDeck.add(loserDeck.getCard(i));
        }
    }

    public card getCard(int i) {
        return shuffledDeck.elementAt(i);
    }

    public Vector<card> toVector(List<card> list) {
        Vector<card> transformed = new Vector<card>();
        for(int i=0; i<list.size(); i++) {
            transformed.add(list.get(i));
        }
        return transformed;
    }

    public boolean isEmpty() {
        return shuffledDeck.size() == 0;
    }

    public void append(deck loserDeck) {
        for(int i=0; i< loserDeck.getNumberOfCards(); i++) {
            shuffledDeck.add(loserDeck.getCard(i));
        }
    }

    public int size() {
        return shuffledDeck.size();
    }

}
