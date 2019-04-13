package game.ui;

import game.domain.pikmin.RedPikmin;
import game.domain.pikmin.PikminType;
import game.domain.*;
import game.ui.pikmin.*;

import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

public class GameArea extends Application {
    static double paneWidth;
    static double paneHeight;
    
    static PlayerUI playerUI;
    static ArrayList<PikminUI> pikminUIs;

    @Override
    public void start(Stage stage) throws Exception {
        
        importMapInfo("maps/testmap1.pkmp");
        
        Pane screen = new Pane();
        screen.setPrefSize(paneWidth, paneHeight);
        
        Text redPikminCounterText = new Text(10, 20, "Red Pikmin: 0");
        screen.getChildren().add(redPikminCounterText);
        AtomicInteger redPikminCounter = new AtomicInteger();
        
        screen.getChildren().add(playerUI.getGameObjectShape());
        for (PikminUI pikminUI : pikminUIs) {
            screen.getChildren().add(pikminUI.gameObjectShape);
        }
        
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
           playerUI.stop();
        });
        
        new AnimationTimer() {
            
            @Override
            public void handle(long current) {
                if (pressedButtons.getOrDefault(KeyCode.A, false)) {
                    playerUI.turnLeft();
                }
                if (pressedButtons.getOrDefault(KeyCode.D, false)) {
                    playerUI.turnRight();
                }
                if (pressedButtons.getOrDefault(KeyCode.W, false)) {
                    playerUI.accelerate();
                }
                
                playerUI.move();
                
                List<PikminUI> collidedList = pikminUIs.stream()
                        .filter(pikminUI -> playerUI.collide(pikminUI))
                        .collect(Collectors.toList());
                collidedList.stream().forEach(collided -> {
                    
                    pikminUIs.remove(collided);                          
                    screen.getChildren().remove(collided.getGameObjectShape());
                    
                    playerUI.getPlayer().addPikmin(collided.getPikmin().getType());
                    
                    if (collided.getPikmin().getType() == PikminType.RED) {
                        redPikminCounterText.setText("Red Pikmin: " + redPikminCounter.addAndGet(1));
                    }
                });
            }
        }.start();
    }
    
    public void importMapInfo(String fileName) {
        try (Scanner fReader = new Scanner(new File(fileName))) {
            boolean firstRow = true;
            pikminUIs = new ArrayList<>();
            while (fReader.hasNextLine()) {
                String row = fReader.nextLine();
                if (row.startsWith("#") || row.isEmpty()) {
                    continue;
                }
                String[] rowDivide = row.split("#");
                String[] rowData = rowDivide[0].split(",");
                if (firstRow) {
                    firstRow = false;
                    paneWidth = Double.valueOf(rowData[0]);
                    paneHeight = Double.valueOf(rowData[1]);
                    
                } else if (rowData[0].equals("Player")) {
                    playerUI = new PlayerUI(Double.valueOf(rowData[1]), Double.valueOf(rowData[2]), Double.valueOf(rowData[3]), Double.valueOf(rowData[4]), rowData[5], new Player());
                    
                } else if (rowData[0].equals("Pikmin")) {
                         
                    if (rowData[1].equals("RED")) {
                        pikminUIs.add(new RedPikminUI(Double.valueOf(rowData[2]), Double.valueOf(rowData[3]), new RedPikmin()));
                    } else if (rowData[1].equals("YELLOW")) {
                        System.out.println("Error: PikminType marker on row " + row + " in the map info file was read but its feature hasn't been implemented yet. The object wasn't loaded.");
                    } else if (rowData[1].equals("BLUE")) {
                        System.out.println("Error: PikminType marker on row " + row + " in the map info file was read but its feature hasn't been implemented yet. The object wasn't loaded.");
                    } else {
                        System.out.println("Error: PikminType marker on row " + row + " in the map info file cannot be read. The object wasn't loaded.");
                    }
                    
                } else {
                    System.out.println("Error: Object marker on row " + row + " in the map info file cannot be read. The object wasn't loaded.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
