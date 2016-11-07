package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.omg.PortableInterceptor.Interceptor;
import spil.Player;
import spil.Field;

import static org.junit.Assert.*;

public class FieldTest {
	Player player;
	
	@Before
	public void setUp() throws Exception {
		player = new Player();
	}

	@After
	public void tearDown() throws Exception {
		player = null;
	}


	@Test // Tests landOnField() method with a plus-effect
	public void testLandOnFieldPlusEffect() {
		Field field = new Field(300);
		
		field.landOnField(player);

		int actual = player.getBank().getBalance();
		int expected = 1300;
		
		Assert.assertEquals(expected, actual);
	} // As expected

	
	@Test // Tests landOnField() method with a minus-effect
	public void testLandOnFieldMinusEffect() {
		Field field = new Field(-300);
		
		field.landOnField(player);

		int actual = player.getBank().getBalance();
		int expected = 700;
		
		Assert.assertEquals(expected, actual);
	} // As expected
	
	
	@Test // Tests if landOnField() returns false (extraTurn)
	public void testLandOnFieldReturnFalse() {
		Field field = new Field(-300);
		
		Assert.assertEquals(false, field.landOnField(player));
	} // As expected
	
	
	@Test // Again, tests if landOnField() returns false (extraTurn), using secondary constructor
	public void testLandOnFieldReturnFalse2() {
		Field field = new Field(-300, false);
		
		Assert.assertEquals(false, field.landOnField(player));
	} // As expected
	
	
	@Test // Tests if landOnField() returns true (extraTurn)
	public void testLandOnFieldReturnTrue() {
		Field field = new Field(-300, true);
		
		Assert.assertEquals(true, field.landOnField(player));
	} // As expected
	
	
	// FOLLOWING TESTS ARE CONSIDERED (MAYBE) UNNECESSARY AND SUPERFICIAL,
	// BECAUSE WE ASSUME THAT SUCH THINGS WON'T BE ABLE TO OCCUR UNDER OUR CIRCUMSTANCES.
	
	
	@Test // Tests landOnField() method with max value
	public void testLandOnFieldMaxEffect() {
		int effect = Integer.MAX_VALUE;
		Field field = new Field(effect);
		field.landOnField(player);

		int actual = player.getBank().getBalance();

		Assert.assertEquals(effect, actual);
	} // Not as expected
	
	
	@Test // Tests landOnField() method with min value
	public void testLandOnFieldMinEffect() {

		Field field = new Field(Integer.MIN_VALUE);
		
		field.landOnField(player);

		int actual = player.getBank().getBalance();
		int expected = Integer.MIN_VALUE;
		
		Assert.assertEquals(0, actual);
	} // As expected
	
    
}