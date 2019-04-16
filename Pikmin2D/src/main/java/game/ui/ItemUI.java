package game.ui;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import game.domain.Carriable;

public class ItemUI extends CarriableUI {
    
     //Create new constructors with other shpaes when needeed.
    public ItemUI(int weight, int maxPikmins, double xPos, double yPos, double radius, String imageFileName) {      
        super(new Circle(xPos, yPos, radius), 3, 0.6, new Carriable(weight, maxPikmins));
        this.gameObjectShape = new Circle(xPos, yPos, radius);
        this.gameObjectShape.setFill(new ImagePattern(new Image(imageFileName,false)));
    }
}
