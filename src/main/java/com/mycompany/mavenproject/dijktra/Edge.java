/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject.dijktra;

/**
 *
 * @author vitua
 */
public class Edge {
    private Vertex source;
    private Vertex destiny;
    private int weight;
    private String color;
    private int label;// dung cho do thi vo huong

    public Edge(Vertex source, Vertex destiny, int label) {
        this.source = source;
        this.destiny = destiny;
        this.label = label;
        source.addAdjacentNode(destiny, 1);// them vao danh sach ke khi tao moi 1 canh
    }

    public Edge() {
    }
    
    public Edge(Vertex source, Vertex destiny, int label, String color){
        this.source = source;
        this.destiny = destiny;
        this.label = label;
        this.color = color;
    }

    public Edge(Vertex source, Vertex destiny, int weight, String color, int label) {
        this.source = source;
        this.destiny = destiny;
        this.weight = weight;
        this.color = color;
        this.label = label;
        source.addAdjacentNode(destiny, weight);// khi tao moi 1 canh, them canh do vao danh sach ke
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestiny() {
        return destiny;
    }

    public void setDestiny(Vertex destiny) {
        this.destiny = destiny;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
