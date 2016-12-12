/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.generalHelpMethods;

/**
 *
 * @author admin
 */
public class StringSet {
    
    
    
    public static String[] removeLatex(String str)
    {
        String[] expressionArray;
        String result = str.replaceAll("\\\\",""); //remove all "\\" and "\"
        result = result.replaceAll("frac","/");
        result = result.replaceAll("cdot","*");
        result = result.replaceAll("sqrt","√");
        result = result.replaceAll("right","");
        result = result.replaceAll("left","");
        result = StringSet.addDiv(result);
        result = StringSet.addParenthesisForSqer(result);
        result = result.replaceAll("\\s+",""); //remove all spaces
        
        expressionArray = result.split
                ("(?<=\\+)|(?=\\+)|(?<=\\-)|(?=\\-)|(?<=\\^)|(?=\\^)|(?<=\\*)|(?=\\*)|(?<=\\/)|"
                        + "(?=\\/)|(?<=\\()|(?=\\()|(?<=\\))|(?=\\))|(?<=\\√)|(?=\\√)|(?<=\\{)|(?=\\{)|(?<=\\})|(?=\\})");
        
        return expressionArray;
    }
    
    public static String addParenthesisForSqer(String str)
    {
        StringBuilder strB = new StringBuilder();
        for(int i=0 ; i<str.length();i++ )
        {
            char c = str.charAt(i);
            if(c == '√')
            {
                strB.append("{");
                strB.append(c);
                while(c!='}')
                {
                    i++;
                    c = str.charAt(i);
                    if(c == '}')
                    {
                        strB.append("}");
                    }
                    strB.append(c);
                }
            }
            else
            {
                strB.append(c);
            }
        }
        
        
        return strB.toString();
    }
            
            
    
    public static String addDiv(String str)
    {
        StringBuilder strB = new StringBuilder();
        for(int i=0 ; i<str.length();i++ )
        {
            char c = str.charAt(i);
            if(c == '/')
            {
                while(c !='}')
                {
                    i++;
                    c = str.charAt(i);
                    strB.append(c);
                }
                strB.append("/");
                
            }
            else
            {
                strB.append(c);
            }
        }
        
        return strB.toString();
        
    }
    
}
