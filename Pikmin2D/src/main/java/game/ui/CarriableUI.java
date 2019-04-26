package game.ui;

import game.Main;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import game.domain.Carriable;
import javafx.scene.paint.Color;

public abstract class CarriableUI extends MovableObjectUI {
    protected Carriable carriable;
    protected Text carryCounter;
    private Color carryCounterColor;
    
    public CarriableUI(Shape shape, int rotationModifier, double accelerationModifier, Carriable carriable, double xPos, double yPos) {
        super(shape, rotationModifier, accelerationModifier, 0);
        this.carriable = carriable;
        this.carryCounter = new Text(xPos, yPos, "0/0");
        this.carryCounterColor = Color.CORNFLOWERBLUE;
        if (Main.DEBUG_MODE) {
            this.carryCounter.setFill(Color.DEEPPINK);
        } else {
            this.carryCounter.setFill(Color.TRANSPARENT);
        }
    }
    
    public void countAndsetMaxSpeed() {
        int extraWeight = this.carriable.extraStrength();
        if (extraWeight > 0) {
            this.maxSpeed = 0.2 * extraWeight;
        } else {
            this.maxSpeed = 0;
        }
    }

    public Text getCarryCounter() {
        return carryCounter;
    }
    
    public void moveText() {
        this.carryCounter.setTranslateX(this.gameObjectShape.getTranslateX());
        this.carryCounter.setTranslateY(this.gameObjectShape.getTranslateY());
    }

    public Carriable getCarriable() {
        return carriable;
    }
    
    public void updateCarryCounter() {
        if (carryCounterIsVisible() && this.carriable.getPikminCarryStrenghtNow() <= 0) {
            hideCarryCounter();
        }
        if (!carryCounterIsVisible() && this.carriable.getPikminCarryStrenghtNow() > 0) {
            showCarryCounter();
        }
        if (this.carriable.pikminCarrying() <= this.carriable.getMaxPikmins()) {
            this.carryCounter.setText(this.carriable.getPikminCarryStrenghtNow() + "/" + this.carriable.getWeight());
        }
    }
    
    private void showCarryCounter() {
        this.carryCounter.setFill(this.carryCounterColor);
    }
    
    private void hideCarryCounter() {
        if (Main.DEBUG_MODE) {
            this.carryCounter.setFill(Color.DEEPPINK);
        } else {
            this.carryCounter.setFill(Color.TRANSPARENT);
        }
    }
    
    private boolean carryCounterIsVisible() {
        if (this.carryCounter.getFill() == Color.TRANSPARENT || this.carryCounter.getFill() == Color.DEEPPINK) {
            return false;
        }
        return true;
    }
}
