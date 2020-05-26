package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void loadStandardFields() {
        Field field = new Field();
        int[][] standardFieldSet = {{4,6,2,5,1},
        {5,2,1,0,5},
        {6,2,3,1,5},
        {6,4,6,3,6},
        {5,3,4,5,1},
        {3,6,0,3,3}};
        field.loadStandardFields();
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                assertEquals(standardFieldSet[i][j] ,field.getFields()[i][j]);
            }
        }
    }
}