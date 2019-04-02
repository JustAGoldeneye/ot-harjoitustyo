package game.domain;

import javafx.scene.shape.Circle;
//import javafx.geometry.Point2D;

public class Player {
    private Circle player;
    
    public Player(double xPos, double yPos, double radius) {
        this.player = new Circle(xPos, yPos, radius);
    }

    public Circle getPlayer() {
        return player;
    }
}
