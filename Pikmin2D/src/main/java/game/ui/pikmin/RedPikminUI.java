package game.ui.pikmin;

import game.domain.pikmin.RedPikmin;
import javafx.scene.paint.Color;

public class RedPikminUI extends PikminUI {
    
    public RedPikminUI(double xPos, double yPos, RedPikmin pikmin, int id) {
        super(xPos, yPos, 5, Color.RED, pikmin, id);
    }
}
