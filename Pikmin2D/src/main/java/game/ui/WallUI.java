package game.ui;

import javafx.scene.shape.Rectangle;

public class WallUI extends GameObjectUI {
    
    public WallUI(double xPos, double yPos, double width, double height) {
        super(new Rectangle(xPos, yPos, width, height));
    }
}
