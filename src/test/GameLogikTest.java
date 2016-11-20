package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.*;
import entity.fields.*;
public class GameLogikTest {

	private Player player; 
	private Player player2; 
	private int balance;
	private Field refuge;
	private int bonus;
	private Field territory;
	protected Player owner;
	private int rent; 
	private int price; 

	@Before
	public void setUp() throws Exception {
		balance = 1000;
		bonus = 500;
		player = new Player("Test",balance);
		player2 = new Player("TestOwner",balance);
		refuge = new Refuge(bonus);
		owner = player2; 
		rent = 100; 
		price = 1000; 
		territory = new Territory(price,rent);
	}

	@After
	public void tearDown() throws Exception {
		player = null; 
		player = null;
		player2 = null;
		refuge = null; 
		owner = null;  
		territory = null; 

	}

	@Test
	public void testLandOnFieldRefuge500() {
		int expected = 1000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		refuge.landOnField(player);
		expected = 1000+500;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}

	@Test
	public void testLandOnFieldRefugeTwice500() {
		int expected = 1000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		refuge.landOnField(player);
		refuge.landOnField(player);
		expected = 1000+500+500;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);

	}
	@Test
	public void testLandOnFieldTerritory500() {
		int expected = 1000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		territory.landOnField(player);
		expected = 1000-100;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}
}
