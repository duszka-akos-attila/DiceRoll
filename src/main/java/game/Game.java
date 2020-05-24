package game;

@lombok.Data
public class Game {
    private Dice dice;
    private Field field;

    public Game() {
        this.dice = new Dice();
        this.field = new Field();
    }
}
