package game.ui;

import game.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PathUI extends GameObjectUI {
    
    public PathUI(double xPos, double yPos, double rotation, double width, double height) {
        super(new Rectangle(xPos, yPos, width, height));
        if (Main.debugMode) {
            super.gameObjectShape.setFill(Color.DEEPPINK);
        } else {
            super.gameObjectShape.setFill(Color.TRANSPARENT);
        }
        this.gameObjectShape.setRotate(rotation);
    }
    
    public double pathsRotation() {
        return super.gameObjectShape.getRotate();
    }
}
