package game.domain.pikmin;

public abstract class Pikmin {
    protected final PikminType type;
    protected final String name;
    protected final int strength;
    protected final int speed;
    
    /**
     * Gets the parameters given by a subclass and forms an object which holds no JavaFX data.
     * (JavaFX data can be found in PikminUI.)
     * 
     * @param type The enum value of Pikmin species
     * @param name The name of Pikmin species
     * @param strength Strength of a single Pikmin while carrying a carriable item
     * @param speed Value used to calculate carrying speed effect of a single Pikmin while carrying a carriable item
     */
    public Pikmin(PikminType type, String name, int strength, int speed) {        
        this.type = type;
        this.name = name;
        this.strength = strength;
        this.speed = speed;
    }

    public PikminType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }
}
