package graphs.kruskals;

public class Main {
    static void main() {
        // Graph for Kruskal's
        Graph g = new Graph(4);
        g.addUndirectedEdge(0, 1, 4);
        g.addUndirectedEdge(0, 2, 3);
        g.addUndirectedEdge(1, 2, 2);
        g.addUndirectedEdge(1, 3, 5);
        g.addUndirectedEdge(2, 3, 7);

        System.out.println(g.kruskalMST());

    }
}
