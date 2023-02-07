/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.*;
import com.mxgraph.model.*;
import com.mxgraph.view.mxLayoutManager;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ClickHandler extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -2764911804288120883L;

    public ClickHandler() {
        super("Hello, World!");

        final mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            Object v1 = graph.insertVertex(parent, null, "Hello", 0, 0, 80,
                    30, "fillColor=red");
            Object v2 = graph.insertVertex(parent, null, "World!",
                    0, 0, 80, 30);
            graph.insertEdge(parent, null, "Edge", v1, v2);

        } finally {
            graph.getModel().endUpdate();
        }

        final mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);

        graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {
                Object cell = graphComponent.getCellAt(e.getX(), e.getY());
                if (cell != null) {
                    System.out.println(graph.getModel().getValue(cell));
                    graph.getModel().setStyle(cell, "fillColor=green");
                }
            }
        });
    }

    public static void main(String[] args) {
        ClickHandler frame = new ClickHandler();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }

}
