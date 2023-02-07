/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.dijiktra;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Graph extends JFrame {
    private mxGraph graph;
    private mxGraphComponent graphComponent;
    private  List<Vertex> listV = new ArrayList<>();
    private static  HashMap m = new HashMap();
  
    public Graph() {
        super("Abc");
        initGraph();
        initGui();

    }
    
    public void ranGraph(){
        
        Scanner sc = new Scanner(System.in);
        
        int numVertex ;
        int numEdge ;       
        numVertex = sc.nextInt();
        numEdge = sc.nextInt();
        Vertex [] aVertex = new Vertex[50];
        
        int max = 500; int min = 0;
        int x,y;
        
        for(int i = 1; i <= numVertex; i++){
            x = (int)(Math.random()*(max - min) + 1 + min);
            y = (int)(Math.random()*(max - min) + 1 + min);
            aVertex[i] = new Vertex("Vertex"+String.valueOf(i),x,y);
            listV.add(aVertex[i]);
        }
        int r1, r2;
        int i = numEdge;
        while(i >= 0){
            r1 = (int)(Math.random()*numVertex ) + 1;
            r2 = (int)(Math.random()*numVertex ) + 1;
            if(r1 != r2){// && !aVertex[2].getAdjacentNode().containsKey(aVertex[r1])){
                if(aVertex[r2].getAdjacentNode().containsKey(aVertex[r1]) ){
                    numEdge = aVertex[r2].getAdjacentNode().get(aVertex[r1]);
                    i++;
                }
                aVertex[r1].addAdjacentNode(aVertex[r2], numEdge);
                numEdge --;
                i--;
            }     
        }
    }
    
    public void matrixGraph(){
        
        int numVertex;
        Vertex [] aVertex  = new Vertex[50];
        int[][] matrix = new int[50][50];
        Scanner input = new Scanner(System.in);
        System.out.print("nhap so dinh: ");
        numVertex = input.nextInt();
        int max = 500; int min = 0;
        int x,y;
        
        
        for(int i = 0; i < numVertex; i++){
            x = (int)(Math.random()*(max - min) + 1 + min);
            y = (int)(Math.random()*(max - min) + 1 + min);            
            aVertex[i] = new Vertex("Vertex" + String.valueOf(i), x,y);
            listV.add(aVertex[i]);
        }
        
        
	for(int row = 0; row < numVertex; row++) {
            for(int col = 0; col< numVertex; col++) {
                matrix[row][col] = input.nextInt(); 
                if(matrix[row][col] != 0 && row != col){
                    aVertex[row].addAdjacentNode(aVertex[col], matrix[row][col]);
                }
            }
        }
    }
    public void initGraph() {

        ranGraph();
//        matrixGraph();

        // random: nhap so dinh, so canh
        // nhap tay
        // file 
        // ma tran
        // danh sach ke
//        Vertex A = new Vertex("A",150,150);
//        Vertex B = new Vertex("B",300,150);
//        Vertex C = new Vertex("C",450,150);
//        Vertex D = new Vertex("D",150,300);
//        Vertex E = new Vertex("E",450,300);
//        Vertex G = new Vertex("G",450,450);       
//        A.addAdjacentNode(B, 1);
//        A.addAdjacentNode(E, 1);
//        E.addAdjacentNode(C, 1);
//        E.addAdjacentNode(D, 1);
//        C.addAdjacentNode(B, 1);
//        listV.add(A);
//        listV.add(B);
//        listV.add(C);
//        listV.add(D);
//        listV.add(E);
//        listV.add(G);
    }
    
    public void indirectionGraph(){
        
    }
    public void directionGraph(){
        
    }
    
    
    public mxGraph getGraph() {
        return graph;
    }

    public void setGraph(mxGraph graph) {
        this.graph = graph;
    }

    public List<Vertex> getListV() {
        return listV;
    }

    public void setListV(List<Vertex> listV) {
        this.listV = listV;
    }

    public HashMap getM() {
        return m;
    }

    public static void setM(HashMap m) {
        Graph.m = m;
    }
    
    

    public void initGui() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        graph = new mxGraph();
        graphComponent = new mxGraphComponent(graph);
        graph.setMultigraph(false);
        graph.setAllowDanglingEdges(false);
        graphComponent.setConnectable(true);

        graphComponent.setPreferredSize(new Dimension(600, 600));
        getContentPane().add(graphComponent);

        graph.getModel().beginUpdate();
        Object parent = graph.getDefaultParent();
        try {
            for (Vertex v : listV) {
                Object v1 = graph.insertVertex(parent, null, v.getName(), v.getPositionX(), v.getPositionY(), 80,
                        30, "fillColor=white");
                m.put(v, v1);
            }

            for (Vertex v : listV) {
                for (Map.Entry<Vertex, Integer> entry : v.getAdjacentNode().entrySet()) {
                    graph.insertEdge(parent, null, entry.getValue(), m.get(v), m.get(entry.getKey()));
                }
            }

        } finally {
            graph.getModel().endUpdate();
        }
    }
}
