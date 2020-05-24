package game;

public class DiceManager {

    public void rollDice(Game game, String direction){
        Dice dice = game.getDice();
        int[] position = new int[2];
        position[0]=dice.getPosition()[0];
        position[1]=dice.getPosition()[1];
        int onTop=dice.getOnTop();
        int onFront=dice.getOnFront();

        switch (direction){
            case("left"):
                if(canRollLeft(game)) {
                    position[1] -= 1;
                    onTop=pairOf(getLeft(dice));
                    onFront=dice.getOnFront();
                }
                else{
                    return;
                }
                break;

            case("right"):
                if(canRollRight(game)) {
                    position[1] += 1;
                    onTop=getLeft(dice);
                    onFront=dice.getOnFront();
                }
                else{
                    return;
                }
                break;

            case("up"):
                if(canRollUp(game)) {
                    position[0] -= 1;
                    onTop=dice.getOnFront();
                    onFront=pairOf(dice.getOnTop());
                }
                else{
                    return;
                }
                break;

            case("down"):
                if(canRollDown(game)) {
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
                    return dice.getOnTop() == numberOnField;
                }
                break;

            case ("right"):
                if(game.getDice().getPosition()[1]+1<5){
                    targetPosition[1] += 1;
                    numberOnField = field.getFields()[targetPosition[0]][targetPosition[1]];
                    return dice.getOnTop() == numberOnField;
                }
                break;

            case ("up"):
                if(dice.getPosition()[0]-1>-1){
                    targetPosition[0] -= 1;
                    numberOnField = field.getFields()[targetPosition[0]][targetPosition[1]];
                    return dice.getOnTop() == numberOnField;
                }
                break;

            case ("down"):
                if(dice.getPosition()[0]+1<6){
                    targetPosition[0] += 1;
                    numberOnField = field.getFields()[targetPosition[0]][targetPosition[1]];
                    return dice.getOnTop() == numberOnField;
                }
                break;
        }
        return false;
    }

    public boolean canRollLeft(Game game){
        Dice dice = game.getDice();
        Field field = game.getField();

        if(game.getDice().getPosition()[1]-1>-1){
            int[] targetPosition ={dice.getPosition()[0], dice.getPosition()[1] - 1};
            dice.setPosition(targetPosition);
            int numberOnField= field.getFields()[targetPosition[0]][targetPosition[1]];

            return dice.getOnTop() == numberOnField;
        }
        return false;
    }

    public boolean canRollRight(Game game){
        Dice dice = game.getDice();
        Field field = game.getField();

        if(game.getDice().getPosition()[1]+1<5){
            int[] targetPosition ={dice.getPosition()[0], dice.getPosition()[1] + 1};
            dice.setPosition(targetPosition);
            int numberOnField= field.getFields()[targetPosition[0]][targetPosition[1]];

            return dice.getOnTop() == numberOnField;
        }
        return false;
    }



    public int pairOf(int n){
        return 7-n;
    }

    public int maxRemaining(Dice dice){
        int biggerFromTopPair = getBiggerFromPair(dice.getOnTop());
        int biggerFromFrontPair = getBiggerFromPair(dice.getOnFront());
        return 16-biggerFromFrontPair-biggerFromTopPair;
    }

    public int getBiggerFromPair(int n){
        if(n<3){
            return pairOf(n);
        }
        return n;
    }

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
