import java.util.ArrayList;
import java.util.Arrays;

public class BFSExample {
    public static void main(String[] args) {
        ArrayList<String> testList = new ArrayList<String>();
        ArrayList<String> nodeList = new ArrayList<String>(Arrays.asList("B", "C"));

        testList.add("A");

        // 값 꺼내기
        System.out.println(testList.remove(0));

        // 값 존재하는지 확인
        System.out.println(nodeList.contains("B"));

        // 값 한번에 넣기
        System.out.println(testList.addAll(nodeList));
    }
}
