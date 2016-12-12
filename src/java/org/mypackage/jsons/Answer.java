/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.jsons;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Answer {
    
    private int step;
    private String expression;
    private String resultingExpressionInfixAfterAction;
    private ArrayList<String> resultingExpressionPostfix;
    private String resultingExpressionInfix;

    
    public void setResultingExpressionPostfix(ArrayList<String> resultingExpressionPostfix) {
        this.resultingExpressionPostfix = resultingExpressionPostfix;
    }

    public String getResultingExpressionInfix() {
        return resultingExpressionInfix;
    }

    public void setResultingExpressionInfix(String resultingExpressionInfix) {
        this.resultingExpressionInfix = resultingExpressionInfix;
    }
    private String explanation;

    public Answer() {
        this.resultingExpressionPostfix = new ArrayList<>();
    }

    /**
     * @return the step
     */
    public int getStep() {
        return step;
    }

    /**
     * @param step the step to set
     */
    public void setStep(int step) {
        this.step = step;
    }

    /**
     * @return the expression
     */
    public String getExpression() {
        return expression;
    }

    /**
     * @param expression the expression to set
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * @return the resultingExpressionInfixAfterAction
     */
    public String getResultingExpressionInfixAfterAction() {
        return resultingExpressionInfixAfterAction;
    }

    /**
     * @param resultingExpressionInfixAfterAction the resultingExpressionInfixAfterAction to set
     */
    public void setResultingExpressionInfixAfterAction(String resultingExpressionInfixAfterAction) {
        this.resultingExpressionInfixAfterAction = resultingExpressionInfixAfterAction;
    }

    /**
     * @return the resultingExpression
     */
    public String getResultingExpressionPostfix() {
        String[] array = new String[resultingExpressionPostfix.size()];
        array = resultingExpressionPostfix.toArray(array);
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i <  array.length; i++) 
        {
            strBuilder.append( array[i]);
            strBuilder.append(" ");
        }
        return strBuilder.toString();
    }
    
    public int getResultingExpressionPostfixSize()
    {
        return this.resultingExpressionPostfix.size();
    }
    
    public String[] getResultingExpressionPostfixEsStringArray()
    {
        String[] array = new String[resultingExpressionPostfix.size()];
        array = resultingExpressionPostfix.toArray(array);
        return array;
    }

    /**
     * @param resultingExpression the resultingExpression to set
     */
    public void setResultingExpression(ArrayList<String>  resultingExpression) {
        this.resultingExpressionPostfix = resultingExpression;
    }
    public void setResultingExpression(String resultingExpression) {
        this.resultingExpressionPostfix.add(resultingExpression);
    }

    /**
     * @return the explanation
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * @param explanation the explanation to set
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    
}
