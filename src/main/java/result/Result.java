package result;

/**
 * This class representing those games which was won by the player {@code name},
 * and the number of moves {@code moves} which was needed to win the game.
 * @see game
 */
@lombok.Data
public class Result {

    /**
     * An automatically generated identifier by the database.
     */

    private long id;

    /**
     * The name what the player set to be represented with in the leaderboard.
     */

    private String name;

    /**
     * Number of moves what take the player to won the game.
     */

    private int moves;

    /**
     * The game mode what the player won in.
     */

    private String gameMode;

    /**
     * This method increases the class's moves named variable's value with one.
     */

    public void increaseMovesByOne(){
        this.moves++;
    }

}
