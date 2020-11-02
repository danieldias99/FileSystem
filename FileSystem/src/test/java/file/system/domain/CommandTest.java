/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class CommandTest {

    Command command;

    public CommandTest() {
        command = new Command("cd", "Change Directory");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCommand_tag method, of class Command.
     */
    @Test
    public void testGetCommand_tag() {
        System.out.println("getCommand_tag");
        String expResult = "cd";
        String result = command.getCommand_tag();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Command.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "cd-> Change Directory";
        String result = command.toString();
        assertEquals(expResult, result);
    }

}
