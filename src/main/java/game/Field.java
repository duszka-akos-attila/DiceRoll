package game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  This class handle the game's play field.
 */

public class Field {

    private static final Logger logger = LoggerFactory.getLogger(Field.class);

    /**
     *  Contains the play field.
     *  The fields contains numbers between 0 and 6.
     */

    private int[][] fields;

    /**
     * Finalized play field for standard game play.
     */

    private final int[][] standardFields = {
            {4,6,2,5,1},
            {5,2,1,0,5},
            {6,2,3,1,5},
            {6,4,6,3,6},
            {5,3,4,5,1},
            {3,6,0,3,3}
    };

    /**
     * Constructor method for the Field objects, which create a Field with fields of 0.
     */

    public Field(){
        fields=new int[6][5];
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++) {
                fields[i][j]=0;
            }
        }
        logger.trace("Field was declared with zeros.");
    }

    /**
     * A setter method for the Field objects, which fill a Field with random fields.
     */

    public void randomizedFields(){
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++) {
                this.fields[i][j]=(int)(Math.random()*6);
            }
        }
        logger.info("Field was declared with RandomizedFields.");
    }

    /**
     * A setter method for the Field objects, which fill a Field with the standard fields.
     */

    public void loadStandardFields(){
        this.fields=standardFields;
        logger.info("Field was declared with loadStandardFields.");
    }


    /**
     * A setter method for the Field objects, which fill a Field with fields of 6.
     */

    public void loadFieldsWithSix(){
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++) {
                this.fields[i][j]=6;
            }
        }
        logger.trace("Field was declared with sixes.");
    }

    /**
     * Getter mehod for the play field.
     * @return the play field
     */

    public int[][] getFields() {
        return fields;
    }
}
