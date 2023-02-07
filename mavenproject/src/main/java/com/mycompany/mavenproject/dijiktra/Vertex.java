package com.mycompany.mavenproject.dijiktra;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
    private String color;
    
    // list of target vertexs from this vertex
    // list of source vertexs from this vertex
    // if vertex v has target and source is vertex u, this edge is indirection(to initialize a indirection graph).
//    private ArrayList<Vertex> tarList = new ArrayList<>();
//    private ArrayList<Vertex> sourList = new ArrayList<>();
            

    public Vertex(String name) {
        this.name = name;
    }
    
    public Vertex(String name, int positionX, int positionY) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    public Vertex(String name, int positionX, int positionY, String color){
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.color = color;
    }
    
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
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
    
//    public ArrayList<Vertex> getTarList(){
//        return this.tarList;
//    }
//    
//    public void setTarList(ArrayList<Vertex> tarList){
//        this.tarList = tarList;
//    }
//    public void addTarList(Vertex v){
//        tarList.add(v);
//    }
//    
//    public ArrayList<Vertex> getSourList(){
//        return this.sourList;
//    }
//    
//    public void setSourList(ArrayList<Vertex> sourList){
//        this.sourList = sourList;
//    }
//    public void addSourList(Vertex v){
//        sourList.add(v);
//    }

}
