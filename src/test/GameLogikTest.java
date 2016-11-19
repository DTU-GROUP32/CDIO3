package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.*;
import entity.fields.*;
public class GameLogikTest {
	
private Player player; 
private int balance;
private GameBoard gameBoard;
private int fieldNumber;
Field field;
	@Before
	public void setUp() throws Exception {
		balance = 1000;
		player = new Player("Test",balance);
		field = gameBoard.getField(fieldNumber);
	}

	@After
	public void tearDown() throws Exception {
		balance = 1000;
		player = null; 
		field = null;
		
	}

	@Test
	public void testLandOnField500() {
      	int expected = 1000;
      	int actual = player.getBankAccount().getBalance();
   assertEquals(expected, actual);
   fieldNumber = 6;
   field.landOnField(player);
   int expected1 = 1500;
   int actual1 = player.getBankAccount().getBalance();
      assertEquals(expected1,actual1);


	}
}
