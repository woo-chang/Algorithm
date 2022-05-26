package improve;

class Edge implements Comparable<Edge> {
    public String node;
    public int weight;

    public Edge(String node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.node + ")";
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
