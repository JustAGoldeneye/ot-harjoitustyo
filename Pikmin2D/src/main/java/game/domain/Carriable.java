package game.domain;

import java.util.ArrayList;

import game.domain.pikmin.Pikmin;

/**
 * Controls the information not related to JavaFX in a carriable object.
 * @author eemeli
 */
public class Carriable {
    private ArrayList<Pikmin> pikminsNow;
    private int maxPikmins;
    private int pikminCarryStrenghtNow;
    private int weight;
    
    /**
     * Holds data related to carrying object.
     * @param weight Pikmin strength needed to pick up the object.
     * @param maxPikmins Maximum amount of Pikmins to carry the object.
     */
    public Carriable(int weight, int maxPikmins) {
        this.pikminsNow = new ArrayList<>();
        this.pikminCarryStrenghtNow = 0;
        this.weight = weight;
        this.maxPikmins = maxPikmins;
    }
    
    /**
     * Adds Pikmin given as parameter to carry the object.
     * @param pikmin 
     */
    public void addPikmin(Pikmin pikmin) {
        if (pikmin != null) {
            this.pikminCarryStrenghtNow += pikmin.getStrength();
            this.pikminsNow.add(pikmin);
        }
    }
    
    /**
     * Removes all Pikmins from carrying the object.
     * @return List of Pikmins that carried the object
     */
    public ArrayList<Pikmin> removePikmins() {
        ArrayList<Pikmin> temp = this.pikminsNow;
        this.pikminCarryStrenghtNow = 0;
        this.pikminsNow = new ArrayList<>();
        return temp;
    }
    
    /**
     * Returns the objects weight minus total Pikmin strength. Needed to count object carrying speed.
     * @return The objects weight minus total Pikmin strength
     */
    public int extraStrength() {
        return this.pikminCarryStrenghtNow - this.weight;
    }
    
    /**
     * Returns the amount of Pikmin carrying the object.
     * @return The amount of Pikmin carrying the object
     */
    public int pikminCarrying() {
        return this.pikminsNow.size();
    }

    public int getWeight() {
        return weight;
    }

    public int getPikminCarryStrenghtNow() {
        return pikminCarryStrenghtNow;
    }

    public int getMaxPikmins() {
        return maxPikmins;
    }
}
