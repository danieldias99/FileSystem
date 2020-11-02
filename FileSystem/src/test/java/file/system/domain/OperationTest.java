/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.system.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class OperationTest {

    Operation operation;
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public OperationTest() {
        operation = new Operation(new Command("cd", "Change Directory"), "Ok", true);
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
     * Test of getResult method, of class Operation.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        String expResult = "Ok";
        String result = operation.getResult();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Operation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "cd;" + formatter.format(new Date()) + ";true";
        String result = operation.toString();
        assertEquals(expResult, result);
    }

}
