import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // 기존에 작성된 HashMap을 가지고 다른 HashMap 생성 가능
        HashMap<String, Integer> map2 = new HashMap<String, Integer>(map);

        // 초기에 일정 크기 지정 가능
        HashMap<String, Integer> map3 = new HashMap<String, Integer>(10);

        // CREATE
        map.put("1", 1);
        System.out.println(map.get("1"));

        // UPDATE
        map.put("1", 2);
        System.out.println(map.get("1"));

        // DELETE
        map.remove("1");
        System.out.println(map.get("1"));

        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));

        System.out.println(graph);
        
    }
}