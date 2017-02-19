package com.graph.structure;

/**
 * Created by hunter on 19-Feb-17.
 */
public class Edge {
    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    int dest;
    int weight;

    public Edge(int v ,int w) {
        this.dest = v;
        this.weight = w;
    }
}
