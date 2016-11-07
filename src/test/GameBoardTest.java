package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import spil.GameBoard;

import static org.junit.Assert.*;

public class GameBoardTest {
    GameBoard spil;
    @Before
    public void setUp() throws Exception {
        spil = new GameBoard();
    }

    @After
    public void tearDown() throws Exception {
        spil = null;
    }

}