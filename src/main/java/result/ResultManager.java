package result;

import main.DiceRollApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * This class managing the game results and
 * the database operations.
 * @see Result
 */

public class ResultManager {

    private static final Logger logger = LoggerFactory.getLogger(ResultManager.class);

    /**
     * Object that represents game result.
     */

    private Result result;

    /**
     * Object for database communication.
     */

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("diceroll");

    /**
     * Method to upload result to the database.
     * {@link Result}
     */

    public void uploadResult(){
        result= DiceRollApplication.result;
        EntityManager em = emf.createEntityManager();

        try {
            logger.trace("Connecting to database...");
            em.getTransaction().begin();
            em.persist(this.result);
            em.getTransaction().commit();
            logger.trace("Data successfully transfered to database!");
        } finally{
            em.close();
        }
    }

    /**
     * Method to download leaderboard.
     * @param gameMode specify which game mode's leaderboard to download.
     * @return a leaderboard which is a list of results
     * {@link Result}
     */

    public static List<Result> downloadResults(String gameMode) {
        EntityManager em = emf.createEntityManager();

        logger.trace("Connecting to the database to download results...");
        try {
            List<Result> results = em.createQuery("SELECT r FROM Result r WHERE r.gameMode LIKE :gameMode ORDER BY r.moves", Result.class)
                    .setParameter("gameMode", gameMode)
                    .setMaxResults(100)
                    .getResultList();
            logger.trace("Successfully downloaded the leaderboard!");
            return results;
        } finally{
            em.close();
        }
    }

    /**
     * Closes connection with the database.
     */

    public void closeEMF(){
        emf.close();
        logger.info("Connection to the database closed!");
    }

}
