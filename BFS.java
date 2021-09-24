import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    int V;
    int E;
    LinkedList<Integer>[] adj;

    public BFS(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[V];// this is to keep track of the nodes visited as there can be cycles in the
                                           // graph
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS g = new BFS(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        System.out.println(g);
        g.bfs(0);
    }
}
