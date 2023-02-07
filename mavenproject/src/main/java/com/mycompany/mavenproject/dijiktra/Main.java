/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.dijiktra;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Admin
 */
public class Main extends Thread {
    
    private Graph g = new Graph();
    private BFS b = new BFS();
    
    public Main() {
        g.setVisible(true);
    }
    @Override
    public void run( ) {
        BFS(g.getListV().get(0));
//        DFS(g.getListV().get(0));
//        TopoSort(); showTopoSort();
        
    }
    
    
  //  ArrayList<Vertex> L = new ArrayList<>();
    Stack<Vertex> S = new Stack<>();
    public Stack<Vertex> TopoSort(){
        for(Vertex u: g.getListV()){
            u.setColor("white");
        }
        
        for(Vertex u: g.getListV()){
            if(u.getColor().equals("white")){
                TopVisit(u);
            }
        }
        return S;
    }
    public void TopVisit(Vertex u){
        showVertex(u, "gray");
        for(Vertex v: u.getAdjacentNode().keySet()){
            if(v.getColor().equals("white")){
                TopVisit(v);
            }
        }
        S.push(u);
    }
    public void showTopoSort(){
        for(int i = 1; i <= S.size(); i++){
            System.out.print(i);
            showVertex(S.pop(), "black");
        }
    }
    
    public void DFS(Vertex u){
        for(Vertex v: g.getListV()){
            v.setColor("white");
        }
        showVertex(u,"yellow");
        for(Vertex v: u.getAdjacentNode().keySet()){
            if(v.getColor().equals("white")){
                DFS(v);
            }
        }
        showVertex(u,"green");
        
    }
    public void BFS(Vertex s){
        Queue<Vertex> q = new ArrayDeque<>();
        for(Vertex v: g.getListV()){
            if(!v.equals(s)){
                v.setColor("white");
            }
        }
        showVertex(s, "gray");
        q.add(s);
        while(! q.isEmpty()){
           Vertex u = q.poll();
           for(Vertex v: u.getAdjacentNode().keySet() ){
               if(v.getColor().equals("white")){
                   showVertex(v, "yellow");
                   q.add(v);
               }
           }
           showVertex(u, "green");
        }
    }
    public void showVertex(Vertex v, String color){
        waitS(1200);
        v.setColor(color);
        changeColor(v);
    }
    public void waitS(int sec){
        try {
           Thread.sleep(sec);
        } catch (InterruptedException e) {
           System.out.println(e);
        }
    }
    public void changeColor(Vertex s){
        g.getGraph().getModel().setStyle(g.getM().get(s), "fillColor="+s.getColor());
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.start();
    }
}
