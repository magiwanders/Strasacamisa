package strasacamisa;

import java.io.*;
import java.util.*;
import java.sql.Timestamp;

public class strasacamisa {

    private deck deck;
    private player player1;
    private player player2;
    private table table;
    private PrintWriter w;
    private int numberOfMoves;
    private int numberOfIterations;
    private int player1Wins;
    private int player2Wins;

    public strasacamisa(int numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
        player1Wins = 0;
        player2Wins = 0;

        try {
            String timestamp = (new Timestamp(System.currentTimeMillis()).toString());
            w = new PrintWriter(new FileWriter(new File("/home/magiwanders/Documents/Studio/MusicEngineering/IngegneriaDelSoftware/Self_Laboratory/strasacamisa/games/gameTest_" + timestamp + ".txt"), true));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Inizio test: ");
            playTest();
        }
    }

    private void playTest() {
        for(int i=0; i<numberOfIterations; i++) {

            deck = new deck();
            table = new table();

            player1 = new player(deck.getHalfDeck(), table);
            player2 = new player(deck, table);

            player1.printDeck();
            player2.printDeck();

            System.out.println("Gioco No."+i);
            numberOfMoves=0;
            playGame();
        }
        w.println();
        w.println("Wins by player 1: " + player1Wins);
        w.println("Wins by player 2: " + player2Wins);
        try{
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void playGame() {
        boolean player1Won = false;
        boolean player2Won = false;
        boolean player1LostHand = false;
        boolean player2LostHand = false;

        while(!player1Won && !player2Won) {

            System.out.println("Nuova mano.");

            while(true) { // Fintantochè qualcuno non perde.
                System.out.println("Player 1:");
                if(!(!player1LostHand && player2LostHand)) {
                    player1LostHand=player1.move();
                    player2LostHand = false;
                }
                if(player1LostHand) break;
                numberOfMoves++;
                System.out.println("Player 2:");
                player2LostHand=player2.move();
                if(player2LostHand) break;
                numberOfMoves++;
            }
            if(player1LostHand) player1.fetchTable();
            if(player2LostHand) player2.fetchTable();
            if(player1.getDeck().getNumberOfCards() == 0) player1Won = true;
            if(player2.getDeck().getNumberOfCards() == 0) player2Won = true;
        }

        w.println("" + numberOfMoves);
        if (player1Won) player1Wins++;
        else player2Wins++;
    }

    public static void main(String [] args) {
        strasacamisa game = new strasacamisa(Integer.parseInt(args[0]));
    }
}
