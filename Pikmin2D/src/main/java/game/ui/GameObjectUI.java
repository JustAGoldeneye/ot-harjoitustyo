package game.ui;

import javafx.scene.shape.Shape;

public abstract class GameObjectUI {
    protected Shape gameObjectShape;
    
    public GameObjectUI(Shape shape) {
        this.gameObjectShape = shape;
    }

    public Shape getGameObjectShape() {
        return gameObjectShape;
    }
}
