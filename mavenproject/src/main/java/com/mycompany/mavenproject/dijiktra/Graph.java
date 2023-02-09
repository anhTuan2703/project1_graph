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
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Graph extends JFrame {

    private mxGraph graph;
    private mxGraphComponent graphComponent;
    private ArrayList<Vertex> listV = new ArrayList<>();

    private List<Edge> listE = new ArrayList<>();    // dung cho thuat toan kruskal
    private List<Edge> listEContrast = new ArrayList<>();    // dung cho thuat toan kruskal

    private static HashMap m = new HashMap(); // lưu đỉnh để đưa vào đồ thị visualize
    private static HashMap m1 = new HashMap(); // lưu cạnh
    private static HashMap m1Contrash = new HashMap(); // lưu cạnh

    public Graph() {
        super("Abc");
        initGraph();
        initGui();

    }

    public void initGraph() {

//        int n = 4;
//        int max = 500; int min = 0;
//        int x,y;
//        Vertex [] aVertex = new Vertex[50];
//        for(int i = 1; i <= n; i++){
//            x = (int)(Math.random()*(max - min) + 1 + min);
//            y = (int)(Math.random()*(max - min) + 1 + min);
//            aVertex[i] = new Vertex("Vertex"+String.valueOf(i),x,y);
//            listV.add(aVertex[i]);
//        }
//        int r1, r2;
//        int edge = 3;
//        while(edge >= 0){
//            r1 = (int)(Math.random()*n ) + 1;
//            r2 = (int)(Math.random()*n ) + 1;
//            if(r1 != r2 && !(aVertex[r2].getTarList().contains(aVertex[r1]))){
//                aVertex[r1].addAdjacentNode(aVertex[r2], edge);
//                aVertex[r1].addTarList(aVertex[r2]);
//                edge --;
//            }     
//        }
        Vertex A = new Vertex("A", 150, 150);
        Vertex B = new Vertex("B", 300, 150);
        Vertex C = new Vertex("C", 450, 150);
        Vertex D = new Vertex("D", 150, 300);
        Vertex E = new Vertex("E", 450, 300);
        A.addAdjacentNode(B, 3);
        B.addAdjacentNode(A, 3);
        listE.add(new Edge(A, B, 3));
        listEContrast.add(new Edge(B, A, 3));

        A.addAdjacentNode(E, 5);
        E.addAdjacentNode(A, 5);
        listE.add(new Edge(A, E, 5));
        listEContrast.add(new Edge(E, A, 5));

        B.addAdjacentNode(C, 10);
        C.addAdjacentNode(B, 10);
        listE.add(new Edge(B, C, 10));
        listEContrast.add(new Edge(C, B, 10));

        E.addAdjacentNode(C, 1);
        C.addAdjacentNode(E, 1);
        listE.add(new Edge(E, C, 1));
        listEContrast.add(new Edge(C, E, 1));

        E.addAdjacentNode(D, 6);
        D.addAdjacentNode(E, 6);
        listE.add(new Edge(E, D, 6));
        listEContrast.add(new Edge(D, E, 6));

        listV.add(A);
        listV.add(B);
        listV.add(C);
        listV.add(D);
        listV.add(E);
    }

    public static HashMap getM1() {
        return m1;
    }

    public static void setM1(HashMap m1) {
        Graph.m1 = m1;
    }

    public List<Edge> getListE() {
        return listE;
    }

    public void setListE(ArrayList<Edge> listE) {
        this.listE = listE;
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
                    Object e1 = graph.insertEdge(parent, null, entry.getValue(), m.get(v), m.get(entry.getKey()));
                    for (Edge e : listE) {
                        if (e.getSource() == v && e.getDestiny() == entry.getKey()) {
                            m1.put(e, e1);
                            break;
                        }
                    }
//                    for (Edge e : listEContrast) {
//                        if (e.getSource() == v && e.getDestiny() == entry.getKey()) {
//                            m1Contrash.put(e, e1);
//                        }
//                    }
                }
            }
            System.out.println(m1Contrash.size());

        } finally {
            graph.getModel().endUpdate();
        }

    }

    public List<Edge> getListEContrast() {
        return listEContrast;
    }

    public void setListEContrast(List<Edge> listEContrast) {
        this.listEContrast = listEContrast;
    }

    public static HashMap getM1Contrash() {
        return m1Contrash;
    }

    public static void setM1Contrash(HashMap m1Contrash) {
        Graph.m1Contrash = m1Contrash;
    }
    
    
}
