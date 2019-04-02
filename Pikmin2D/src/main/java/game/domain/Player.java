package game.domain;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.geometry.Point2D;

public class Player {
    private Circle player;
    private Point2D movement;
    private int rotationModifier;
    private double accelerationModifier;
    private double maxAcceleration;
    
    public Player(double xPos, double yPos, double rotation, double radius, String imageFileName) {
        this.player = new Circle(xPos, yPos, radius);
        
        Image image = new Image(imageFileName,false);
        this.player.setFill(new ImagePattern(image));
        
        this.player.setRotate(rotation);
        this.movement = new Point2D(0, 0);
        
        //Modifiers
        this.rotationModifier = 3;
        this.accelerationModifier = 0.4;
        this.maxAcceleration = 0.6;
    }

    public Circle getPlayer() {
        return player;
    }
    
    public void turnLeft() {
        this.player.setRotate(this.player.getRotate() - this.rotationModifier);
    }
    
    public void turnRight() {
        this.player.setRotate(this.player.getRotate() + this.rotationModifier);
    }
    
    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.player.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.player.getRotate()));
        
        changeX *= this.accelerationModifier;
        changeY *= this.accelerationModifier;
        
        Point2D temp = new Point2D(this.movement.getX(), this.movement.getY());
        
        if (this.movement.magnitude() <= this.maxAcceleration) {
            this.movement = this.movement.add(changeX, changeY);
        } else {
            this.movement = temp;
        }
    }
    
    public void stop() {
        this.movement = this.movement.multiply(0);
    }
    
    public void move() {
        this.player.setTranslateX(this.player.getTranslateX() + this.movement.getX());
        this.player.setTranslateY(this.player.getTranslateY() + this.movement.getY());
    }
}
