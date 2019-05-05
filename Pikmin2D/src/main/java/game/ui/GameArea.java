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
import java.util.stream.Collectors;

import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
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
    static Image backgroundImage;
    
    static PlayerUI playerUI;
    static RecoveryAreaUI recoveryAreaUI;
    static ArrayList<WallUI> wallUIs;
    static ArrayList<PikminUI> pikminUIs;
    static ArrayList<ItemUI> itemUIs;

    @Override
    public void start(Stage stage) throws Exception {
        
        importMapInfo("maps/testmap1.pkmp");
        
        Pane screen = new Pane();
        screen.setPrefSize(paneWidth, paneHeight);
        
        Text redPikminCounterText = new Text(10, 20, "Red Pikmin: 0");
        redPikminCounterText.setFill(Color.RED);
        redPikminCounterText.setFont(Font.font(20));
        screen.getChildren().add(redPikminCounterText);
        
        //The order of loading objects changes overlapping: Earlier loaded objects go back and later front.
        screen.getChildren().add(recoveryAreaUI.getGameObjectShape());
        for (ItemUI itemUI : itemUIs) {
            screen.getChildren().add(itemUI.getGameObjectShape());
            screen.getChildren().add(itemUI.getCarryCounter());
        }
        for (PikminUI pikminUI : pikminUIs) {
            screen.getChildren().add(pikminUI.getGameObjectShape());
        }
        screen.getChildren().add(playerUI.getGameObjectShape());
        for (WallUI wallUI : wallUIs) {
            screen.getChildren().add(wallUI.getGameObjectShape());
        }
        
        Scene scene = new Scene(screen);
        stage.setScene(scene);
        stage.setTitle("Pikmin 2D");
        scene.setFill(new ImagePattern(backgroundImage));
        stage.show();
        
        Map<KeyCode, Boolean> pressedButtons = new HashMap<>();
        
        scene.setOnKeyPressed(event -> {
            
           pressedButtons.put(event.getCode(), Boolean.TRUE);
           
           if (event.getCode() == KeyCode.E) {
               itemUIs.stream().forEach(itemUI -> {
                    if (playerUI.collide(itemUI)) {
                        itemUI.getCarriable().addPikmin(playerUI.getPlayer().commandPikmin(PikminType.RED)); //Add an abilyty to change the PikminType
                        itemUI.updateCarryCounter();
                        redPikminCounterText.setText("Red Pikmin: " + playerUI.getPlayer().pikminsInTeam(PikminType.RED));
                    }
                });
           }
        });
        
        scene.setOnKeyReleased(event -> {
            
           pressedButtons.put(event.getCode(), Boolean.FALSE);
           
           if (event.getCode() == KeyCode.W) {
               playerUI.stop();
           } 
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
                
                wallUIs.stream().forEach(wallUI -> {
                    if (playerUI.collide(wallUI)) {
                        playerUI.setCollidingWithWallTrue();
                    }
                });
                
                if (playerUI.canMove()) {
                    playerUI.move();
                } else {
                    playerUI.escapeWall();
                }
                
                List<PikminUI> collidedList = pikminUIs.stream()
                        .filter(pikminUI -> playerUI.collide(pikminUI))
                        .collect(Collectors.toList());
                collidedList.stream().forEach(collided -> {
                    
                    pikminUIs.remove(collided);                          
                    screen.getChildren().remove(collided.getGameObjectShape());
                    
                    playerUI.getPlayer().addPikmin(collided.getPikmin().getType());
                    
                    if (collided.getPikmin().getType() == PikminType.RED) {
                        redPikminCounterText.setText("Red Pikmin: " + playerUI.getPlayer().pikminsInTeam(PikminType.RED));
                    }
                });
                
                itemUIs.stream().forEach(itemUI -> { //TEMP
                    if (itemUI.getCarriable().extraStrength() >= 0) {
                        itemUI.accelerate();
                    }
                    itemUI.move();
                    itemUI.moveText();
                });
            }
        }.start();
    }
    
    public void importMapInfo(String fileName) {
        try (Scanner fReader = new Scanner(new File(fileName))) {
            
            boolean firstRow = true;
            pikminUIs = new ArrayList<>();
            itemUIs = new ArrayList<>();
            wallUIs = new ArrayList<>();
            
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
                    backgroundImage = new Image(rowData[2], false);
                    
                    
                } else if (rowData[0].equals("Player")) {
                    playerUI = new PlayerUI(Double.valueOf(rowData[1]), Double.valueOf(rowData[2]), Double.valueOf(rowData[3]), Double.valueOf(rowData[4]), rowData[5], new Player());
                } else if (rowData[0].equals("RecoveryArea")) {
                    recoveryAreaUI = new RecoveryAreaUI(Double.valueOf(rowData[1]), Double.valueOf(rowData[2]), Double.valueOf(rowData[3]));
                } else if (rowData[0].equals("Wall")) {
                    wallUIs.add(new WallUI(Double.valueOf(rowData[1]), Double.valueOf(rowData[2]), Double.valueOf(rowData[3]), Double.valueOf(rowData[4]), Double.valueOf(rowData[5]), Color.valueOf(rowData[6])));
                } else if (rowData[0].equals("Item")) {
                   
                   if (rowData[3].equals("Circle")) {
                       itemUIs.add(new ItemUI(Integer.valueOf(rowData[1]), Integer.valueOf(rowData[2]), Double.valueOf(rowData[4]), Double.valueOf(rowData[5]), Double.valueOf(rowData[6]), rowData[7]));
                   } else {
                       System.out.println("Non-fatal error: Shape marker on row " + row + " in the map info file cannot be read. The object wasn't loaded.");
                   }
                } else if (rowData[0].equals("Pikmin")) {
                         
                    if (rowData[1].equals("RED")) {
                        pikminUIs.add(new RedPikminUI(Double.valueOf(rowData[2]), Double.valueOf(rowData[3]), new RedPikmin()));
                    } else if (rowData[1].equals("YELLOW")) {
                        System.out.println("Non-fatal in-DEV error: PikminType marker on row " + row + " in the map info file was read but its feature hasn't been implemented yet. The object wasn't loaded.");
                    } else if (rowData[1].equals("BLUE")) {
                        System.out.println("Non-fatal in-DEV error: PikminType marker on row " + row + " in the map info file was read but its feature hasn't been implemented yet. The object wasn't loaded.");
                    } else {
                        System.out.println("Non-fatal error: PikminType marker on row " + row + " in the map info file cannot be read. The object wasn't loaded.");
                    }
                    
                } else {
                    System.out.println("Non-fatal error: Object marker on row " + row + " in the map info file cannot be read. The object wasn't loaded.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
