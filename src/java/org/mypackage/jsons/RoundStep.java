/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.jsons;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class RoundStep {
    private List<AnswerList> answerLists;
    
    private static final Logger LOG = Logger.getLogger(AnswerList.class.getName());

    public RoundStep() {
        this.answerLists = new ArrayList<>();
    }

     
    /**
     * 
     * @return the answerLists
     */
    public List<AnswerList> getAnswerLists() {
        return answerLists;
    }

    /**
     * @param answerLists the answerLists to set
     */
    public void setAnswerLists(List<AnswerList> answerLists) {
        this.answerLists = answerLists;
    }
    
    public void add(AnswerList al)
    {
        answerLists.add(al);
    }
    
    
    
    
}
