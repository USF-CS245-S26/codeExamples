package graphs.adjacencylist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private Edge[] graph; // adjacency list for this graph

    // Static nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor (id of the destination node)
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Return the number of vertices in the graph
     * @return number of vertices
     */
    public int getNumVertices() {
        return graph.length;
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        graph[vertexId] = edge; // insert in front
        if (head != null) {
            edge.next = head;
        }
    }

    /**
     * Print nodes that have no outgoing edges
     */
    public void printNodesWithoutOutgoingEdges() {
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == null) {
                System.out.println(i);
            }
        }
    }

    /**
     * Print all the vertices we can directly reach from a given vertex
     * by following outgoing edges
     * @param vertexId vertex
     */
    public void printNeighbors(int vertexId) {
        Edge curr = graph[vertexId]; // linked list of outgoing edges for this vertex
        while (curr != null) {
            System.out.println(curr.neighbor);
            curr = curr.next;
        }
    }


    /**
     * Print incoming edges - edges that point to a vertex.
     * Ex: Suppose the vertex is 0, and there is an edge.
     * @param vertexId vertex
     */
    public void printIncomingEdges(int vertexId) {
        // Print incoming edges
        // An incoming edge is an edge that comes from some other vertex to vertexId
        for (int i = 0; i < graph.length; i++) {
            if (i == vertexId) {
                continue;
            }
            Edge curr = graph[i];
            while (curr != null) {
                if (curr.neighbor == vertexId) {
                    System.out.println("Found incoming edge for " + vertexId + " It goes from " + i + " to " + vertexId);
                }
                curr = curr.next;
            }
        }
    }

    /** A helper method for dfsMain - runs DFS once from the given source vertex
     *
     * @param vertex source vertex
     * @param visited an array, where for each vertex id we store true if it has been visited,
     * and false otherwise
     */
    void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);
        // Iterate over outgoing edges of this vertex
        // For each edge, get the neighbor, and if it has not been visited, call dfs recursively on the neighbor
        // FILL IN CODE:
        Edge currEdge = graph[vertex];
        while (currEdge != null) {
            if (!visited[currEdge.neighbor])
                dfs(currEdge.neighbor, visited);
            currEdge = currEdge.next;
        }



    }

    /**
     * Iterative DFS implementation that uses a stack.
     * @param vertex source vertex
     * @param visited array that stores true for each vertex id that has been visited
     */
    void dfsWithStack(int vertex, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex); // push the source vertex onto the stack
        while (!stack.isEmpty()) {
            // pop the vertex nextV from the stack, mark it as visited,
            int nextV = stack.pop();
            visited[nextV] = true;
            System.out.println(nextV);
            // iterate over the neighbors of nextV,
            Edge currEdge = graph[nextV];
            while (currEdge != null) {
                // if the neighbor has not been visited, push it onto the stack
                if (!visited[currEdge.neighbor]) {
                    stack.push(currEdge.neighbor);
                }
                currEdge = currEdge.next;
            }
        }
    }


    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     */
    public void dfsMain() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfs(i, visited);  // Could instead call dfsWithStack
               //  dfsWithStack(i, visited);
        }
    }

    /**
     * Run BFS from a given vertex
     * @param vertex source vertex
     * @param visited boolean array that for each vertex id stores true if it has been visited
     */
    void bfs(int vertex, boolean visited[]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;
        System.out.println(vertex);
        while (!queue.isEmpty()) {
            // Dequeue
            int nextV = queue.remove();
            // Go over the neighbors. Add unvisited neighbors to the queue and mark as visited.
            Edge currEdge = graph[nextV];
            while (currEdge != null) {
                if (!visited[currEdge.neighbor]) {
                    queue.add(currEdge.neighbor);
                    visited[currEdge.neighbor] = true;
                    System.out.println(currEdge.neighbor);
                }
                currEdge = currEdge.next;
            }

        } // while queue is not empty
    }


    /** Runs BFS starting from every vertex that has not been visited.
     *
     */
    public void bfsMain() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                bfs(i, visited);
        }
    }

}


