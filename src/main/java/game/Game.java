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
}
