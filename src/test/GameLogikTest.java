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
	private Player owner;
	private int balance;
	private int rent; 
	private int price; 
	private int lastroll;
	private int bonus;
	private Field territory;
	private Field refuge;
	private Field laborcamp;
	private Field tax; 
	private Field fleet; 
	@Before
	public void setUp() throws Exception {
		balance = 1000;
		bonus = 500;
		rent = 100; 
		price = 1000; 
		lastroll = 6; 
		owner = player2; 
		player = new Player("Test",balance);
		player2 = new Player("TestOwner",balance);
		refuge = new Refuge(bonus);
		territory = new Territory(price,rent);
		laborcamp = new LaborCamp();
		tax = new Tax(2000);
		fleet = new Fleet();
	}

	@After
	public void tearDown() throws Exception {
		player = null; 
		player = null;
		player2 = null;
		refuge = null; 
		owner = null;  
		territory = null; 
		laborcamp = null; 

	}

	@Test
	public void testLandOnFieldRefuge() {
		int expected = 1000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		refuge.landOnField(player);
		expected = 1000+500;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}

	@Test
	public void testLandOnFieldTerritory() {
		int expected = 1000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		territory.landOnField(player);
		expected = 1000-100;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}
	@Test
	public void testLandOnFieldLaborCamp() {
		int expected = 1000;
		int actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
		laborcamp.landOnField(player);
		expected = 1000-600;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}
	@Test
	public void testLandOnFieldTax() {
		int expected = 3000;
		int actual = player.getBankAccount().getBalance()+2000;
		assertEquals(expected, actual);
		tax.landOnField(player);
		expected = 1000;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}
	@Test
	public void testLandOnFieldFleet() {
		int expected = 3000;
		int actual = player.getBankAccount().getBalance()+2000;
		assertEquals(expected, actual);
		fleet.landOnField(player);
		expected = 1000;
		actual = player.getBankAccount().getBalance();
		assertEquals(expected, actual);
	}
	

}
