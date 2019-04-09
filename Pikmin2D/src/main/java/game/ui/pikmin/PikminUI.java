package game.ui.pikmin;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import game.ui.GameObjectUI;
import game.domain.Pikmin.Pikmin;

public abstract class PikminUI extends GameObjectUI {
    protected Pikmin pikmin;
        
    public PikminUI(double xPos, double yPos, double radius, Color color, Pikmin pikmin) {
        super(new Circle(xPos, yPos, radius, color));
        this.pikmin = pikmin;
    }
}
