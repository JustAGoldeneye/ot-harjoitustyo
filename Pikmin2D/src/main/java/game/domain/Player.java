package game.domain;

import game.domain.Pikmin.PikminType;

public class Player {
    private int[] pikmins; //Lista Pikmin enumien arvoista
    
    public Player() {
        this.pikmins = new int[PikminType.values().length];
    }
}
