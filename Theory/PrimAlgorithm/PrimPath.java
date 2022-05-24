import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {

    public static void main(String[] args) {
        ArrayList<Edge> myEdges = new ArrayList<Edge>();
        myEdges.add(new Edge(7, "A", "B"));
        myEdges.add(new Edge(5, "A", "D"));
        myEdges.add(new Edge(8, "B", "C"));
        myEdges.add(new Edge(9, "B", "D"));
        myEdges.add(new Edge(7, "D", "E"));
        myEdges.add(new Edge(5, "C", "E"));
        myEdges.add(new Edge(7, "B", "E"));
        myEdges.add(new Edge(6, "D", "F"));
        myEdges.add(new Edge(9, "E", "G"));
        myEdges.add(new Edge(11, "F", "G"));

        System.out.println(primFunc("A", myEdges));
    }

    public static ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
        Edge currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgesNodes;
        PriorityQueue<Edge> priorityQueue;
        // 연결된 노드 집합
        ArrayList<String> connectedNodes = new ArrayList<String>();
        ArrayList<Edge> mst = new ArrayList<Edge>();
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>();

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
            }
        }

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode);
        // 연결된 것이 없으면 빈 리스트 반환
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
        priorityQueue = new PriorityQueue<Edge>();
        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        while (priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                // 해당 edge를 mst에 추가
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdgesNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
                for (int index = 0; index < adjacentEdgesNodes.size(); index++) {
                    adjacentEdgeNode = adjacentEdgesNodes.get(index);
                    if (!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;
    }
    
}
