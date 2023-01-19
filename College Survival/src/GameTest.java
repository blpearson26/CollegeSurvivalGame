import static org.junit.jupiter.api.Assertions.*;
import java.awt.AWTException;
import org.junit.jupiter.api.Test;

class GameTest {

	
	@Test
	void testActionNumMethods() 
	{
		int i = Game.getActionNum();
		Game.incrActionNum();
		assert Game.getActionNum() < i;
	}
	@Test
	void testGetTurnString()
	{
		Game.incrActionNum();
		assert Game.getTurnNum().equals(" Week 1  |  Actions Left: 4");
	}

}
