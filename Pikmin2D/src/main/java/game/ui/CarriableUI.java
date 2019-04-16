package game.ui;

import javafx.scene.shape.Shape;

import game.domain.Carriable;

public abstract class CarriableUI extends MovableObjectUI {
    protected Carriable carriable;
    
    public CarriableUI(Shape shape, int rotationModifier, double accelerationModifier, Carriable carriable) {
        super(shape, rotationModifier, accelerationModifier, 0);
    }
    
    public void countAndsetMaxSpeed() {
        int extraWeight = this.carriable.extraWeigth();
        if (extraWeight > 0) {
            this.maxSpeed = 0.2 * extraWeight;
        } else {
            this.maxSpeed = 0;
        }
    }
}
