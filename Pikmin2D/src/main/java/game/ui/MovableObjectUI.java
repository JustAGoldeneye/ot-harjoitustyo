package game.ui;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public abstract class MovableObjectUI extends GameObjectUI {
    protected Point2D movement;
    protected int rotationModifier;
    protected double accelerationModifier;
    protected double maxSpeed;
    
    public MovableObjectUI(Shape shape, int rotationModifier, double accelerationModifier, double maxSpeed) {
        super(shape);
        this.movement = new Point2D(0, 0);
        
        this.rotationModifier = rotationModifier;
        this.accelerationModifier = accelerationModifier;
        this.maxSpeed = maxSpeed;
    }
    
    public void turnLeft() {
        this.gameObjectShape.setRotate(this.gameObjectShape.getRotate() - this.rotationModifier);
    }
    
    public void turnRight() {
        this.gameObjectShape.setRotate(this.gameObjectShape.getRotate() + this.rotationModifier);
    }
    
    public void accelerate() {
        if (this.movement.magnitude() <= this.maxSpeed) {
            double changeX = Math.cos(Math.toRadians(this.gameObjectShape.getRotate()));
            double changeY = Math.sin(Math.toRadians(this.gameObjectShape.getRotate()));
            changeX *= this.accelerationModifier;
            changeY *= this.accelerationModifier;
            this.movement = this.movement.add(changeX, changeY);
        }
    }
    
    public void stop() {
        this.movement = this.movement.multiply(0);
    }
    
    public void move() {
        this.gameObjectShape.setTranslateX(this.gameObjectShape.getTranslateX() + this.movement.getX());
        this.gameObjectShape.setTranslateY(this.gameObjectShape.getTranslateY() + this.movement.getY());
    }
    
    public boolean collide(GameObjectUI target) {
        Shape hitArea = Shape.intersect(this.gameObjectShape, target.getGameObjectShape());
        return hitArea.getBoundsInLocal().getWidth() != -1;
    }
}
