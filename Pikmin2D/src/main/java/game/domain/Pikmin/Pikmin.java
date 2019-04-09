package game.domain.Pikmin;

public abstract class Pikmin {
    private final PikminType type;
    private final String name;
    private final int strength;
    private final int speed;
    
    public Pikmin(PikminType type, String name, int strength, int speed) {
        
        this.type = type;
        this.name = name;
        this.strength = strength;
        this.speed = speed;
    }
}
