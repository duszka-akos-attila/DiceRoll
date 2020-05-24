package game;

@lombok.Data
public class Dice {
    private int onTop;
    private int onFront;
    private int[] position;

    public Dice() {
        this.onTop = 6;
        this.onFront = 4;
        this.position = new int[] {0,0};
    }
}
