package game.domain;

import game.domain.Pikmin.PikminType;

public class Player {
    private int[] pikmins; //Lista Pikmin enumien arvoista
    
    public Player() {
        this.pikmins = new int[PikminType.values().length];
        for (int i = 0; i < this.pikmins.length; i++) {
            this.pikmins[i] = 0;
        }
    }
    
    public void addPikmin(PikminType pikmin) {
        this.pikmins[pikmin.ordinal()]++;
    }
}
