package improve;

class Path {
    public String node1;
    public String node2;
    public int weight;

    public Path(String node1, String node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public String toString() {
        return "(" + this.node1 + ", " + this.node2 + ", " + this.weight + ")";
    }
    
}
