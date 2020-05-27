package result;

import game.DiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This class representing those games which was won by the player {@code name},
 * and the number of moves {@code moves} which was needed to win the game.
 * @see game
 */
@Entity
@lombok.Data
public class Result {

    private static final Logger logger = LoggerFactory.getLogger(Result.class);

    /**
     * An automatically generated identifier by the database.
     */
    @Id
    @GeneratedValue
    private long id;

    /**
     * The name what the player set to be represented with in the leaderboard.
     */
    @Column (nullable = false)
    private String name;

    /**
     * Number of moves what take the player to won the game.
     */
    @Column (nullable = false)
    private long moves;

    /**
     * The game mode what the player won in.
     */
    @Column (nullable = false)
    private String gameMode;

    /**
     * This method increases the class's moves named variable's value with one.
     */

    public void increaseMovesByOne(){
        logger.info("Number of moves was increased by one.");
        this.moves++;
    }

}
