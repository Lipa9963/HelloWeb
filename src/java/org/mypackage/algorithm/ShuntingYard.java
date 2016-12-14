/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.algorithm;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import static org.jboss.logging.MDC.put;

/**
 *
 * @author admin
 */
public class ShuntingYard {
    
    
    
    private enum Operator
    {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4),EXPONENT(5),SQUARE(6);
        final int precedence;
        Operator(int p) { precedence = p; }
       
     
        
    }

    private static Map<String, Integer> ops = new HashMap<String, Integer>() {{
        put("+", 1);
        put("-", 2);
        put("*", 3);
        put("/", 4);
        put("^", 5);
        put("√", 6);
    }};

    private static boolean isHigerPrec(String op, String sub)
    {
        return (ops.containsKey(sub) && ops.get(sub) >= ops.get(op));
    }
    
    private static void setMap(String[] round)
    {
        for(int i =0; i<round.length; i++)
        {
            ops.put(round[i], i);
        }
    }

    public static String[] postfix(String[] infix, String[] round)
    {
        setMap(round);
        StringBuilder output = new StringBuilder();
        Deque<String> stack  = new LinkedList<>();

        for (int i=0 ; i < infix.length ; i++) {
            // operator
            if (ops.containsKey(infix[i])) {
                while ( ! stack.isEmpty() && isHigerPrec(infix[i], stack.peek()))
                    output.append(stack.pop()).append(' ');
                stack.push(infix[i]);

            // left parenthesis
            } else if (infix[i].equals("{")) {
                stack.push(infix[i]);

            // right parenthesis
            } else if (infix[i].equals("}")) {
                while ( ! stack.peek().equals("{"))
                    output.append(stack.pop()).append(' ');
                stack.pop();

            // digit
            } else {
                output.append(infix[i]).append(' ');
            }
        }

        while ( ! stack.isEmpty())
            output.append(stack.pop()).append(' ');

        return output.toString().split("\\s+");
    }
}
