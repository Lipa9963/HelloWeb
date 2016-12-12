/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.jsons;

/**
 *
 * @author admin
 */
public class AnswerStep {

    private String[] postFixBefore;
    private String[] postFixAfter;
    private String infixBefore;
    private String infixAfter;
    private String infixCalculation;
    private String infixCalculationMathMl;
    private String operator;
    private String expressionUL;
    private String expressionDR;

    /**
     * @return the postFixBefore
     */
    public String[] getPostFixBefore() {
        return postFixBefore;
    }

    /**
     * @param postFixBefore the postFixBefore to set
     */
    public void setPostFixBefore(String[] postFixBefore) {
        this.postFixBefore = postFixBefore;
    }
    

    /**
     * @return the postFixAfter
     */
    public String[] getPostFixAfter() {
        return postFixAfter;
    }

    /**
     * @param postFixAfter the postFixAfter to set
     */
    public void setPostFixAfter(String[] postFixAfter) {
        this.postFixAfter = postFixAfter;
    }

    /**
     * @return the infixBefore
     */
    public String getInfixBefore() {
        return infixBefore;
    }

    /**
     * @param infixBefore the infixBefore to set
     */
    public void setInfixBefore(String infixBefore) {
        this.infixBefore = infixBefore;
    }

    /**
     * @return the infixAfter
     */
    public String getInfixAfter() {
        return infixAfter;
    }

    /**
     * @param infixAfter the infixAfter to set
     */
    public void setInfixAfter(String infixAfter) {
        this.infixAfter = infixAfter;
    }

    /**
     * @return the infixCalculation
     */
    public String getInfixCalculation() {
        return infixCalculation;
    }

    /**
     * @param infixCalculation the infixCalculation to set
     */
    public void setInfixCalculation(String infixCalculation) {
        this.infixCalculation = infixCalculation;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return the expressionUL
     */
    public String getExpressionUL() {
        return expressionUL;
    }

    /**
     * @param expressionUL the expressionUL to set
     */
    public void setExpressionUL(String expressionUL) {
        this.expressionUL = expressionUL;
    }

    /**
     * @return the expressionDR
     */
    public String getExpressionDR() {
        return expressionDR;
    }

    /**
     * @param expressionDR the expressionDR to set
     */
    public void setExpressionDR(String expressionDR) {
        this.expressionDR = expressionDR;
    }

    /**
     * @return the infixCalculationMathMl
     */
    public String getInfixCalculationMathMl() {
        return infixCalculationMathMl;
    }

    /**
     * @param infixCalculationMathMl the infixCalculationMathMl to set
     */
    public void setInfixCalculationMathMl(String infixCalculationMathMl) {
        this.infixCalculationMathMl = infixCalculationMathMl;
    }

}
