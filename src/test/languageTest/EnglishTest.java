package test.languageTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spil.DiceCup;
import spil.Player;
import spil.language.English;

import static org.junit.Assert.*;

public class EnglishTest {
    English language;
    Player[] players;
    DiceCup diceCup;

    @Before
    public void setUp() throws Exception {
        language = new English();
        diceCup = new DiceCup();
        players = new Player[2];
        for(int i = 0; i < players.length; i++)
            players[i] = new Player();
    }

    @After
    public void tearDown() throws Exception {
        language = null;
        players = null;
        diceCup = null;
    }

    @Test
    public void welcomeMsg() throws Exception {
        assertTrue(language.welcomeMsg() instanceof String);

    }

    /**
     * Tests if askForPlayerName is string
     * @throws Exception
     */
    @Test
    public void askForPlayerName() throws Exception {
        assertTrue(language.askForPlayerName(0) instanceof String);
    }

    /**
     * Tests if readyToBegin is string
     * @throws Exception
     */
    @Test
    public void readyToBegin() throws Exception {
        assertTrue(language.readyToBegin() instanceof String);
    }

    /**
     * Tests if preMsg is string
     * @throws Exception
     */
    @Test
    public void preMsg() throws Exception {
        assertTrue(language.preMsg(players[0]) instanceof String);
    }
    /**
     * Tests if rollResult is string
     * @throws Exception
     */
    @Test
    public void rollResult() throws Exception {
        assertTrue(language.rollResult(diceCup) instanceof String);
    }
    /**
     * Tests if fieldMsg is string
     * @throws Exception
     */
    @Test
    public void fieldMsg() throws Exception {
        assertTrue(language.fieldMsg(diceCup) instanceof String);
    }

    /**
     * Tests if postMsg is string
     * @throws Exception
     */
    @Test
    public void postMsg() throws Exception {
        assertTrue(language.postMsg(players[0]) instanceof String);
    }

    /**
     * Tests if winnerMsg is string
     * @throws Exception
     */
    @Test
    public void winnerMsg() throws Exception {
        assertTrue(language.winnerMsg(players[0]) instanceof String);
    }
    /**
     * Tests if menu is string
     * @throws Exception
     */

    @Test
    public void menu() throws Exception {
        assertTrue(language.menu() instanceof String);
    }

    /**
     * Tests if printRules is string
     * @throws Exception
     */
    @Test
    public void printRules() throws Exception {
        assertTrue(language.printRules() instanceof String);
    }

    /**
     * Tests if printScore is string
     * @throws Exception
     */
    @Test
    public void printScore() throws Exception {
        assertTrue(language.printScore(players) instanceof String); // Failure
    }

    /**
     * Tests if changeDices is string
     * @throws Exception
     */
    @Test
    public void changeDices() throws Exception {
        assertTrue(language.changeDices() instanceof String);
    }
    /**
     * Tests if printDiceChangeSucces is string
     * @throws Exception
     */

    @Test
    public void printDiceChangeSucces() throws Exception {
        assertTrue(language.printDiceChangeSucces() instanceof String);

    }
    /**
     * Tests if printDiceChangeNotExecuted is string
     * @throws Exception
     */
    @Test
    public void printDiceChangeNotExecuted() throws Exception {
        assertTrue(language.printDiceChangeNotExecuted() instanceof String);
    }
}