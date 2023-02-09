/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.dijiktra;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class BFS extends Thread {

    public BFS() {
        start();
    }
    
    @Override
    public void run() {
        implementBFS(Main.g.getListV().get(0));
    }

    public void implementBFS(Vertex s) {
        Queue<Vertex> q = new ArrayDeque<>();
        showVertex(s, "grey", 1200);

        q.add(s);
        while (!q.isEmpty()) {
            Vertex u = q.poll();
            if (!u.isVisited()) {
                u.setVisited(true);
                for (Map.Entry<Vertex, Integer> entry : u.getAdjacentNode().entrySet()) {
                    q.add(entry.getKey());
                }
                showVertex(u, "grey", 1200);
            }
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
