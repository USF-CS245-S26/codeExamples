package graphs.kruskals;

import disjointsets.DisjointSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
    private WeightedEdge[] graph; // adjacency list

    // Edge node stored inside each linked list
     private static class WeightedEdge implements Comparable<WeightedEdge> {
        private int source; // origin vertex
        private int neighbor; // destination vertex
        private int weight;
        private WeightedEdge next;

        public WeightedEdge(int source, int neighbor, int weight) {
            this.source = source;
            this.neighbor = neighbor;
            this.weight = weight;
            this.next = null;
        }

        @Override
        public int compareTo(WeightedEdge other) {
            return this.weight - other.weight;
        }

        @Override
        public String toString() {
            return "(" + source + ", " + neighbor + ", " + weight + ")";
        }
    }

    public Graph(int numVertices) {
        graph = new WeightedEdge[numVertices];
    }

    /**
     * Adds one directed edge node to the adjacency list of vertexId.
     */
    public void addEdge(int vertexId, WeightedEdge edge) {
        WeightedEdge head = graph[vertexId];
        graph[vertexId] = edge;
        if (head != null) {
            edge.next = head;
        }
    }

    /**
     * Adds an undirected weighted edge.
     */
    public void addUndirectedEdge(int v1, int v2, int weight) {
        addEdge(v1, new WeightedEdge(v1, v2, weight));
        addEdge(v2, new WeightedEdge(v2, v1, weight));
    }

    /**
     * Runs Kruskal's algorithm and returns the edges of the MST.
     */
    public List<WeightedEdge> kruskalMST() {
        List<WeightedEdge> allEdges = new ArrayList<>();
        List<WeightedEdge> mst = new ArrayList<>();

        // Collect all edges in the list (convert each Edge to WeightedEdge)
        for (int i = 0; i < graph.length; i++) {
            WeightedEdge curr = graph[i];
            while (curr != null) {
                if (i < curr.neighbor) {
                    allEdges.add(new WeightedEdge(i, curr.neighbor, curr.weight));
                }
                curr = curr.next;
            }
        }

        // Sort edges:
        Collections.sort(allEdges);

        DisjointSets ds = new DisjointSets();
        ds.createSets(graph.length);
        // Use DisjointSets to run Kruskal's and compute the MST
        for (WeightedEdge edge: allEdges) {
            int rootx = ds.find(edge.source);
            int rooty = ds.find(edge.neighbor);
            if (rootx != rooty) {
                mst.add(edge);
                ds.union(rootx, rooty);
            }
        }

        return mst;
    }

}