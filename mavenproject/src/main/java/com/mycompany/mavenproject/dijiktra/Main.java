/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.dijiktra;

/**
 *
 * @author Admin
 */
public class Main {

    public static Graph g = new Graph();
    private BFS bfs;
    private Prim prim;
    private Kruskal kruskal;

    public Main() {
        g.setVisible(true);
//        bfs = new BFS();
//        prim = new Prim();
        kruskal = new Kruskal();

    }

    public static void main(String[] args) {
        Main m = new Main();
    }

    public void Dijiktra(String source, String destiny) {

    }

}
