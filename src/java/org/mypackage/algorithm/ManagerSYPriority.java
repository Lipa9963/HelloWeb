/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class ManagerSYPriority {

    private boolean plus = false;
    private boolean minus = false;
    private boolean mul = false;
    private boolean div = false;
    private boolean squr = false;
    private boolean exp = false;

    // all
    private String[] r1 = {"+", "-", "/", "*", "√", "^"};
    private String[] r2 = {"+", "-", "*", "/", "^", "√"};
    private String[] r3 = {"+", "-", "*", "/", "√", "^"};
    private String[] r4 = {"+", "-", "/", "*", "^", "√"};
    private String[] r5 = {"+", "-", "/", "*", "√", "^"};
    private String[] r6 = {"-", "+", "/", "*", "^", "√"};
    private String[] r7 = {"-", "+", "*", "/", "^", "√"};
    private String[] r8 = {"-", "+", "*", "/", "√", "^"};
    private String[] r9 = {"-", "+", "/", "*", "√", "^"};
    //////////////////////////////////////////////////////two operators
    //all two combination
    private String[] r10 = {"-", "+", "/", "*", "√", "^"};
    private String[] r11 = {"+", "-", "*", "/", "^", "√"};
        
    //////////////////////////////////////////////////////////three operator
    // all combination of three operators 
    // All combination of 2 for the same type and 1 from other type and 1 from other type
    private String[] r16 = {"-", "+", "*", "/", "^", "√"};
    private String[] r17 = {"+", "-", "/", "*", "√", "^"};
    //////////////////////////////////////////////////////four operators
    // 2 AND 2 for the same type - + , * /
    private String[] r18 = {"-", "+", "*", "/", "^", "√"};
    private String[] r19 = {"+", "-", "*", "/", "√", "^"};
    private String[] r20 = {"-", "+", "/", "*", "√", "^"};    
    private String[] r21 = {"+", "-", "/", "*", "^", "√"};    
    
    
    private static Map<String, Integer> ops = new HashMap<String, Integer>() {{
        put("+", 1);
        put("-", 1);
        put("*", 2);
        put("/", 2);
        put("^", 3);
        put("√", 3);
    }};
    
    public ArrayList<String[]> getPriorityList(String[] expression) {
        ArrayList<String[]> roundList = new ArrayList<String[]>();
 
        String[] SY;
        for(int i = 0 ; i<9 ; i++)
        {
//            SY = ShuntingYard.postfix(expression,grtRound(i));
//            if(!isListOfStringArraysContainsString(roundList,SY))
//            {
//                roundList.add(SY);
//            }
        }
              
        
        return roundList;

    }
   

    public ArrayList<String[]>  getMapPrioritySY(String[] expression)
    {
        ArrayList<String[]> roundList = new ArrayList<String[]>();
        String[] SY;
       SY = ShuntingYard.postfix(expression);
       roundList.add(SY);
       return roundList;
    }

    public static boolean isListOfStringArraysContainsString(List<String[]> arrayList, String[] s) 
    {
        
        for(int i =0 ; i< arrayList.size();i++)
        {
            if (Arrays.equals(arrayList.get(i), s)) {
                return true;
            }
        }
        return false;
        

    }
    
    private String[] grtRound(int i)                        
    {
        switch(i){
            case 0:
            return r1;
            case 1:
            return r2;
            case 2:
            return r3;
            case 3:
            return r4;
            case 4:
            return r5;
            case 5:
            return r6;
            case 6:
            return r7;
            case 7:
            return r8;
            case 8:
            return r9;
        }
               
   return r1;
    }

    private void setOperator(String[] expression) {

        for (int i = 0; i < expression.length; i++) {
            switch (expression[i]) {
                case "+":
                    plus = true;
                    break;
                case "-":
                    minus = true;
                    break;
                case "*":
                    mul = true;
                    break;
                case "/":
                    div = true;
                    break;
                case "√":
                    squr = true;
                    break;
                case "^":
                    exp = true;
                    break;
            }

        }
    }

}
