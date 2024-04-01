package core;

import java.util.HashSet;

public class Node {
    public int id;
    public HashSet<Integer> neighbors;
    public HashSet<Integer> connections;

    public Node(int id, HashSet<Integer> neighbors) {
        this.id = id;
        this.neighbors = neighbors;
        this.connections = new HashSet<>();
    }

    public void connect(Node other) {
        assert neighbors.contains(other.id) : "Cannot connect nodes that are not neighbors";
        assert other.neighbors.contains(id) : "Cannot connect nodes that are not neighbors";

        connections.add(other.id);
        other.connections.add(id);
    }

    public void disconnect(Node other) {
        assert neighbors.contains(other.id) : "Cannot connect nodes that are not neighbors";
        assert other.neighbors.contains(id) : "Cannot connect nodes that are not neighbors";

        connections.remove(other.id);
        other.connections.remove(id);
    }
}
