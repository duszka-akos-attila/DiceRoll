package game;

public class DiceManager {

    public void rollDown(Game game){
        Dice dice = game.getDice();
        if(canRollDown(game)){
            int[] position = new int[2];
            position[0]=dice.getPosition()[0] + 1;
            position[1]=dice.getPosition()[1];

            int onTop=pairOf(dice.getOnFront());

            int onFront=dice.getOnTop();

            dice.setPosition(position);
            dice.setOnTop(onTop);
            dice.setOnFront(onFront);

            game.setDice(dice);
        }
    }

    public void rollUp(Game game){
        Dice dice = game.getDice();
        if(canRollUp(game)){
            int[] position = new int[2];
            position[0]=dice.getPosition()[0] - 1;
            position[1]=dice.getPosition()[1];

            int onTop=dice.getOnFront();

            int onFront=pairOf(dice.getOnTop());

            dice.setPosition(position);
            dice.setOnTop(onTop);
            dice.setOnFront(onFront);

            game.setDice(dice);
        }
    }

    public void rollLeft(Game game){
        Dice dice = game.getDice();
        if(canRollLeft(game)){
            int[] position = new int[2];
            position[0]=dice.getPosition()[0];
            position[1]=dice.getPosition()[1] - 1;

            int onTop=pairOf(getLeft(dice));

            int onFront=dice.getOnFront();

            dice.setPosition(position);
            dice.setOnTop(onTop);
            dice.setOnFront(onFront);

            game.setDice(dice);
        }

    }

    public void rollRight(Game game){
        Dice dice = game.getDice();
        if(canRollLeft(game)){
            int[] position = new int[2];
            position[0]=dice.getPosition()[0];
            position[1]=dice.getPosition()[1] + 1;

            int onTop=getLeft(dice);

            int onFront=dice.getOnFront();

            dice.setPosition(position);
            dice.setOnTop(onTop);
            dice.setOnFront(onFront);

            game.setDice(dice);
        }
    }



    public boolean canRollDown(Game game){
        Dice dice = game.getDice();
        Field field = game.getField();

        if(dice.getPosition()[0]+1<6){
            int[] targetPosition ={dice.getPosition()[0] + 1, dice.getPosition()[1]};
            dice.setPosition(targetPosition);
            int numberOnField= field.getFields()[targetPosition[0]][targetPosition[1]];

            return dice.getOnTop() == numberOnField;
        }
        return false;
    }

    public boolean canRollUp(Game game){
        Dice dice = game.getDice();
        Field field = game.getField();

        if(dice.getPosition()[0]-1>-1){
            int[] targetPosition ={dice.getPosition()[0] - 1, dice.getPosition()[1]};
            dice.setPosition(targetPosition);
            int numberOnField= field.getFields()[targetPosition[0]][targetPosition[1]];

            return dice.getOnTop() == numberOnField;
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
