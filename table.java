package strasacamisa;

import java.util.*;

public class table {

    private Vector<card> tableStack;

    public table() {
        tableStack = new Vector<card>();
    }

    public boolean isEmpty() {
        return tableStack.size() == 0;
    }

    public card topCard() { // Looks at the first card.
        return tableStack.elementAt(tableStack.size()-1);
    }

    public void put(card newCard) {
        System.out.println("PUT");
        tableStack.add(newCard);
    }

    public deck getDeck() {
        return new deck(tableStack, false);
    }

    public void flush() {
        tableStack.removeAllElements();
    }
}
