package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.BankAccount;

import org.junit.Assert;

import static org.junit.Assert.*;

public class BankTest {
    private BankAccount bank;
    @Before
    public void setUp() throws Exception {
        bank = new BankAccount();
    }

    @After
    public void tearDown() throws Exception {
        bank = null;
    }

    @Test
    public void changeBalance() throws Exception {
        bank.changeBalance(-100);
        Assert.assertEquals(bank.getBalance(), 900);
        bank.changeBalance(100);
        Assert.assertEquals(bank.getBalance(), 1000);
        bank.changeBalance(-1001);
        Assert.assertEquals(bank.getBalance(), 0);
    }

    @Test
    public void getBalance() throws Exception {
        Assert.assertEquals(bank.getBalance(), 1000);
    }

}