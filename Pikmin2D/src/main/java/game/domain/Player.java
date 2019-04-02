package game.domain;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
//import javafx.geometry.Point2D;

public class Player {
    private Circle player;
    
    public Player(double xPos, double yPos, double radius, String imageFileName) {
        this.player = new Circle(xPos, yPos, radius);
        Image image = new Image(imageFileName,false);
        this.player.setFill(new ImagePattern(image));
    }

    public Circle getPlayer() {
        return player;
    }
}
