package game.ui;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import game.domain.Player;

public class PlayerUI extends MovableObjectUI {
    
    private Player player;
    boolean collidingWithWall;
    
    public PlayerUI(double xPos, double yPos, double rotation, double radius, String imageFileName, Player player) {
        super(new Circle(xPos, yPos, radius), 3, 0.6, 0.8);
        
        Image image = new Image(imageFileName,false);
        this.gameObjectShape.setFill(new ImagePattern(image));
        
        this.gameObjectShape.setRotate(rotation);
        
        this.player = player;
        
        this.collidingWithWall = false;
    }

    public Player getPlayer() {
        return player;
    }
    
    public void setCollidingWithWallTrue() {
        this.collidingWithWall = true;
    }
    
    public boolean canMove() {
        
        if (this.collidingWithWall) {
            this.collidingWithWall = false;
            return false;
            
        } else {
            return true;
        }
    }
    
    public void escapeWall() {
        super.stop();
        super.gameObjectShape.setRotate(this.gameObjectShape.getRotate() + 180);
        super.move();
        super.accelerate();
        super.move();
        super.gameObjectShape.setRotate(this.gameObjectShape.getRotate() - 180);
        super.stop();
        super.move();
    }
}
