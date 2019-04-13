package game.domain;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import game.domain.Player;
import game.domain.pikmin.PikminType;

public class PlayerTest {
    Player player;
    
    @Before
    public void setUp() {
        player = new Player();
    }
    
    @Test
    public void arrayIsSizeOfEnum() {
        assertTrue(player.getPikmins().length == PikminType.values().length);
    }
    
    @Test
    public void arrayInitiallyFilledWithZeros() {
        for (int i = 0; i < player.getPikmins().length; i++) {
            if (this.player.getPikmins()[i] != 0) {
                fail("There was something else than 0 in the array.");
            }
        }
    }
    
    @Test
    public void addingPikminsWorks1() {
        player.addPikmin(PikminType.RED);
    }
    
    @Test
    public void addingPikminsWorks2() {
        for (int i = 1; i <= 80; i++) {
            player.addPikmin(PikminType.YELLOW);
        }
        assertTrue(player.getPikmins()[1] == 80);    
    }
    
    @Test
    public void addingPikminsWorks3() {
        for (int i = 1; i <= 42; i++) {
            player.addPikmin(PikminType.RED);
        }
        for (int i = 1; i <= 12; i++) {
            player.addPikmin(PikminType.YELLOW);
        }
        for (int i = 1; i <= 55; i++) {
            player.addPikmin(PikminType.BLUE);
        }
        assertTrue(player.getPikmins()[0] == 42 && player.getPikmins()[1] == 12 && player.getPikmins()[2] == 55);
    }
}
