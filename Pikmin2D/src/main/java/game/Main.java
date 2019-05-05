package game;

import game.ui.GameArea;
import javafx.application.Application;

public class Main {
    /**
     * Toggles the debug mode.
     * Debug mode makes invisible object visible as DEEPPINK.
     */
    public static boolean debugMode = false;
    /**
     * Launches the application.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Application.launch(GameArea.class);
    }
}
