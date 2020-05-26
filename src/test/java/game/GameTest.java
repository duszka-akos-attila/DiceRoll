package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void standardGame() {
        Game testGame = new Game();
        int[][] standardFieldSet = {{4,6,2,5,1},
                {5,2,1,0,5},
                {6,2,3,1,5},
                {6,4,6,3,6},
                {5,3,4,5,1},
                {3,6,0,3,3}};
        testGame.standardGame();
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                assertEquals(standardFieldSet[i][j] ,testGame.getField().getFields()[i][j]);
            }
        }
    }

    @Test
    void didWin() {
        Game testGame = new Game();
        assertFalse(testGame.didWin());
        testGame.getDice().setPosition(new int[] {5,4});
        assertTrue(testGame.didWin());
        testGame.getDice().setPosition(new int[] {0,4});
        assertFalse(testGame.didWin());
        testGame.getDice().setPosition(new int[] {5,0});
        assertFalse(testGame.didWin());
    }

    @Test
    void didLost() {
        Game testGame = new Game();
        assertFalse(testGame.didLost());
        testGame.forfeit();
        assertTrue(testGame.didLost());
    }

    @Test
    void isGameOver() {
        Game testGame = new Game();
        assertFalse(testGame.isGameOver());


        testGame.getDice().setPosition(new int[] {5,4});
        assertTrue(testGame.isGameOver());

        testGame.forfeit();
        assertTrue(testGame.isGameOver());

        testGame.getDice().setPosition(new int[] {0,0});
        assertTrue(testGame.isGameOver());


    }

    @Test
    void forfeit() {
        Game testGame = new Game();
        testGame.forfeit();
        assertTrue(testGame.isSurrendered());
    }

    @Test
    void setSurrendered() {
        Game testGame = new Game();
        testGame.setSurrendered(true);
        assertTrue(testGame.isSurrendered());
    }
}