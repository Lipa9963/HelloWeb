/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.mypackage.Tree.FlowNetwork;

/**
 *
 * @author admin
 */
public class MapPointer extends LinkedHashMap<String,FlowNetwork>{
    
    
    
 

    
    public FlowNetwork put(int level,int per, FlowNetwork value) {
       
        String key = buildKey(level, per);
        return super.put(key, value); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public void add(int level,int pre,FlowNetwork flowNetwork)
    {
        int dadLevel = level+1;
        int count =0;
        //int[] key ={dadLevel,0};
        String key = buildKey(dadLevel, count);
        while(get(key)!= null)// add the note to the fathers child
        {
            get(key).addChild(flowNetwork);
            count =count+1;
            key = buildKey(dadLevel, count);
            
        }
        
        put(level, pre, flowNetwork);//add the node to the map
        
        
    }
    
    
   private String buildKey(int level, int pre)
   {
       String key = Integer.toString(level);
       key +=":";
       key += Integer.toString(pre);
       return key;
   }
   

    
}
