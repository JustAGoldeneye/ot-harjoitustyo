package game.ui;

import game.Main;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import game.domain.Carriable;
import javafx.scene.paint.Color;

public abstract class CarriableUI extends MovableObjectUI {
    protected Carriable carriable;
    protected Text carryCounter;
    
    public CarriableUI(Shape shape, int rotationModifier, double accelerationModifier, Carriable carriable, double xPos, double yPos) {
        super(shape, rotationModifier, accelerationModifier, 0);
        this.carryCounter = new Text(xPos, yPos, "Carriers/Required");
        if (Main.DEBUG_MODE) {
            this.carryCounter.setFill(Color.DEEPPINK);
        } else {
            this.carryCounter.setFill(Color.TRANSPARENT);
        }
    }
    
    public void countAndsetMaxSpeed() {
        int extraWeight = this.carriable.extraWeigth();
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
}
