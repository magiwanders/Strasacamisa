package strasacamisa;

public class card {

    private String type;
    private String suit;

    public card(String type, String suit) {
        this.type = type;
        this.suit = suit;
    }

    public String getType() {
        return type;
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
        return type + " di " + suit;
    }
}
