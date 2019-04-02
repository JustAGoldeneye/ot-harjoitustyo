package game.ui;

import game.domain.Player;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class GameArea extends Application {
    static double paneWidth;
    static double paneHeight;
    static Player player;
    //Use a list if there are multiple objects of the same type.

    @Override
    public void start(Stage stage) throws Exception {
        
        importMapInfo("maps/testmap1.pkmp");
        
        Pane screen = new Pane();
        screen.setPrefSize(paneWidth, paneHeight);
        
        screen.getChildren().add(player.getPlayer());
        
        Scene scene = new Scene(screen);
        stage.setScene(scene);
        stage.setTitle("Pikmin 2D");
        stage.show();
        
        Map<KeyCode, Boolean> pressedButtons = new HashMap<>();
        
        scene.setOnKeyPressed(event -> {
           pressedButtons.put(event.getCode(), Boolean.TRUE);
        });
        scene.setOnKeyReleased(event -> {
           pressedButtons.put(event.getCode(), Boolean.FALSE);
           player.stop();
        });
        
        new AnimationTimer() {
            
            @Override
            public void handle(long current) {
                if (pressedButtons.getOrDefault(KeyCode.A, false)) {
                    player.turnLeft();
                }
                if (pressedButtons.getOrDefault(KeyCode.D, false)) {
                    player.turnRight();
                }
                if (pressedButtons.getOrDefault(KeyCode.W, false)) {
                    player.accelerate();
                }
                
                player.move();
            }
        }.start();
    }
    
    public void importMapInfo(String fileName) {
        try (Scanner fReader = new Scanner(new File(fileName))) {
            
            boolean firstRow = true;
            while (fReader.hasNextLine()) {
                String row = fReader.nextLine();          
                String[] rowDivide = row.split("#");
                String[] rowData = rowDivide[0].split(",");
                
                if (firstRow) {
                    firstRow = false;
                    paneWidth = Double.valueOf(rowData[0]);
                    paneHeight = Double.valueOf(rowData[1]);
                    
                } else if (rowData[0].equals("Player")) {
                    player = new Player(Double.valueOf(rowData[1]), Double.valueOf(rowData[2]), Double.valueOf(rowData[3]), Double.valueOf(rowData[4]), rowData[5]);
                } else {
                    System.out.println("Error: Row " + row + " in the map info file cannot be read. The object wasn't loaded.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
