package game.ui;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.geometry.Point2D;

import game.domain.Player;
import game.ui.GameObjectUI;

public class PlayerUI extends GameObjectUI {
    private Point2D movement;
    private int rotationModifier;
    private double accelerationModifier;
    private double maxAcceleration;
    
    private Player player;
    
    public PlayerUI(double xPos, double yPos, double rotation, double radius, String imageFileName, Player player) {
        super(new Circle(xPos, yPos, radius));
        
        Image image = new Image(imageFileName,false);
        this.gameObjectShape.setFill(new ImagePattern(image));
        
        this.gameObjectShape.setRotate(rotation);
        this.movement = new Point2D(0, 0);
        
        //Modifiers
        this.rotationModifier = 3;
        this.accelerationModifier = 0.4;
        this.maxAcceleration = 0.6;
    }
    
    public void turnLeft() {
        this.gameObjectShape.setRotate(this.gameObjectShape.getRotate() - this.rotationModifier);
    }
    
    public void turnRight() {
        this.gameObjectShape.setRotate(this.gameObjectShape.getRotate() + this.rotationModifier);
    }
    
    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.gameObjectShape.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.gameObjectShape.getRotate()));
        
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
        //System.out.println(this.movement);
    }
    
    public void move() {
        this.gameObjectShape.setTranslateX(this.gameObjectShape.getTranslateX() + this.movement.getX());
        this.gameObjectShape.setTranslateY(this.gameObjectShape.getTranslateY() + this.movement.getY());
    }
}
