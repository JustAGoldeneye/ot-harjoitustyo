package game.ui;

import game.Main;
import game.domain.Carriable;
import javafx.scene.text.Font;

import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public abstract class CarriableUI extends MovableObjectUI {
    protected Carriable carriable;
    protected Text carryCounter;
    private Color carryCounterColor;
    
    public CarriableUI(Shape shape, int rotationModifier, double accelerationModifier, Carriable carriable, double xPos, double yPos) {
        super(shape, rotationModifier, accelerationModifier, 0);
        this.carriable = carriable;
        this.carryCounter = new Text(xPos-20, yPos+7, "0/" + this.carriable.getWeight());
        this.carryCounterColor = Color.CORNFLOWERBLUE;
        this.carryCounter.setFont(Font.font(20));
        if (Main.debugMode) {
            this.carryCounter.setFill(Color.PINK);
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
        return this.carryCounter;
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
        if (Main.debugMode) {
            this.carryCounter.setFill(Color.PINK);
        } else {
            this.carryCounter.setFill(Color.TRANSPARENT);
        }
    }
    
    private boolean carryCounterIsVisible() {
        if (this.carryCounter.getFill() == Color.TRANSPARENT || this.carryCounter.getFill() == Color.PINK) {
            return false;
        }
        return true;
    }
    
    private void turnTowards(GameObjectUI gameObjectUI) {
        //TODO
    }
}
