package game;

@lombok.Data
public class Game {
    private Dice dice;
    private Field field;
    private boolean surrendered;

    public Game() {
        this.dice = new Dice();
        this.field = new Field();
        this.surrendered = false;
    }

    public boolean didWin(Game game){
        return game.dice.getPosition()[0] == 6 && game.dice.getPosition()[1] == 5;
    }

    public boolean didLost(Game game){
        return game.surrendered;
    }

    public boolean isGameOver(Game game){
        return didLost(game) || didWin(game);
    }
}
