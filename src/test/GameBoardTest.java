package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import control.GameController;

import static org.junit.Assert.*;

public class GameBoardTest {
    GameController spil;
    @Before
    public void setUp() throws Exception {
        spil = new GameController();
    }

    @After
    public void tearDown() throws Exception {
        spil = null;
    }

}