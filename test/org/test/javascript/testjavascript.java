/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test.javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author admin
 */
public class testjavascript {
    public static void main(String[] args) throws Exception{
    ScriptEngineManager mgr = new ScriptEngineManager();
    
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    String foo = "40+2";
    
    System.out.println(engine.eval(foo));
    } 
}
