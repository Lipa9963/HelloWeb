/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Tree;

/**
 *
 * @author admin
 */
public class Node {
     private String value;
     private boolean isOperator;
     private int priority;
     private int level;
     private int id;

    
     
     private Node right;
     private Node left;
     
    public Node(){
    }    
    public Node(String v,boolean op,int pri)
    {
        value = v;
        isOperator = op;
        priority = pri;
    }
    
    public void insertChild(Object left,Object right)
    {
        if(left instanceof Node)
        {
            this.setLeft((Node)left);
        }
        else
        {
            String num = (String)left;
            this.setLeft(new Node(num, false, 0));
        }
        
        if(right instanceof Node)
        {
            this.setRight((Node)right);
        }
        else
        {
            String num = (String)right;
            this.setRight(new Node(num, false, 0));
        }
        
        
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the isOperator
     */
    public boolean isIsOperator() {
        return isOperator;
    }

    /**
     * @param isOperator the isOperator to set
     */
    public void setIsOperator(boolean isOperator) {
        this.isOperator = isOperator;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return the right
     */
    public Node getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node left) {
        this.left = left;
    }
        
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
