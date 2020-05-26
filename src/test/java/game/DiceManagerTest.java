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

        //Test rolling dice to the right

        dm.rollDice(testGame, "right");
        testDice = testGame.getDice();
        controllDice.setPosition(new int[]{0,1});
        assertEquals(controllDice,testDice);

        dm.rollDice(testGame, "left");
        testDice = testGame.getDice();
        controllDice.setPosition(new int[]{0,0});
        assertEquals(controllDice,testDice);

        dm.rollDice(testGame, "up");
        testDice = testGame.getDice();
        assertEquals(controllDice,testDice);

        dm.rollDice(testGame, "down");
        testDice = testGame.getDice();
        controllDice.setPosition(new int[]{1,0});
        assertEquals(controllDice,testDice);

        dm.rollDice(testGame, "up");
        testDice = testGame.getDice();
        controllDice.setPosition(new int[]{0,0});
        assertEquals(controllDice,testDice);

        testGame.getDice().setPosition(new int[]{5,0});
        dm.rollDice(testGame, "down");
        testDice = testGame.getDice();
        controllDice.setPosition(new int[]{5,0});
        assertEquals(controllDice,testDice);

        testGame.getDice().setPosition(new int[]{0,4});
        dm.rollDice(testGame, "right");
        testDice = testGame.getDice();
        controllDice.setPosition(new int[]{0,4});
        assertEquals(controllDice,testDice);

        testGame.getDice().setPosition(new int[]{0,0});
        dm.rollDice(testGame, "forward");
        testDice = testGame.getDice();
        controllDice.setPosition(new int[]{0,0});
        assertEquals(controllDice,testDice);

    }

    @Test
    void canRoll() {
        Game testGame = new Game();
        DiceManager dm = new DiceManager();
        dm.canRoll(testGame, "forward");
        Dice testDice = testGame.getDice();
        testGame.getDice().setPosition(new int[]{3,2});

        testGame.getDice().setOnTop(0);
        assertTrue(dm.canRoll(testGame, "left"));
        testGame.getDice().setOnTop(0);
        assertTrue(dm.canRoll(testGame, "right"));
        testGame.getDice().setOnTop(0);
        assertTrue(dm.canRoll(testGame, "up"));
        testGame.getDice().setOnTop(0);
        assertTrue(dm.canRoll(testGame, "down"));

        testGame.getDice().setOnTop(6);
        assertTrue(dm.canRoll(testGame, "left"));
        testGame.getDice().setOnTop(6);
        assertTrue(dm.canRoll(testGame, "right"));
        testGame.getDice().setOnTop(6);
        assertTrue(dm.canRoll(testGame, "up"));
        testGame.getDice().setOnTop(6);
        assertTrue(dm.canRoll(testGame, "down"));

        testGame.getField().loadFieldsWithSix();
        testGame.getDice().setOnTop(5);
        assertFalse(dm.canRoll(testGame, "left"));
        testGame.getDice().setOnTop(5);
        assertFalse(dm.canRoll(testGame, "right"));
        testGame.getDice().setOnTop(5);
        assertFalse(dm.canRoll(testGame, "up"));
        testGame.getDice().setOnTop(5);
        assertFalse(dm.canRoll(testGame, "down"));



    }

    @Test
    void getBiggerFromPair() {
    }

    @Test
    void getLeft() {
    }
}