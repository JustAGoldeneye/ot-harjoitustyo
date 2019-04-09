package game.ui;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import game.domain.Player;

public class PlayerUI extends MovableObjectUI {
    
    private Player player;
    
    public PlayerUI(double xPos, double yPos, double rotation, double radius, String imageFileName, Player player) {
        super(new Circle(xPos, yPos, radius), 3, 0.4, 0.6);
        
        Image image = new Image(imageFileName,false);
        this.gameObjectShape.setFill(new ImagePattern(image));
        
        this.gameObjectShape.setRotate(rotation);
    }
}
