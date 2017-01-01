/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Tree;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.mypackage.Data.MapPointer;

/**
 *
 * @author admin
 */
public class BinaryTree {

    private HashMap<Integer, Integer> levelId = new HashMap<Integer, Integer>();
          
    //Key =Each Level in the tree. Value = All permutation of this level.
    private HashMap<Integer, ArrayList< Object[]>> listmap = new HashMap<Integer, ArrayList< Object[]>>();
    
    //Key = id of the node. we put Each node to the map. Value = the node himself.
     MapPointer mapPointer = new MapPointer();
    
    private FlowNetwork flowNetwork = new FlowNetwork();

    
    public void buildNetwork()
    {
         int countLevel = listmap.size();
         int[] idStart ={countLevel,0}; 
         
         flowNetwork.setId(idStart);//set thw main node id
         mapPointer.put(countLevel, 0, flowNetwork);
        
         
         
         
        FlowNetwork fn; 
         for(int i =countLevel-1 ;i>=0; i--)
         {
             int levelPermutationSize = listmap.get(i).size();
             ArrayList< Object[]> permutationList = listmap.get(i);  
             for(int j= 0 ;j< levelPermutationSize ; j++ )
             {
               // Object[] per = permutationList.get(j);
               fn = new FlowNetwork();
               fn.setId(i, j);
               mapPointer.add(i, j, fn);//add child to the dad             }
             
             }                        
             
         }
         
    }
    
    
    public  void setLevel(Node n, int level) {
        if (n == null) {
            return;
        }
        n.setLevel(level);
        if(n.isIsOperator())
        {
        if(levelId.get(level)== null)
        {
            levelId.put(level, 1);
            n.setId(1);
        }
        else
        {
            int id =levelId.get(level);
            n.setId(id+1);
            levelId.put(level, id+1);
        }
        }
        
        setLevel(n.getRight(), level + 1);
        setLevel(n.getLeft(), level + 1);
    }
    
    
    public void setPermutation()
    {
        ArrayList<Integer> uniqueList;
      
                Iterator it = levelId.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            
            int levelNodeSize = (int) pair.getValue();
            int level = (int)pair.getKey();
            uniqueList = buildList(levelNodeSize);
            
            permutationOf(uniqueList, levelNodeSize, null, true, level);
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        
        
        
    }
    
    
    private ArrayList<Integer> buildList(int num)
    {
        ArrayList<Integer> uniqueList = new ArrayList<>();
        for(int i =1 ;i<= num ; i++)
        {
            uniqueList.add(i);
        }
        
        return uniqueList;
    }
    
    
    
    private void permutationOf(List<Integer> uniqueList, int permutationSize, List<Integer> permutation, boolean only,int level) {
    if (permutation == null) {
        assert 0 < permutationSize && permutationSize <= uniqueList.size();
        permutation = new ArrayList<>(permutationSize);
        if (!only) {
            if(listmap.get(level)!=null)
            {
                listmap.get(level).add(permutation.toArray());
            }
            else{
                listmap.put(level, new ArrayList<Object[]>());
                listmap.get(level).add(permutation.toArray());
            }
            
            //permutationList.add(permutation.toArray());
            System.out.println(Arrays.toString(permutation.toArray()));
        }
    }
    for (int i : uniqueList) {
        if (permutation.contains(i)) {
            continue;
        }
        permutation.add(i);
        if (!only) {
            if(listmap.get(level)!=null)
            {
                listmap.get(level).add(permutation.toArray());
            }
            else{
                listmap.put(level, new ArrayList<Object[]>());
                listmap.get(level).add(permutation.toArray());
            }
            //permutationList.add(permutation.toArray());
            System.out.println(Arrays.toString(permutation.toArray()));
        } else if (permutation.size() == permutationSize) {
            if(listmap.get(level)!=null)
            {
                listmap.get(level).add(permutation.toArray());
            }
            else{
                listmap.put(level, new ArrayList<Object[]>());
                listmap.get(level).add(permutation.toArray());
            }
           // permutationList.add(permutation.toArray());
            System.out.println(Arrays.toString(permutation.toArray()));
        }
        if (permutation.size() < permutationSize) {
             permutationOf(uniqueList, permutationSize, permutation, only,level);
        }
        permutation.remove(permutation.size() - 1);
    }
}

    
    
    
    
}
