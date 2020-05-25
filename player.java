package strasacamisa;

import java.io.*;
import java.util.*;

public class player {

    private deck halfDeck;
    private table table;

    public player(deck halfDeck, table table) {
        this.halfDeck = halfDeck;
        this.table = table;
    }

    public boolean move() {
        System.out.println("Il tavolo è vuoto? " + table.isEmpty());
        if(halfDeck.isEmpty()) return true;
        if(!table.isEmpty()) { // Quando ci sono carte
            System.out.println("Ci sono già carte.");
            if(table.topCard().getType().equals("A")) return specialMove(1);
            if(table.topCard().getType().equals("2")) return specialMove(2);
            if(table.topCard().getType().equals("3")) return specialMove(3);
            else putDownCard();
        //    new Scanner(System.in).nextLine();
        } else{
            System.out.println("Il tavolo era vuoto: inizio.");
            if(halfDeck.isEmpty()) return true;
            putDownCard();
        }
        return false;
    }

    public deck getDeck() {
        return halfDeck;
    }

    private boolean specialMove(int n) {
        System.out.println("È uscito un " + n);
        for(int i=0; i<n; i++) {
            if(halfDeck.isEmpty()) return true;
            putDownCard();
            if (table.topCard().getType().equals("A") || table.topCard().getType().equals("2") || table.topCard().getType().equals("3")) return false;
        }
        return true;
    }

    private void putDownCard() {
        card cardToPutDown = halfDeck.getTopCard();
        System.out.println("Metto giù la carta " + cardToPutDown.toString());
        table.put(cardToPutDown);
    }

    public void fetchTable() {
        System.out.println("Tira su.");
        halfDeck.append(table.getDeck());
        table.flush();
    }

    public void printDeck() {
        System.out.println("Mazzo:");
        for(int i=0; i<halfDeck.size(); i++) {
            System.out.println("Carta: " + halfDeck.getCard(i).toString());
        }
    }

}
