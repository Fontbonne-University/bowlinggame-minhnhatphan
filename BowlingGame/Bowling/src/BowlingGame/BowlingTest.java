package BowlingGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingTest {
	
	private Game g;
	
	@Before
	public void setUp() throws Exception {
		g = new Game();
	}
	
	private void rollStrike() {
		g.roll(10);
	}
	
	private void rollMany(int j, int pins) {
		for (int i=0; i<j; i++) {
			g.roll(pins);
		}
	}

	@Test
	public void canRoll() 
	{
		g.roll(0);
	}
	
	@Test
	public void gutterGame()
	{
		rollMany(20, 0);
		assertEquals(0, g.score());
	}

	@Test
	public void allones()
	{
		rollMany(20, 1);
		assertEquals(20, g.score());
	}
	
	@Test
	public void oneSpare()
	{
		g.roll(5);
		g.roll(5); //spare
		g.roll(3);
		rollMany(17, 0);
		assertEquals(16, g.score());
	}
	
	@Test
	public void oneStrike() 
	{
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(0, 16);
		assertEquals(24, g.score());
	}

	@Test
	public void perfectGame() {
		rollMany(12, 10);
		assertEquals(300, g.score());
	}
}
