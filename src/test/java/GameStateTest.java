package test.java;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import commandline.*;

import org.junit.jupiter.api.Test;


class GameStateTest {
    //Test GameState Object
    Deck deck = new Deck();
    GameState g = new GameState(deck, 5);

    @Test
    public void testGameStateConstructor() {
        GameState model = new GameState(deck, 5);
        assertNotNull(model);
    }
    //Tests active player by asserting current active player after game state creation is not null
    @Test
    public void testGetActivePlayer() {
        assertNotNull(g.getActivePlayer().getName());
    }

    //Tests set attribute and get attribute by setting the gamestate attribute and checking it equals attribute when getAttribute is called
    @Test
    public void testSetAttribute() {
        g.setCurrentAttribute(4);
        assertEquals(4, g.getCurrentAttribute());
    }
    
    //Tests get round number by called get round and checking it is set to 1 at beginning of game.
    @Test
    public void testGetRoundNumber() {
        assertEquals(1, g.getRoundNumber());
    }

    @Test
    public void testGetPlayersSize() {
        assertEquals(5, g.getPlayersSize());
    }

    @Test 
    public void testGetCommunalPileSize() {
        assertEquals(0, g.getCommunalPileSize());
    }

    @Test
    public void testDrawNewCard() {
        Card topCard = g.getHumanPlayer().getPlayerHand().newTopCard();
        g.drawNewCard();
        assertNotEquals(topCard, g.getHumanPlayer().getPlayerHand().newTopCard());
    }
}
