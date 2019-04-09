package game.domain.Pikmin;

public abstract class Pikmin {
    protected final PikminType type;
    protected final String name;
    protected final int strength;
    protected final int speed;
    
    public Pikmin(PikminType type, String name, int strength, int speed) {        
        this.type = type;
        this.name = name;
        this.strength = strength;
        this.speed = speed;
    }

    public PikminType getType() {
        return type;
    }
}
