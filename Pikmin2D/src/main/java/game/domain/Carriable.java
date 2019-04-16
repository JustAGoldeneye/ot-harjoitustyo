package game.domain;

import java.util.ArrayList;

import game.domain.pikmin.Pikmin;

public class Carriable {
    private ArrayList<Pikmin> pikminsNow;
    private int maxPikmins;
    private int pikminCarryStrenghtNow;
    private int weight;
    
    public Carriable(int weight, int maxPikmins) {
        this.pikminsNow = new ArrayList<>();
        this.pikminCarryStrenghtNow = 0;
        this.weight = weight;
        this.maxPikmins = maxPikmins;
    }
    
    public void addPikmin(Pikmin pikmin) {
        this.pikminCarryStrenghtNow += pikmin.getStrength();
        this.pikminsNow.add(pikmin);
    }
    
    public ArrayList<Pikmin> removePikmins() {
        ArrayList<Pikmin> temp = this.pikminsNow;
        this.pikminCarryStrenghtNow = 0;
        this.pikminsNow = new ArrayList<>();
        return temp;
    }
    
    public int extraWeigth() {
        return this.pikminCarryStrenghtNow - this.weight;
    }

    public int pikminCarrying() {
        return this.pikminsNow.size();
    }

    public int getWeight() {
        return weight;
    }
}
