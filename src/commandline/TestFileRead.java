package commandline;
import java.io.*;

/*
This file was created to test creation of a deck
Test the shuffle method and to test printing out cards/deck
*/
public class TestFileRead {

    public static void main(String args[]) {
        Deck deck = new Deck();

        deck.shuffleDeck();
        System.out.println(deck.getCard(5));
        System.out.println("===============================");
        deck.shuffleDeck();

        System.out.println(deck.getCard(5));
        System.out.println("===============================");
        deck.shuffleDeck();

        System.out.println(deck.getCard(5));
        System.out.println("===============================");

    }
}
