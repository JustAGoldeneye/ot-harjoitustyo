package game.ui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class RecoveryAreaUI extends GameObjectUI {
    
    public RecoveryAreaUI(double xPos, double yPos, double radius) {
        super(new Circle(xPos, yPos, radius, Color.AQUAMARINE));
    }
}
