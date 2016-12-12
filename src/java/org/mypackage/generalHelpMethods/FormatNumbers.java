/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.generalHelpMethods;

import static com.sun.el.lang.ELArithmetic.isNumber;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Logger;

import org.mypackage.algorithm.ReversePolishSolution;

/**
 *
 * @author admin
 */
public class FormatNumbers {
    
    static Logger log = Logger.getLogger(ReversePolishSolution.class.getName());
    public static String fmt(double d) {
    if(d == (long) d)
        return String.format("%d",(long)d);
    else
        return String.format("%s",d);
    }
    
    
    public static String formatDouble(String num)
    {
        double answer = Double.valueOf(num);
        DecimalFormat df = new DecimalFormat("###.###");
        return df.format(answer);
        
    }
    public static String[] formatDouble(String[] array)
    {
        for(int i=0; i< array.length; i++)
        {
          if(!isOperators(array[i]))
          {
            double answer = Double.valueOf(array[i]);
            DecimalFormat df = new DecimalFormat("###.#");
            array[i] = df.format(answer);
          }
        }
        
        return array; 
        
    }
    
    public static String[] FromSquareToExponent(String[] array)
    {
        for(int i=0; i< array.length; i++)
        {
            if(array[i].equals("√"))
            {
                array[i]="^";
            }
        }
        return array;
    }
    
    public static List<String> formatDouble(List<String> list)
    {
        
        for(int i=0; i< list.size(); i++)
        {
          if(isNumber(list.get(i)))
          {
            double answer = Double.valueOf(list.get(i));
            DecimalFormat df = new DecimalFormat("###.#");
            list.set(i, df.format(answer));
          }
        }
        
        return list; 
        
    }
    
    public static String roundBig(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return Double.toString(bd.doubleValue());
    }
    public static String round(double value, int places) 
    {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return Double.toString((double) tmp / factor);
    }
    
    
     
    
    public static boolean isOperators(String s)
    {
         String operators = "+-*/^()√";
         return operators.contains(s);
    }
    
  
    
    
}
