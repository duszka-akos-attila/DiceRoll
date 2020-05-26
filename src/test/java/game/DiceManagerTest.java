package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceManagerTest {

    @Test
    void rollDice() {
        Game testGame = new Game();
        Dice controllDice = testGame.getDice();
        Dice testDice = testGame.getDice();
        DiceManager dm = new DiceManager();
        dm.rollDice(testGame, "left");
        testDice = testGame.getDice();
        assertEquals(controllDice,testDice);



//        dm.rollDice(testGame, "right");
//        testDice = testGame.getDice();
//        controllDice.setPosition(new int[]{0,1});
//        assertEquals(controllDice,testDice);
    }

    @Test
    void canRoll() {
    }

    @Test
    void getBiggerFromPair() {
    }

    @Test
    void getLeft() {
    }
}