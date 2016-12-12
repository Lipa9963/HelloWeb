/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.algorithm;

import java.util.ArrayList;
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
public class ReversePolishSolutionTest {
    
    public ReversePolishSolutionTest() {
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
     * Test of evalRPN method, of class ReversePolishSolution.
     */
    @Test
    public void testEvalRPN() {
        System.out.println("evalRPN");
        String tokens = "0.6 8 *";
        String [] t = {"1","2","3","4","5","7","^","/","*","-","+"};
        ArrayList<String> mylist = new ArrayList<String>();
        ReversePolishSolution instance = new ReversePolishSolution();
        int expResult = 3;
       // mylist = instance.evalRPN(t);
        System.out.println(Arrays.toString(mylist.toArray()));
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
