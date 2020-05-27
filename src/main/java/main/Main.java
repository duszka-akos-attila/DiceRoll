package main;

import javafx.application.Application;

/**
 * The Main class which starts first when running the game's packaged jar file.
 */

public class Main {

    /**
     * The main method which starts the DiceRollApplication.
     * @param args are the given parameters what the user set when starting the program.
     */

    public static void main(String[] args) {
        Application.launch(DiceRollApplication.class, args);
    }
}
