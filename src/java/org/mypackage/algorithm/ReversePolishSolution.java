/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.algorithm;
import java.math.BigInteger;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.mypackage.MathMl.MathMl;
import org.mypackage.generalHelpMethods.FormatNumbers;
import org.mypackage.jsons.Answer;
import org.mypackage.jsons.AnswerStep;

/**
 *
 * @author admin
 */
public class ReversePolishSolution {
  //5*(8+3/2)
    static Logger log = Logger.getLogger(ReversePolishSolution.class.getName());
    private Stack<String> stack = new Stack<String>();
    private ArrayList<String> mylist = new ArrayList<String>();
    private Answer answer = new Answer();
    private AnswerStep answerStep;
    
     private Answer answerForAfter = new Answer();
    private Double a ,b;

    public  AnswerStep evalRPN(String[] tokens) {

       

        try {
            
        
        String operators = "+-*/^√";
        String stringAfterFormat = null;
        String result,aa,bb;
        stack.clear();
        mylist.clear();
        answerStep = new AnswerStep();
        answerForAfter = new Answer();
        
         //set before
         answerStep.setPostFixBefore(tokens);
         answerStep.setInfixBefore(PostfixToInfix.reverse(tokens));
        
        for (int i = 0; i < tokens.length; i++) {

            if (!operators.contains(String.valueOf(tokens[i]))) {
                stack.push(String.valueOf(tokens[i]));
            } else {
            
                
                
                int index = operators.indexOf(tokens[i]);
                switch (index) {
                    case 0:
                        
                        a = Double.parseDouble(stack.pop());
                        b = Double.parseDouble(stack.pop());
                                               
                        
                        result = FormatNumbers.formatDouble(String.valueOf(a + b));
                        bb = FormatNumbers.formatDouble(String.valueOf(b));
                        aa= FormatNumbers.formatDouble(String.valueOf(a));
                        stringAfterFormat = MathMl.addPlus(aa,bb);
                        stringAfterFormat = MathMl.addEqual(stringAfterFormat, result);
                        
                        answerStep.setInfixCalculationMathMl(stringAfterFormat);
                        answerStep.setExpressionDR(String.valueOf(b));
                        answerStep.setExpressionUL(String.valueOf(a));
                        answerStep.setOperator("+");
                        answerStep.setPostFixAfter(PopAll(result,tokens,i+1));
                        answerStep.setInfixAfter(PostfixToInfix.reverse(answerStep.getPostFixAfter()));
                                                
                        return answerStep;
                    case 1:
                        
                        a = Double.parseDouble(stack.pop());
                        b = Double.parseDouble(stack.pop());
                        
                        result = FormatNumbers.formatDouble(String.valueOf(b - a));
                        bb = FormatNumbers.formatDouble(String.valueOf(b));
                        aa= FormatNumbers.formatDouble(String.valueOf(a)); 
                        stringAfterFormat = MathMl.addMinus(aa, bb);
                        stringAfterFormat = MathMl.addEqual(stringAfterFormat, result);
                       
                        
                        answerStep.setInfixCalculationMathMl(stringAfterFormat);
                        answerStep.setExpressionDR(String.valueOf(b));
                        answerStep.setExpressionUL(String.valueOf(a));
                        answerStep.setOperator("-");
                        answerStep.setPostFixAfter(PopAll(result,tokens,i+1));
                        answerStep.setInfixAfter(PostfixToInfix.reverse(answerStep.getPostFixAfter()));
                                       
                        return answerStep;
                    case 2:
                        
                        a = Double.parseDouble(stack.pop());
                        b = Double.parseDouble(stack.pop());
                        
                        result = FormatNumbers.formatDouble(String.valueOf(b * a));
                        bb = FormatNumbers.formatDouble(String.valueOf(b));
                        aa= FormatNumbers.formatDouble(String.valueOf(a)); 
                        stringAfterFormat = MathMl.addMul(aa, bb);
                        stringAfterFormat = MathMl.addEqual(stringAfterFormat, result);
                        
                        answerStep.setInfixCalculationMathMl(stringAfterFormat);
                        answerStep.setExpressionDR(String.valueOf(b));
                        answerStep.setExpressionUL(String.valueOf(a));
                        answerStep.setOperator("*");
                        answerStep.setPostFixAfter(PopAll(result,tokens,i+1));
                        answerStep.setInfixAfter(PostfixToInfix.reverse(answerStep.getPostFixAfter()));
                        
                        return answerStep;
                    case 3:
                        
                        a = Double.parseDouble(stack.pop());
                        b = Double.parseDouble(stack.pop());
                        
                        result = FormatNumbers.roundBig((b/a),5);//FormatNumbers.formatDouble(String.valueOf(b / a));
                        bb = FormatNumbers.formatDouble(String.valueOf(b));
                        aa= FormatNumbers.formatDouble(String.valueOf(a)); 
                        stringAfterFormat = MathMl.addDivision(aa, bb);
                        stringAfterFormat = MathMl.addEqual(stringAfterFormat, result);
                      
                        answerStep.setInfixCalculationMathMl(stringAfterFormat);
                        answerStep.setExpressionDR(String.valueOf(a));
                        answerStep.setExpressionUL(String.valueOf(b));
                        answerStep.setOperator("/");
                        answerStep.setPostFixAfter(PopAll(result,tokens,i+1));
                        answerStep.setInfixAfter(PostfixToInfix.reverse(answerStep.getPostFixAfter()));
                                                
                        return answerStep;
                    case 4:
                        a = Double.parseDouble(stack.pop());
                        b = Double.parseDouble(stack.pop());
                        
                        bb = FormatNumbers.formatDouble(String.valueOf(b));
                        aa= FormatNumbers.formatDouble(String.valueOf(a)); 
              
                        double db =Math.pow(2, 5);
                        long mylong = (long)80;
                        
                        String ff = FormatNumbers.formatDouble(Double.toString(db));
                        result = FormatNumbers.roundBig(Double.valueOf(ff),0);
                        stringAfterFormat = MathMl.addeXponent(bb,aa);
                        stringAfterFormat = MathMl.addEqual(stringAfterFormat, result);
                        
                        answerStep.setInfixCalculationMathMl(stringAfterFormat);
                        answerStep.setExpressionDR(String.valueOf(a));
                        answerStep.setExpressionUL(String.valueOf(b));
                        answerStep.setOperator("^");
                        answerStep.setPostFixAfter(PopAll(result,tokens,i+1));
                        answerStep.setInfixAfter(PostfixToInfix.reverse(answerStep.getPostFixAfter()));
                                        
                        return answerStep;
                    case 5:
                        a = Double.parseDouble(stack.pop());
                        
                        result = FormatNumbers.formatDouble(String.valueOf(Math.sqrt(a)));                      
                        stringAfterFormat =MathMl.addSqrt(a.toString());
                        stringAfterFormat = MathMl.addEqual(stringAfterFormat, result);
                        
                        answerStep.setInfixCalculationMathMl(stringAfterFormat);
                        answerStep.setExpressionDR(String.valueOf(a));
                        answerStep.setOperator("√");
                        answerStep.setPostFixAfter(PopAll(result,tokens,i+1));
                        answerStep.setInfixAfter(PostfixToInfix.reverse(answerStep.getPostFixAfter()));
                                                
                        return answerStep;
                }
            }
        }
        
        } catch (Exception e) {
            
            log.log(Level.SEVERE, e.getMessage());
            
        }

       return answerStep;
    }

    private  String[] PopAll(String result,String[] tokens, int index) 
    {
        int size = stack.size();
        ArrayList<String> mylist = new ArrayList<String>();

        
        for(int i =0; i<size; i++)
        {
           mylist.add(stack.get(i));
           
        }
        
       mylist.add(result);
       
       
         while (index< tokens.length)
        {
            mylist.add(tokens[index]);
            index++;
        }
       
        return mylist.toArray(new String[mylist.size()]);
    }

    

}
