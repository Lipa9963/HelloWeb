 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author admin
 */
public class FlowNetwork {
    
    
    private int [] id = new int[2];
    ArrayList<FlowNetwork> exitList = new ArrayList<FlowNetwork>();
    
    
    public void addChild(FlowNetwork newExit)
    {
        // Arrays.equals
        exitList.add(newExit);
    }
    
    
    

    /**
     * @return the id
     */
    public int[] getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int[] id) {
        this.id = id;
    }
    
    public void setId(int level, int node)
    {
        id[0]=level;
        id[1]=node;
    }

    
    
   
   
}
