package game.ui.pikmin;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import game.ui.GameObjectUI;
import game.ui.Saveable;
import game.domain.pikmin.Pikmin;

public abstract class PikminUI extends GameObjectUI implements Saveable {
    protected Pikmin pikmin;
    protected int id;
    protected boolean saved;
        
    public PikminUI(double xPos, double yPos, double radius, Color color, Pikmin pikmin, int id) {
        super(new Circle(xPos, yPos, radius, color));
        this.pikmin = pikmin;
        this.id = id;
        this.saved = false;
    }

    public Pikmin getPikmin() {
        return this.pikmin;
    }
    
    public int getId() {
        return this.id;
    }

    public boolean isSaved() {
        return this.saved;
    }
    
    public void markAsSaved() {
        this.saved = true;
    }
}
