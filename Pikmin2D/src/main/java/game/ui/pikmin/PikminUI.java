package game.ui.pikmin;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import game.domain.Pikmin.Pikmin;

public abstract class PikminUI {
    protected Circle pikminCircle;
    protected Pikmin pikmin;
        
    public PikminUI(double xPos, double yPos, double radius, Color color, Pikmin pikmin) {
        this.pikminCircle = new Circle(xPos, yPos, radius, color);
        this.pikmin = pikmin;
    }

    public Circle getPikminCircle() {
        return pikminCircle;
    }
}
