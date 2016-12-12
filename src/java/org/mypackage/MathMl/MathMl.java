/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.MathMl;

/**
 *
 * @author admin
 */
public class MathMl {
    
    
    public static String addSqrt(String s)
    {
        String mathTag = "<math display='block'><mrow><msqrt><mn>"+s+"</mn></msqrt></mrow></math>";
        return mathTag;
    }
    
    public static String addPlus(String first, String two)
    {
        //String mathTag = "<math display='block'><mrow><mn>"+two+"</mn><mo>+</mo><mn>"+first+"</mn></mrow></math>";
        String mathTag = "<math display='block'><mrow><mo stretchy='false'>(</mo><mn>"+two+"</mn><mo>+</mo><mn>"+first+"</mn><mo stretchy='false'>)</mo></mrow></math>";
        return mathTag;
    }
    public static String addPlusAndEqual(String first, String two)
    {
        //String mathTag = "<math display='block'><mrow><mn>"+two+"</mn><mo>+</mo><mn>"+first+"</mn></mrow></math>";
        String mathTag = "<math display='block'><mrow><mo stretchy='false'>(</mo><mn>"+two+"</mn><mo>+</mo><mn>"+first+"</mn><mo stretchy='false'>)</mo></mrow></math>";
        return mathTag;
    }
    public static String addMinus(String first, String two)
    {
        //String mathTag = "<math display='block'><mrow><mn>"+two+"</mn><mo>&#x2212;</mo><mn>"+first+"</mn></mrow></math>";
        String mathTag = "<math display='block'><mrow><mo stretchy='false'>(</mo><mn>"+two+"</mn><mo>&#x2212;</mo><mn>"+first+"</mn><mo stretchy='false'>)</mo></mrow></math>";

        return mathTag;
    }
    
    
    public static String addMul(String first, String two)
    {
        String mathTag = "<math display='block'><mrow><mo stretchy='false'>(</mo><mn>"+two+"</mn><mo>*</mo><mn>"+first+"</mn><mo stretchy='false'>)</mo></mrow></math>";
     //String mathTag = "<math display='block'><mrow><mn>"+two+"</mn><mo>+</mo><mn>"+first+"</mn></mrow></math>";
        return mathTag;
    }
    
    public static String addDivision(String first, String two)
    {
         String mathTag = "<math display='block'><mrow><mfrac><mn>"+two+"</mn><mn>"+first+"</mn></mfrac></mrow></math>";
         return mathTag;
    }
    
    public static String addeXponent(String ex, String in)
    {
        String mathTag = "<math display='block'><mrow><msup><mn>"+ex+"</mn><mn>"+in+"</mn></msup></mrow></math>";
        return mathTag;
    }
    
    public static String addEqual(String st, String result)
    {
        String mathTag = "<math display='block'><mrow><mn>"+st+"</mn><mo>=</mo><mn>"+result+"</mn></mrow></math>";
        return mathTag;
    }
    
     public static String addNum(String num)
    {
        String mathTag ="<math display='block'><mrow><mn>"+num+"</mn></mrow></math>";
        return mathTag;
    }
    
    
    

}
