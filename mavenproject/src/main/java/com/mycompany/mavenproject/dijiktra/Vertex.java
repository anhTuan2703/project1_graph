package com.mycompany.mavenproject.dijiktra;

import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class Vertex {

    private String name;
    private Map<Vertex, Integer> adjacentNode = new HashMap<>();
    private int positionX;
    private int positionY;
    private boolean visited = false; 
    
    // use for prim algorithm
    private int value = Integer.MAX_VALUE;
    
    // use for kruskal algorithm
    private Vertex parent;
    private int size;

    public Vertex(String name) {
        this.name = name;
    }
    
    public Vertex(String name, int positionX, int positionY) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Vertex, Integer> getAdjacentNode() {
        return adjacentNode;
    }

    public void setAdjacentNode(Map<Vertex, Integer> adjacentNode) {
        this.adjacentNode = adjacentNode;
    }
    
    public void addAdjacentNode(Vertex node, int weight) {
        adjacentNode.put(node, weight);
    }

}
