package game.ui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class WallUI extends GameObjectUI {
    
    public WallUI(double xPos, double yPos, double rotation, double width, double height, Color color) {
        super(new Rectangle(xPos, yPos, width, height));
        this.gameObjectShape.setFill(color);
        this.gameObjectShape.setRotate(rotation);
    }
}
