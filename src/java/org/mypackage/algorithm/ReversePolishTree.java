/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.algorithm;

import java.util.Stack;
import org.mypackage.Tree.Node;
import org.mypackage.jsons.AnswerStep;

/**
 *
 * @author admin
 */
public class ReversePolishTree {
  
    
    public static Node evalRPN(String[] tokens) {
        Stack<Object> stack = new Stack<>();
        String operators = "+-*/^√";
        Node node = new Node();
        Object right,left;
         for (int i = 0; i < tokens.length; i++)
         {
             if (!operators.contains(String.valueOf(tokens[i]))) {
                stack.push(tokens[i]);
            } else {
                 
                 int index = operators.indexOf(tokens[i]);
                 
                 switch(index)
                 {
                     case 0:
                         node = new Node("+", true, 1);
                         right = stack.pop();
                         left = stack.pop();
                         node.insertChild(left, right);
                         stack.push(node); 
                         break;
                     case 1:
                         node = new Node("-", true, 1);
                         right = stack.pop();
                         left  = stack.pop();
                         node.insertChild(left, right);
                         stack.push(node); 
                         break;
                     case 2:   
                         node = new Node("*", true, 2);
                         right = stack.pop();
                         left  = stack.pop();
                         node.insertChild(left, right);
                         stack.push(node); 
                         break;
                     case 3:   
                         node = new Node("/", true, 2);
                         right = stack.pop();
                         left  = stack.pop();
                         node.insertChild(left, right);
                         stack.push(node); 
                         break;
                      case 4:   
                         node = new Node("^", true, 3);
                         right = stack.pop();
                         left  = stack.pop();
                         node.insertChild(left, right);
                         stack.push(node); 
                         break;
                       case 5:   
                         node = new Node("√", true, 3);
                         left = stack.pop();
                         right = new Node("", false, 0);
                         node.insertChild(left, right);
                         stack.push(node); 
                         break;  
                         
                 }
                 
                 
             }
         }
        
        return (Node)stack.pop();
    }
    
}
