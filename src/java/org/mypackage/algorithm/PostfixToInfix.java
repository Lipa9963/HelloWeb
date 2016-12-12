/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.algorithm;


import java.util.Stack;
import org.mypackage.MathMl.MathMl;
import org.mypackage.jsons.Answer;
import org.mypackage.jsons.AnswerStep;

/**
 *
 * @author admin
 */
public class PostfixToInfix {

    private static Stack<String> stack;

    public static String reverse(String[] arrayPostfix)
    {
        
        stack = new Stack<String>();
       // String[] arrayPostfix = answer.getResultingExpressionPostfixEsStringArray();

        for (int i = 0; i < arrayPostfix.length; i++) {
            
            if (isNumeric(arrayPostfix[i])) 
            {
               stack.push(arrayPostfix[i]);

            }
            else
            {
                switch(arrayPostfix[i]){
                    case "√":
                        String pop = stack.pop();
                         pop = MathMl.addSqrt(pop);
                         stack.push(pop);
                         break;
                    case "+":
                        String first = stack.pop();
                        String two   = stack.pop();
                        pop = MathMl.addPlus(first, two);
                        stack.push(pop);
                        break;
                    case "-":
                        first = stack.pop();
                        two   = stack.pop();
                        pop = MathMl.addMinus(first, two);
                        stack.push(pop);
                        break;
                    case "*":
                        first = stack.pop();
                        two   = stack.pop();
                        pop = MathMl.addMul(first, two);
                        stack.push(pop);
                        break;
                    case "/":
                        first = stack.pop();
                        two   = stack.pop();
                        pop = MathMl.addDivision(first, two);
                        stack.push(pop);
                        break;
                    case "^":
                        first = stack.pop();
                        two   = stack.pop();
                        pop = MathMl.addeXponent(two, first);
                        stack.push(pop);
                        break;
                }
                
            }
            
        }
        
         return stack.pop();
        

    }

    public static boolean isNumeric(String str)
    {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
