package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.GameBoard;
import entity.Player;

public class IntegrationTest {
	
	Player p1;
	Player p2;
	GameControllerTestStub testStub;
	GameBoard gameBoard;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Player("p1", 30000);
		p2 = new Player("p2", 30000);
		testStub = new GameControllerTestStub();
		gameBoard = new GameBoard();
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		testStub = null;
		gameBoard = null;
	}

	@Test
	public void notOwnableTest() {
		int p1Expected = 30000 + 500;
		int p2Expected = 30000 - 2000;
		setPlayer(p1, 6, false);
		setPlayer(p2, 10, false);
		testStub.playTurnTest(gameBoard, p1, true);
		testStub.playTurnTest(gameBoard, p2, true);
		int p1Actual = p1.getBankAccount().getBalance();
		int p2Actual = p2.getBankAccount().getBalance();
		assertEquals(p1Expected, p1Actual);
		assertEquals(p2Expected, p2Actual);
		p1Expected = (30000 + 500) * 9 / 10;
		p2Expected = (30000 - 2000) - 4000;
		setPlayer(p1, 18, true);
		setPlayer(p2, 18, false);
		testStub.playTurnTest(gameBoard, p1, true);
		testStub.playTurnTest(gameBoard, p2, true);
		p1Actual = p1.getBankAccount().getBalance();
		p2Actual = p2.getBankAccount().getBalance();
		assertEquals(p1Expected, p1Actual);
		assertEquals(p2Expected, p2Actual);
	}

	@Test
	public void ownableOwnedTest() {
		int p1Expected = 30000 - 1000 - 300 + 100;
		int p2Expected = 30000 - 1500 - 100 + 300;
		setPlayer(p1, 1, false);
		setPlayer(p2, 3, false);
		testStub.playTurnTest(gameBoard, p1, true);
		testStub.playTurnTest(gameBoard, p2, true);
		setPlayer(p1, 3, false);
		setPlayer(p2, 1, false);
		testStub.playTurnTest(gameBoard, p1, true);
		testStub.playTurnTest(gameBoard, p2, true);
		int p1Actual = p1.getBankAccount().getBalance();
		int p2Actual = p2.getBankAccount().getBalance();
		assertEquals(p1Expected, p1Actual);
		assertEquals(p2Expected, p2Actual);
	}
	
	@Test
	public void OwnableNotOwnedBuyTest() {
		Player f1ownerExpected = null;
		Player f3ownerExpected = null;
		Player f1ownerActual = gameBoard.getField(1).getOwner();
		Player f3ownerActual = gameBoard.getField(3).getOwner();
		assertEquals(f1ownerExpected, f1ownerActual);
		assertEquals(f3ownerExpected, f3ownerActual);
		setPlayer(p1, 1, false);
		setPlayer(p2, 3, false);
		testStub.playTurnTest(gameBoard, p1, true);
		testStub.playTurnTest(gameBoard, p2, true);
		f1ownerExpected = p1;
		f3ownerExpected = p2;
		f1ownerActual = gameBoard.getField(1).getOwner();
		f3ownerActual = gameBoard.getField(3).getOwner();
		assertEquals(f1ownerExpected, f1ownerActual);
		assertEquals(f3ownerExpected, f3ownerActual);
	}
	
	@Test
	public void OwnableNotOwnedDontBuyTest() {
		Player f1ownerExpected = null;
		Player f3ownerExpected = null;
		Player f1ownerActual = gameBoard.getField(1).getOwner();
		Player f3ownerActual = gameBoard.getField(3).getOwner();
		assertEquals(f1ownerExpected, f1ownerActual);
		assertEquals(f3ownerExpected, f3ownerActual);
		setPlayer(p1, 1, false);
		setPlayer(p2, 3, false);
		testStub.playTurnTest(gameBoard, p1, false);
		testStub.playTurnTest(gameBoard, p2, false);
		f1ownerActual = gameBoard.getField(1).getOwner();
		f3ownerActual = gameBoard.getField(3).getOwner();
		assertEquals(f1ownerExpected, f1ownerActual);
		assertEquals(f3ownerExpected, f3ownerActual);
	}
	
	private void setPlayer(Player player, int onField, boolean taxChoice) {
		player.setOnField(onField);
		player.setTaxChoice(taxChoice);
	}
}
