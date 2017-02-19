package com.graph.structure;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hunter on 19-Feb-17.
 */
public class Graph {
    int noOfVertices;
    HashMap<Integer , ArrayList<Edge>> edgeVerticesMap;

    public HashMap<Integer, ArrayList<Edge>> getEdgeVerticesMap() {
        return edgeVerticesMap;
    }

    public void setEdgeVerticesMap(HashMap<Integer, ArrayList<Edge>> edgeVerticesMap) {
        this.edgeVerticesMap = edgeVerticesMap;
    }

    public int getNoOfVertices() {
        return noOfVertices;
    }

    public void setNoOfVertices(int noOfVertices) {
        this.noOfVertices = noOfVertices;
    }

    public Graph(int v) {
        this.noOfVertices = v;
        this.edgeVerticesMap = new HashMap<Integer, ArrayList<Edge>>();
    }

    public void addEdge(int u ,int v ,int w) {
        ArrayList<Edge> edgeList = this.getEdgeVerticesMap().getOrDefault(u,new ArrayList<Edge>());
        edgeList.add(new Edge(v,w));
        this.edgeVerticesMap.put(u,edgeList);
        edgeList = this.getEdgeVerticesMap().getOrDefault(v,new ArrayList<Edge>());
        edgeList.add(new Edge(u,w));
        this.edgeVerticesMap.put(v,edgeList);

    }
}
