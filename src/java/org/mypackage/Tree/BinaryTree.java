/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
public class BinaryTree {

    public static void printATreeLevelByLevel(Node n)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(n);
        int node = 1; //because at root
        int child = 0; //initialize it with 0 
        while (queue.size() != 0) {
            Node n1 = queue.remove();
            node--;
            System.err.print(n1.getValue() + " ");

            if (n1.getLeft() != null) {
                queue.add(n1.getLeft());
                child++;
            }
            if (n1.getRight() != null) {
                queue.add(n1.getRight());
                child++;
            }
            if (node == 0) {
                System.err.println();
                node = child;
                child = 0;
            }

        }
    }
    
    public static void setLevel(Node n,int level)
    {
        if(n==null)return;
        n.setLevel(level);
        setLevel(n.getRight(), level+1);
        setLevel(n.getLeft(), level+1);
    }

}
