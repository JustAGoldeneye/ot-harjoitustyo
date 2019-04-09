import game.domain.pikmin.Pikmin;
import game.domain.pikmin.PikminType;
import game.domain.pikmin.RedPikmin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class RedPikminTest {
    Pikmin pikmin;
    
    @Before
    public void setUp() {
        pikmin = new RedPikmin();
    }
    
    @Test
    public void CorrectType() {
        assertTrue(pikmin.getType() == PikminType.RED);
    }
    
    @Test
    public void CorrectName() {
        assertTrue(pikmin.getName().equals("Red Pikmin"));
    }
    
    @Test
    public void CorrectStrength() {
        assertTrue(pikmin.getStrength() == 1);
    }
    
    @Test
    public void CorrectSpeed() {
        assertTrue(pikmin.getSpeed() == 1);
    }
}
