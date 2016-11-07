package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.Dice;
import spil.DiceCup;

import static org.junit.Assert.*;

public class DiceCupTest {
	DiceCup diceCup;

	@Before
	public void setUp() throws Exception {
		diceCup = new DiceCup(4);
		diceCup.rollDices();
	}

	@After
	public void tearDown() throws Exception {
		diceCup = null;
	}

	/**
	 * Tests if the getDices method actually return an array of Dice objects.
	 * @throws Exception
	 */
	@Test
	public void getDices() throws Exception {
		DiceCup diceCup2 = diceCup;
		
		for(int i = 0; i < diceCup.getDices().length; i++) {
			assertEquals(diceCup.getDices()[i], diceCup2.getDices()[i]);
		}
		
		assertEquals(diceCup2.getDices().length, diceCup.getDices().length);
		
	}

	
	/**
	 * Tests if all dices have the same value after having used the rollDices, it is possible that this could
	 * happen even if the dices were in fact rolled, but it's highly unlikely.
	 * @throws Exception
	 */
	@Test
	public void rollDices() throws Exception {
		int d1before = diceCup.getDices()[0].getFaceValue();
		int d2before = diceCup.getDices()[1].getFaceValue();
		int d3before = diceCup.getDices()[2].getFaceValue();
		int d4before = diceCup.getDices()[3].getFaceValue();
		diceCup.rollDices();
		int d1after = diceCup.getDices()[0].getFaceValue();
		int d2after = diceCup.getDices()[1].getFaceValue();
		int d3after = diceCup.getDices()[2].getFaceValue();
		int d4after = diceCup.getDices()[3].getFaceValue();
		assertFalse(d1before == d1after && d2before == d2after && d3before == d3after && d4before == d4after);
	}

	/**
	 * Tests if the getSum method return the same result, as if you added all the face values together one by one.
	 * @throws Exception
	 */
	@Test
	public void getSum() throws Exception {
		int expected = 0;
		for(Dice dice : diceCup.getDices())
			expected += dice.getFaceValue();
		int actual = diceCup.getSum();
		assertTrue(expected == actual);
	}

	/**
	 * Tests if the sides of the first dice in the array of dices is indeed changed after having called the method.
	 * @throws Exception
	 */
	@Test
	public void setDiceSides() throws Exception {
		diceCup = new DiceCup();
		int before = diceCup.getDices()[0].getSides();
		diceCup.setDiceSides(5, 7);
		int after = diceCup.getDices()[0].getSides();
		assertFalse(before == after);
	}

}