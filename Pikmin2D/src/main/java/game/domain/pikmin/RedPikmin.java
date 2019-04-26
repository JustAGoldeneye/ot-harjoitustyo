package game.domain.pikmin;

/**
 * Creates a Pikmin object with red Pikmin's parameters.
 * @author eemeli
 */
public class RedPikmin extends Pikmin {
    
    /**
     * Gives the parameters related to Red Pikmin to parent parent object (Pikmin).
     */
    public RedPikmin() {
        super(PikminType.RED, "Red Pikmin", 1, 1);
    }
}
