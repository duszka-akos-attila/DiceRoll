package game;

/**
 *  This class handle the game management.
 */

@lombok.Data
public class Game {

    /**
     *  Contains the dice state.
     * @see Dice
     */

    private Dice dice;

    /**
     *  Contains the play field.
     * @see Field
     */

    private Field field;

    /**
     *  Indicates that a player surrendered.
     */

    private boolean surrendered;

    /**
     * Constructor method for the Game objects,
     * which create a Field with fields of 0,
     * set the dice to the default state and
     * initializing surrendered with a false value.
     */

    public Game() {
        this.dice = new Dice();
        this.field = new Field();
        this.surrendered = false;
    }

    /**
     * Calling the {@link Field#loadStandardFields} setter method for the Field object
     * if the game type is standard.
     */

    public void standardGame(){
        this.field.loadStandardFields();
    }

    /**
     * Calling the {@link Field#randomizedFields} setter method for the Field object
     * if the game type is randomized.
     */

    public void randomizedGame(){
        this.field.randomizedFields();
    }

    /**
     * This method checks if a player wins
     * which happens, when the dice reached the
     * play field's bottom right corner.
     * @return true when the player won the game, false if the game is not won.
     */

    public boolean didWin(){
        return this.dice.getPosition()[0] == 5 && this.dice.getPosition()[1] == 4;
    }

    /**
     * This method checks if a player lost
     * which happens, when the surrended variable's
     * value is true.
     * @return true when the player lost the game, false if the game is not lost.
     */

    public boolean didLost(){
        return this.surrendered;
    }

    /**
     * This method checks if the game is over
     * which happens, when the {@link #didWin} method or
     * the {@link #didLost} method returns true.
     * @return true when the game is over, false if the game is not over.
     */

    public boolean isGameOver(){
        return didLost() || didWin();
    }

    /**
     * This method set surrendered value to true, to indicate that a
     * player forfeited.
     */

    public void forfeit(){
        this.surrendered = true;
    }
}
