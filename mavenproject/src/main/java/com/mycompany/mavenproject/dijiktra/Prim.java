/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.dijiktra;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Prim extends Thread {

    public Prim() {
        start();
    }

    @Override
    public void run() {
        implementPrim(Main.g.getListV(), Main.g.getListV().get(0));
    }

    public void implementPrim(ArrayList<Vertex> l, Vertex source) {
        source.setValue(0);

        for (int i = 0; i < l.size(); i++) {
            String min_value = findMin(l);
            Vertex curr = null;
            for (Vertex ele : l) {
                if (ele.getName() == min_value) {
                    curr = ele;
                    break;
                }
            }

            curr.setVisited(true);
            showVertex(curr, "grey", 1200);

            for (Map.Entry<Vertex, Integer> entry : curr.getAdjacentNode().entrySet()) {
                if (entry.getValue() < entry.getKey().getValue() && entry.getKey().isVisited() == false) {
                    entry.getKey().setValue(entry.getValue());
                }
            }
        }
    }

    public static String findMin(ArrayList<Vertex> l) {
        int min_value = Integer.MAX_VALUE;
        String min_index = "";

        for (Vertex ele : l) {
            if (ele.isVisited() == false && ele.getValue() < min_value) {
                min_value = ele.getValue();
                min_index = ele.getName();
            }
        }

        return min_index;
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
