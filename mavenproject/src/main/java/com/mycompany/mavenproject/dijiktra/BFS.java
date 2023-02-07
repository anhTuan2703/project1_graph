/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.dijiktra;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author vitua
 */
public class BFS {
    private Graph g;
    private Main m;

    public void bfs(Vertex s){
        g = new Graph();
        m = new Main();
        Queue<Vertex> q = new ArrayDeque<>();
        for(Vertex v: g.getListV()){
            if(!v.equals(s)){
                v.setColor("white");
            }
        }
        m.showVertex(s, "gray");
        q.add(s);
        while(! q.isEmpty()){
           Vertex u = q.poll();
           for(Vertex v: u.getAdjacentNode().keySet() ){
               if(v.getColor().equals("white")){
                   m.showVertex(v, "gray");
                   q.add(v);
               }
           }
           m.showVertex(u, "black");
        }
    }
}
