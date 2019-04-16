package game.domain;

import game.domain.pikmin.*;

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
}
