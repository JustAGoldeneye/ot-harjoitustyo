package game.ui;

import game.domain.Player;
import java.util.Scanner;
import java.io.File;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

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
                    player = new Player(Double.valueOf(rowData[1]), Double.valueOf(rowData[2]), Double.valueOf(rowData[3]), rowData[4]);
                } else {
                    System.out.println("Error: Row " + row + " in the map info file cannot be read. The object wasn't loaded.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
