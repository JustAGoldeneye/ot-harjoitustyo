package game.ui;

public interface Saveable {
    
    public int getId();

    public boolean isSaved();
    
    public void markAsSaved();
}
