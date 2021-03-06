package game.domain;

import game.domain.pikmin.*;

/**
 * Controls the information not related to JavaFX in a player object.
 * @author eemeli
 */
public class Player {
    private int[] pikmins;
    
    /**
     * Holds data related to the player character.
     * pikmins[] contains amounts of every Pikmin species currently in team
     * (JavaFX data can be found in PlayerUI.)
     */
    public Player() {
        this.pikmins = new int[PikminType.values().length];
    }
    
    /**
     * Adds 1 Pikmin of the type specified in the parameter to the player's team.
     * 
     * @param pikmin enum telling the Pikmin type to be added
     */
    public void addPikmin(PikminType pikmin) {
        this.pikmins[pikmin.ordinal()]++;
    }
    
    /**
     * Gives away a Pikmin from the team if avaliable.
     * @param pikmin The type of Pikmin to be given away
     * @return Pikmin given away, null if none was available
     */
    public Pikmin commandPikmin(PikminType pikmin) {
        if (this.pikmins[pikmin.ordinal()] > 0) {
            this.pikmins[pikmin.ordinal()]--;
            if (pikmin == PikminType.RED) {
                return new RedPikmin();
            }
        }
        return null;
    }

    public int[] getPikmins() {
        return pikmins;
    }
    
    /**
     * Get the amount of Pikmin of the specified type in the team.
     * @param pikminType The type of Pikmin to be counted
     * @return The amount of the specified Pikmin type in the team
     */
    public int pikminsInTeam(PikminType pikminType) {
        return this.pikmins[pikminType.ordinal()];
    }
}
