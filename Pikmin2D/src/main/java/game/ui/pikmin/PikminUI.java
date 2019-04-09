package game.ui.pikmin;

import javafx.scene.shape.Circle;
import game.domain.Pikmin.Pikmin;

public abstract class PikminUI {
    private Circle pikminCircle;
    private Pikmin pikmin;
    
    public PikminUI(double xPos, double yPos, Pikmin pikmin) {
        this.pikminCircle = new Circle(xPos, yPos, 10);
        this.pikmin = pikmin;
    }
}
