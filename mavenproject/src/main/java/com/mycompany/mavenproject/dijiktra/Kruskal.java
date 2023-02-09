/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.dijiktra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Kruskal extends Thread {

    public Kruskal() {
        start();
    }

    @Override
    public void run() {
        implementKruskal();
    }

    public void implementKruskal() {
        List<Edge> l = new ArrayList<>();
        for (Vertex v : Main.g.getListV()) {
            v.setParent(v);
            v.setSize(1);
        }
        Collections.sort(Main.g.getListE(), new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        
//        Collections.sort(Main.g.getListEContrast(), new Comparator<Edge>() {
//            @Override
//            public int compare(Edge o1, Edge o2) {
//                return o1.getWeight() - o2.getWeight();
//            }
//        });
        
        for (Edge v : Main.g.getListE()) {
            if (checkCircle(v.getSource(), v.getDestiny())) {
                Object e = Main.g.getM1().get(v);
                Main.g.getGraph().getModel().setStyle(e, "strokeColor=red");
                System.out.println(e);
            }
        }
        
//        for (Edge v : Main.g.getListEContrast()) {
//            if (checkCircle(v.getSource(), v.getDestiny())) {
//                Object e = Main.g.getM1Contrash().get(v);
//                Main.g.getGraph().getModel().setStyle(e, "strokeColor=red");
//                System.out.println(e);
//            }
//        }
    
    }

    public boolean checkCircle(Vertex a, Vertex b) {
        if (findParent(a) == findParent(b)) {
            return false;
        }
        if (a.getSize() < b.getSize()) {
            Vertex tmp = a;
            a = b;
            b = tmp;
        }

        b.setParent(a);
        a.setSize(a.getSize() + b.getSize());
        return true;
    }

    public Vertex findParent(Vertex v) {
        if (v.getParent() == v) {
            return v;
        } else {
            return findParent(v.getParent());
        }
    }

    public void showVertex(Vertex v, String color, int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        Main.g.getGraph().getModel().setStyle(Main.g.getM().get(v), "fillColor=" + color);
    }

}
