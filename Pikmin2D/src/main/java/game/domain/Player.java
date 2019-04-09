package game.domain;

import game.domain.Pikmin.PikminType;

public class Player {
    private int[] pikmins;
    
    public Player() {
        this.pikmins = new int[PikminType.values().length];
    }
}
