/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.algorithm;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class ShuntingYardTest {
    
    public ShuntingYardTest() {
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
     * Test of postfix method, of class ShuntingYard.
     */
    @Test
    public void testPostfix() {
        System.out.println("2+3");
        //String[] infix = {"5","*", "(","8","+","√","(","99",")","/","2",")"};
        //String[] infix = {"√","(","99",")","+","55"};
        String[] infix = {"(","88","^","2",")","^","3","+","44","+","45","/","99","^","2","/","3",};
        String expResult = "1 2 +";
        String[] result = ShuntingYard.postfix(infix);
         System.out.println(Arrays.toString(result));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
