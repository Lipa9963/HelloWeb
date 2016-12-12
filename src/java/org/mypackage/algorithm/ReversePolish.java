/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.algorithm;

import java.util.Stack;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ReversePolish {
    
 
    static Logger log = Logger.getLogger(ReversePolishSolution.class.getName());
   public static String postfixToInfix(final String postfix) {
 
        class Expression {
            final static String ops = "-+/*^√";
 
            String op, ex;
            int prec = 3;
 
            Expression(String e) {
                ex = e;
            }
             
            Expression(String e1, String e2, String o) {
                ex = String.format("%s %s %s", e1, o, e2);
                op = o;
                prec = ops.indexOf(o) / 2;
            }
 
            @Override
            public String toString() {
                return ex;
            }
        }
 
        Stack<Expression> expr = new Stack<>();
 
        for (String token : postfix.split("\\s+")) {
            char c = token.charAt(0);
            int idx = Expression.ops.indexOf(c);
            // case of square symbol 
            if(idx == 5)
            {
                Expression e = expr.pop();
                String mathTag = "<math display='block'><mrow><msqrt><mn>"+e.ex+"</mn></msqrt></mrow></math>";
                expr.push(new Expression(mathTag));
            }
            else if  (idx != -1 && token.length() == 1)
            {
               
                Expression r = expr.pop();
                Expression l = expr.pop();
 
                int opPrec = idx / 2;
 
                if (l.prec < opPrec || (l.prec == opPrec && c == '^'))
                    l.ex = '(' + l.ex + ')';
 
                if (r.prec < opPrec || (r.prec == opPrec && c != '^'))
                    r.ex = '(' + r.ex + ')';
 
                expr.push(new Expression(l.ex, r.ex, token));
            } else {
                expr.push(new Expression(token));
            }
            //System.out.printf("%s -> %s%n", token, expr);
        }
        return expr.peek().ex;
    }
    
    static String calculacionOneStep(String rpn)
    {
       Stack st = new Stack();
       
       for (String token : rpn.split("(?!^)")) 
       {
           
           
       }
        return "fsf";
    }
    
}
