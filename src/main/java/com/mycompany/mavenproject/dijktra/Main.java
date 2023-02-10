/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.dijktra;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Admin
 */
public class Main extends Thread {
    
    private Graph g = new Graph();
    
    public Main() {
        g.setVisible(true);
    }
    @Override
    public void run( ) {
//        BFS(g.getListV().get(0));
//        DFS(g.getListV().get(0));
//        for(Vertex v:g.getListV())
//            showVertex(v, "green");
        for(Edge e: g.getListE()){
            showEdge(e, "green");
        }

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
         try {
           Thread.sleep(1200);
        } catch (InterruptedException e) {
           System.out.println(e);
        }
        v.setColor(color);
        changeColorVertex(v);
    }
    
    public void showEdge(Edge e, String color){
        e.setColor(color);
        try{
            Thread.sleep(900);
        } catch (InterruptedException error){
            System.out.println(error);
        }
        
        changeColorEdge(e);
    }
            
            
            
            
    public void changeColorVertex(Vertex v){
        g.getGraph().getModel().setStyle(g.getMapVertex().get(v), "fillColor="+v.getColor());// get GUI vertex v: v1
    }
    public void changeColorEdge(Edge e){
        int label = e.getLabel();
        for(Edge edge: g.getListE() ){
            if(edge.getLabel() == label){
                edge.setColor(e.getColor());
                g.getGraph().getModel().setStyle(g.getMapEdge().get(edge), "strokeColor=" +edge.getColor());
            }
        }
        g.getGraph().getModel().setStyle(g.getMapEdge().get(e), "strokeColor=" +e.getColor());
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.start();
    }
}
