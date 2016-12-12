/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mypackage.MathMl.MathMl;
import org.mypackage.algorithm.PostfixToInfix;
import org.mypackage.algorithm.ReversePolishSolution;
import org.mypackage.algorithm.ReversePolish;
import org.mypackage.algorithm.ShuntingYard;
import org.mypackage.generalHelpMethods.FormatNumbers;
import org.mypackage.generalHelpMethods.StringSet;
import org.mypackage.jsons.Answer;
import org.mypackage.jsons.AnswerList;
import org.mypackage.jsons.AnswerStep;

/**
 *
 * @author admin
 */
public class MainController {

    static Logger log = Logger.getLogger(ReversePolishSolution.class.getName());
    private static AnswerList jsonList;
    public static  AnswerList startProcessing(String Expression)
    {
        try {
            
        
        jsonList = new AnswerList();
        String[] SY;
        String[] expressionArray;
      
        expressionArray = StringSet.removeLatex(Expression);
               //55\cdot88 55*88    22^{4^3}\ +\frac{88}{2}  \frac{44}{88}+\sqrt{122}   \frac{44}{88}+\sqrt{122}^{\frac{88}{2}}
        
  //      expressionArray = FormatNumbers.formatDouble(expressionArray);
       
        boolean stop = true;
              
              //get the ShuntingYard expression in SY eg: 5 3 +     
        SY = ShuntingYard.postfix(expressionArray);
        ReversePolishSolution reversePolishSolution = new ReversePolishSolution();
        AnswerStep answerStep ;
       
        
        do {
            answerStep = new AnswerStep();
            answerStep = reversePolishSolution.evalRPN(SY);
            int size = answerStep.getPostFixAfter().length;                    
            if ( size ==1 || size == 0 )// if there is more expression to solve
            {
               stop = false;
              
            }else{
               
                SY = answerStep.getPostFixAfter();
            }
            jsonList.add(answerStep);
            
                       
        } while (stop);
        
       
        return jsonList;
        
        
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return jsonList;
        }
        
    }

   
}
