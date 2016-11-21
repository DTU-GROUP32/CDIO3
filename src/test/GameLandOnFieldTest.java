package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.*;
import entity.fields.*;
public class GameLandOnFieldTest {
/**
 * We need to players in order to test the fields. We need a player that lands on field and an owner that owns the field that was landed on. 
 */
	private Player player; 
	private Player player2;
	private Field territory;
	private Field refuge;
	private Field laborcamp;
	private Field tax; 
	private Field fleet; 
	
	
	@Before
	public void setUp() throws Exception {
		player = new Player("Test",5000);
		player2 = new Player("TestOwner",5000);
		refuge = new Refuge(500);
		territory = new Territory(1000,100);
		laborcamp = new LaborCamp();
		tax = new Tax(2000);
		fleet = new Fleet();
	}

	@After
	public void tearDown() throws Exception {
		player = null; 
		player2 = null;
		refuge = null; 
		territory = null; 
		laborcamp = null; 
		tax = null;
		fleet = null; 
		
	}

	/**
	 * Tests the field type Refuge. The expected result is player bank account receives 500. Expected result will therefore be 5500
	 */
	@Test
	public void testLandOnFieldRefuge() {
		int expected = 5000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		refuge.landOnField(player);
		expected = 5000+500;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}
/**
 * Tests the field type Territory. The expected result is player bank account receives loses 100.  Therefore the expected result is 4900 
 */
	
	
	@Test
	public void testLandOnFieldTerritory() {
		int expected = 5000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		territory.setOwner(player2);
		territory.landOnField(player);
		expected = 4900;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests the field type LaborCamp. The expected result is player bank account loses 600 because last roll was 6. Owner owns only 1 laborcamp. The player will have 4400 left.  
	 */
	@Test
	public void testLandOnFieldLaborCamp() {
		int expected = 5000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		laborcamp.buyField(player2);
		laborcamp.setOwner(player2);
		player.setLastRoll(6);
		laborcamp.landOnField(player);
		expected = 5000-600;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}
	/**
	 * Tests the field type Tax. Player lands on tax field that takes 2000. Therefore expected result will be 3000
	 */
	@Test
	public void testLandOnFieldTax() {
		int expected = 5000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		tax.landOnField(player);
		expected = 3000;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}
	/**
	 * Tests the field type Fleet. The expected result is player bank account loses 2000 (owner owns 1 fleets). Therefore we set the points to 3000 in order to not go to negative values. 
	 */
	@Test
	public void testLandOnFieldFleet() {
		int expected = 5000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		fleet.buyField(player2);
		fleet.setOwner(player2);
		fleet.landOnField(player);
		expected = 5000-500;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}
	

}
