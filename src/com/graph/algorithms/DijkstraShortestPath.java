package com.graph.algorithms;

import com.graph.structure.Edge;
import com.graph.structure.Graph;

import java.util.*;

/**
 * Created by hunter on 19-Feb-17.
 */
public class DijkstraShortestPath {

    static class DistanceVerticePair{
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DistanceVerticePair that = (DistanceVerticePair) o;

            return vertice == that.vertice;

        }

      /*  @Override
        public int hashCode() {
            return vertice;
        }*/

        int vertice;
        int dist ;

        public DistanceVerticePair(int vertice, int dist) {
            this.vertice = vertice;
            this.dist = dist;
        }
    }

    public static void shortestPath(Graph g , int source) {
        HashMap<Integer, ArrayList<Edge>> map = g.getEdgeVerticesMap();
        //ArrayList<Edge> edgeList = map.get(source);

        PriorityQueue<DistanceVerticePair> queue = new PriorityQueue<DistanceVerticePair>(g.getNoOfVertices(), new Comparator<DistanceVerticePair>() {
            @Override
            public int compare(DistanceVerticePair o1, DistanceVerticePair o2) {
                return o1.dist - o2.dist;
            }
        });

        for (int i = 0 ; i < g.getNoOfVertices() ; i++ ){
            if(i != source)
            queue.offer(new DistanceVerticePair(i,Integer.MAX_VALUE));
        }
        //queue.remove()
        queue.offer(new DistanceVerticePair(source,0));

        int dist[] = new int[g.getNoOfVertices()];
        Arrays.fill(dist ,Integer.MAX_VALUE);
        dist[source] = 0;



        while(!queue.isEmpty()) {
            int v = queue.peek().vertice;
            int d = queue.peek().dist;
            queue.poll();
           // System.out.println(v);
            Iterator itr = g.getEdgeVerticesMap().getOrDefault(v,new ArrayList<Edge>()).iterator();

            while(itr.hasNext()){
                Edge edge = (Edge) itr.next();
                if(d+edge.getWeight() < dist[edge.getDest()]){
                    dist[edge.getDest()] = d+edge.getWeight();
                    DistanceVerticePair dp = new DistanceVerticePair(edge.getDest(),edge.getWeight()+d);
                  if(queue.contains(dp) == true){
                      queue.remove(dp);
                  }
                    queue.offer(dp);
                }
            }

        }

        for (int i = 0 ; i < g.getNoOfVertices() ; i++ ){
            System.out.println(i + " " + dist[i]);
        }
    }

    public  static  void  main(String args[]){
        Graph g = new Graph(9);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        DijkstraShortestPath.shortestPath(g,0);
    }
}
