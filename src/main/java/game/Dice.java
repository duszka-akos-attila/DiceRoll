package game;

/**
 * This class representing the Dice in the game.
 */

@lombok.Data
public class Dice {

    /**
     * This variable contains the number on the top face of the dice.
     */

    private int onTop;

    /**
     * This variable contains the number on the front face of the dice.
     */

    private int onFront;

    /**
     * This array contains the coordinates of the dice on the play field.
     * {@link Field}
     */

    private int[] position;

    /**
     * The standard constructor of the Dice is setting onTop variable to six,
     * onFront variable to 4 and the position of the dice to the top left corner
     * of the Field.
     */

    public Dice() {
        this.onTop = 6;
        this.onFront = 4;
        this.position = new int[] {0,0};
    }
}
