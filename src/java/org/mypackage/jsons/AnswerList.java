/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.jsons;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class AnswerList {
    
    private List<AnswerStep> list;
    private static final Logger LOG = Logger.getLogger(AnswerList.class.getName());

    public AnswerList() {
       list = new ArrayList<>();
    }
    public AnswerList(List<AnswerStep> list) {
        this.list = list;
    }

    /**
     * @return the list
     */
    public List<AnswerStep> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<AnswerStep> list) {
        this.list = list;
    }
    
    public void add(AnswerStep answerStep)
    {
        list.add(answerStep);
    }
    
    
}
