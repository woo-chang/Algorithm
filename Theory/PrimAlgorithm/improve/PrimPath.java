package improve;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimPath {

    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<String, HashMap<String, Integer>>();

        HashMap<String, Integer> edges;
        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("D", 5);
        mygraph.put("A", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        mygraph.put("B", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 8);
        edges.put("E", 5);
        mygraph.put("C", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        mygraph.put("D", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        mygraph.put("E", edges);

        edges = new HashMap<String, Integer>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        mygraph.put("F", edges);

        edges = new HashMap<String, Integer>();
        edges.put("E", 9);
        edges.put("F", 11);
        mygraph.put("G", edges);

        System.out.println(improvedPrimFunc(mygraph, "A"));
    }

    public static ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode)        {
        ArrayList<Path> mst = new ArrayList<Path>();
        PriorityQueue<Edge> keys = new PriorityQueue<Edge>();
        HashMap<String, Edge> keysObjects = new HashMap<String, Edge>();
        HashMap<String, String> mstPath = new HashMap<String, String>();
        HashMap<String, Integer> linkedEdges;
        Integer totalWeight = 0;
        Edge edgeObject, poppedEdge, linkedEdge;

        // 중간에 업데이트가 발생하기에 삭제했다가 다시 넣는 방식 사용
        for (String key : graph.keySet()) {
            if (key == startNode) {
                edgeObject = new Edge(key, 0);
                mstPath.put(key, key);
            } else {
                edgeObject = new Edge(key, Integer.MAX_VALUE);
                mstPath.put(key, null);
            }

            keys.add(edgeObject);
            keysObjects.put(key, edgeObject);
        }

        // 전체 노드의 수만큼 반복
        while (keys.size() > 0) {
            poppedEdge = keys.poll();
            keysObjects.remove(poppedEdge.node);

            mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
            totalWeight += poppedEdge.weight;

            // 인접 간선 정보
            linkedEdges = graph.get(poppedEdge.node);
            for (String adjacent : linkedEdges.keySet()) {
                // 아직 체크가 되지 않은 것들
                if (keysObjects.containsKey(adjacent)) {
                    linkedEdge = keysObjects.get(adjacent);

                    if (linkedEdges.get(adjacent) < linkedEdge.weight) {
                        linkedEdge.weight = linkedEdges.get(adjacent);
                        mstPath.put(adjacent, poppedEdge.node);

                        // 업데이트 적용 후 최소 힙이 유지
                        keys.remove(linkedEdge);
                        keys.add(linkedEdge);
                    }
                }
            }
        }
        System.out.println(totalWeight);
        return mst;
    }
}
