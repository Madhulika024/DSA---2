import java.util.*;

class Edge implements Comparable<Edge> {
    char source, destination;
    int cost;

    Edge(char source, char destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

public class BangaloreMetroMST {

    static Map<Character, Character> parent = new HashMap<>();

    static char find(char node) {
        if (parent.get(node) == node)
            return node;

        char root = find(parent.get(node));
        parent.put(node, root);
        return root;
    }

    static void union(char a, char b) {
        parent.put(find(a), find(b));
    }

    public static void main(String[] args) {

        char[] stations = {'M', 'K', 'W', 'S', 'E', 'Y', 'H'};

        for (char station : stations) {
            parent.put(station, station);
        }

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge('E', 'S', 4));
        edges.add(new Edge('K', 'W', 5));
        edges.add(new Edge('S', 'W', 6));
        edges.add(new Edge('M', 'E', 7));
        edges.add(new Edge('M', 'K', 8));
        edges.add(new Edge('Y', 'M', 9));
        edges.add(new Edge('Y', 'H', 9));
        edges.add(new Edge('M', 'S', 10));
        edges.add(new Edge('M', 'H', 11));
        edges.add(new Edge('M', 'W', 12));
        edges.add(new Edge('K', 'H', 14));

        Collections.sort(edges);

        int minimumCost = 0;

        System.out.println("Selected Metro Connections:");

        for (Edge edge : edges) {

            if (find(edge.source) != find(edge.destination)) {

                union(edge.source, edge.destination);

                System.out.println(
                        edge.source + " - " +
                        edge.destination + " : " +
                        edge.cost + " Crores");

                minimumCost += edge.cost;
            }
        }

        System.out.println("\nMinimum Construction Cost = "
                + minimumCost + " Crores");
    }
}