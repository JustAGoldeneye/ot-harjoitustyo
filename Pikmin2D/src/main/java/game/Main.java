package game;

import game.ui.GameArea;
import javafx.application.Application;

public class Main {
    public final static boolean DEBUG_MODE = true;
    /**
     * Launches the application.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Application.launch(GameArea.class);
    }
}
