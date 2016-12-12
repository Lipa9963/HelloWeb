/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.algorithm;

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
public class ReversePolishTest {
    
    public ReversePolishTest() {
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
     * Test of postfixToInfix method, of class ReversePolish.
     */
    @Test
    public void testPostfixToInfix() {
        System.out.println("postfixToInfix");
        String postfix = "5 8 3 2 / + *";
        String expResult = "2 + 3";
        String result = ReversePolish.postfixToInfix(postfix);
        System.out.println(result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
