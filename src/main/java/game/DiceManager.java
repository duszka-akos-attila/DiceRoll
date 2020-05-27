package game;

/**
 * This class is responsible for the management of the Dice.
 */

public class DiceManager {

    /**
     * This method checks the game if the dice can roll to the
     * given direction and if it's can then calculate the state
     * of the dice after rolling using: @see canRoll, @see pairOf, @see getLeft.
     * @param game A game type parameter is needed, because the canRoll method
     *             have to check both the Field object and the Dice object
     *             to decide whether the dice can roll or not.
     * @param direction The Direction where the player want to move the dice.
     */

    public void rollDice(Game game, String direction){
        Dice dice = game.getDice();
        int[] position = new int[2];
        position[0]=dice.getPosition()[0];
        position[1]=dice.getPosition()[1];
        int onTop=dice.getOnTop();
        int onFront=dice.getOnFront();

        switch (direction){
            case("left"):
                if(canRoll(game,direction)) {
                    position[1] -= 1;
                    onTop=pairOf(getLeft(dice));
                    onFront=dice.getOnFront();
                }
                else{
                    return;
                }
                break;

            case("right"):
                if(canRoll(game,direction)) {
                    position[1] += 1;
                    onTop=getLeft(dice);
                    onFront=dice.getOnFront();
                }
                else{
                    return;
                }
                break;

            case("up"):
                if(canRoll(game,direction)) {
                    position[0] -= 1;
                    onTop=dice.getOnFront();
                    onFront=pairOf(dice.getOnTop());
                }
                else{
                    return;
                }
                break;

            case("down"):
                if(canRoll(game,direction)) {
                    position[0] += 1;
                    onTop=pairOf(dice.getOnFront());
                    onFront=dice.getOnTop();
                }
                else{
                    return;
                }
                break;

            default:

        }

        dice.setPosition(position);
        dice.setOnTop(onTop);
        dice.setOnFront(onFront);

        game.setDice(dice);
    }

    /**
     * The canRoll method checks for the @see rollDice method if a dice can roll to a given direction.
     * @param game It's need both a field and a dice to calculate the move.
     * @param direction The direction where the player want to move.
     * @return with true if the player can move to the given direction and false if not.
     */

    public boolean canRoll(Game game, String direction){
        Dice dice = game.getDice();
        Field field = game.getField();
        int[] targetPosition = {dice.getPosition()[0], dice.getPosition()[1]};
        int numberOnField;

        switch (direction) {
            case ("left"):
                if(game.getDice().getPosition()[1]-1>-1){
                    targetPosition[1] -= 1;
                    numberOnField = field.getFields()[targetPosition[0]][targetPosition[1]];
                    if(dice.getOnTop() == numberOnField || numberOnField == 0){
                        return true;
                    }
                }
                break;

            case ("right"):
                if(game.getDice().getPosition()[1]+1<5){
                    targetPosition[1] += 1;
                    numberOnField = field.getFields()[targetPosition[0]][targetPosition[1]];
                    if(dice.getOnTop() == numberOnField || numberOnField == 0){
                        return true;
                    }
                }
                break;

            case ("up"):
                if(dice.getPosition()[0]-1>-1){
                    targetPosition[0] -= 1;
                    numberOnField = field.getFields()[targetPosition[0]][targetPosition[1]];
                    if(dice.getOnTop() == numberOnField || numberOnField == 0){
                        return true;
                    }
                }
                break;

            case ("down"):
                if(dice.getPosition()[0]+1<6){
                    targetPosition[0] += 1;
                    numberOnField = field.getFields()[targetPosition[0]][targetPosition[1]];
                    if(dice.getOnTop() == numberOnField || numberOnField == 0){
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    /**
     * This method calculates the pair of the dice's given side.
     * @param n is the number on the dice which pair we want to find.
     * @return the pair of the @param n.
     */

    public int pairOf(int n){
        return 7-n;
    }

    /**
     * By the dice's two known face, this method can calculate the bigger one of the unknown face pair.
     * @param dice requires the dice's two face to calculate the other faces.
     * @return the bigger number from the unknown face pair.
     */

    public int maxRemaining(Dice dice){
        int biggerFromTopPair = getBiggerFromPair(dice.getOnTop());
        int biggerFromFrontPair = getBiggerFromPair(dice.getOnFront());
        return 15-biggerFromFrontPair-biggerFromTopPair;
    }

    /**
     * Calculate the bigger number of a pair.
     * @param n a face which will be compared to it's pair.
     * @return the number of the face which has the bigger value.
     */

    public int getBiggerFromPair(int n){
        if(n<4){
            return pairOf(n);
        }
        return n;
    }

    /**
     * Calculating the left face of dice with the know two faces. {@link Dice}
     * @param dice needs the dice object's two known face to determinate the left face.
     * @return the left face of the dice.
     */

    public int getLeft(Dice dice){
        int onTop = dice.getOnTop();
        int onFront = dice.getOnFront();
        int biggerRemaining = maxRemaining(dice);
        int smallerRemaining = pairOf(biggerRemaining);
        int result;

        if(onFront > 3){
            if(onFront > biggerRemaining){
                result = biggerRemaining;
            }
            else{
                result = smallerRemaining;
            }
        }
        else{
            if(onFront < smallerRemaining){
                result = smallerRemaining;
            }
            else{
                result = biggerRemaining;
            }
        }

        if(onTop % 2 == 1){
            return pairOf(result);
        }

        return result;

    }

}
