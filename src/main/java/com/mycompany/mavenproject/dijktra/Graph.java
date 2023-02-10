/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.dijktra;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
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
    private ArrayList<Vertex> listV = new ArrayList<>();
    private ArrayList<Edge> listE = new ArrayList<>();
    private static HashMap<Vertex,Object> mapVertex = new HashMap(); // Vertex va GUI vertex
    private static HashMap<Edge,Object> mapEdge = new HashMap();
    
    
    private static boolean IndirectGraph = false;
    
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
            if(r1 != r2){   
                if(!IndirectGraph ){
                    if(!aVertex[2].getAdjacentNode().containsKey(aVertex[r1])){
                        aVertex[r1].addAdjacentNode(aVertex[r2], numEdge);
                        i--;
                        numEdge--;
                    }
                }
                if(IndirectGraph){
                    if(aVertex[r2].getAdjacentNode().containsKey(aVertex[r1])){
                        numEdge = aVertex[r2].getAdjacentNode().get(aVertex[r1]);
                        i++;
                    }
                    aVertex[r1].addAdjacentNode(aVertex[r2], numEdge);// tao 1 canh tu r1 den r2
                    aVertex[r2].addAdjacentNode(aVertex[r1], numEdge);
                    i--;
                    numEdge --;
                }   
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
        int max = 800; int min = 0;
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
//        indirectionGraph();
//        ranGraph();
//        matrixGraph();
        Vertex A = new Vertex("A",150,350,"yellow");
        Vertex B = new Vertex("B",350,350,"yellow");
        Vertex C = new Vertex("C",150,450,"yellow");
        Vertex D = new Vertex("D",350,450,"yellow");
        listV.add(A);
        listV.add(B);
        listV.add(C);
        listV.add(D);
        
        Edge e1 = new Edge(A, B,1,"white");
        Edge e2 = new Edge(B,A,1,"white");
        Edge e3 = new Edge(A,C,2,"white");
        Edge e4 = new Edge(D,C,3,"white");
        Edge e5 = new Edge(C,D,3,"white");
        listE.add(e1);
        listE.add(e2);
        listE.add(e3);
        listE.add(e4);
        listE.add(e5);
        
        

    }
    
    public void indirectionGraph(){
        IndirectGraph = true;
    }
    public void directionGraph(){
        IndirectGraph = false;
    }
    
    
    public mxGraph getGraph() {
        return graph;
    }

    public void setGraph(mxGraph graph) {
        this.graph = graph;
    }

    public ArrayList<Vertex> getListV() {
        return listV;
    }

    public void setListV(ArrayList<Vertex> listV) {
        this.listV = listV;
    }
    
    public ArrayList<Edge> getListE() {
        return listE;
    }

    public void setListE(ArrayList<Edge> listE) {
        this.listE = listE;
    }

    public HashMap getMapVertex() {
        return mapVertex;
    }

    public static void setMapVertex(HashMap mapVertex) {
        Graph.mapVertex = mapVertex;
    }
    
    public HashMap getMapEdge(){
        return mapEdge;
    }
    
    public static void setMapEdge(HashMap mapEdge){
        Graph.mapEdge = mapEdge;
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
//            for (Vertex v : listV) {
//                Object v1 = graph.insertVertex(parent, null, v.getName(), v.getPositionX(), v.getPositionY(), 80,
//                        30, "fillColor=white");
//                mapVertex.put(v, v1);
//            }
//            
//            for (Vertex v : listV) {
//                for (Map.Entry<Vertex, Integer> entry : v.getAdjacentNode().entrySet()) {
//                    //source la (Object v : v1), target la object trong adjacentNode
//                    graph.insertEdge(parent, null, entry.getValue(), mapVertex.get(v), mapVertex.get(entry.getKey()));
//                    
//                }
//            }
            //duyet canh
            for(Edge e : listE){
                //lay cac dinh nguon va dich, kiem tra chung da duoc tao GUI chua, neu chua thi tao va them vao map
                Vertex source = e.getSource();
                Vertex destiny = e.getDestiny();
                Object sourceV;
                Object destinyV;
                if(! mapVertex.containsKey(source)){
                    sourceV = graph.insertVertex(parent, null, source.getName(),source.getPositionX(), source.getPositionY(),80, 30);
                    mapVertex.put(source, sourceV);
                }
                else{
                    sourceV = mapVertex.get(source);
                }

                if(! mapVertex.containsKey(destiny)){
                    destinyV = graph.insertVertex(parent, null, destiny.getName(), destiny.getPositionX(),destiny.getPositionY() ,80, 30);
                    mapVertex.put(destiny, destinyV);
                }
                else{
                    destinyV = mapVertex.get(destiny);
                }
                Object e1 = graph.insertEdge(parent, null , e.getWeight(), sourceV, destinyV);
                mapEdge.put(e,e1);
            }   

        } finally {
            graph.getModel().endUpdate();
        }
    }
}
