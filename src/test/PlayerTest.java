package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

import spil.*;

public class PlayerTest {
    Player player;
    @Before
    public void setUp() throws Exception {
        player = new Player("Test");
    }

    @After
    public void tearDown() throws Exception {
        player = null;
    }

    @Test
    public final void getName() throws Exception {
        Assert.assertEquals(player.getName(), "Test");
    }

    @Test
    public final void setName() throws Exception {
        player.setName("Test2");
        Assert.assertEquals("Test2", player.getName());
    }

    @Test
    public final void getId() throws Exception {
        Assert.assertEquals(player.getID(), 0);
        player = new Player("new player");
        Assert.assertEquals(player.getID(), 1);
    }
    
    @Test
    public final void getBank() throws Exception {
        Bank playerBank = player.getBank();
        Assert.assertEquals(1000, playerBank.getBalance());
    }
}
