import java.util.Comparator;
import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
        // 앞은 무게, 뒤는 가치
        Integer[][] objectList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};

        knapsackFunc(objectList, 30);
    }

    public static void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] objectItem1, Integer[] objectItem2) {
                return (objectItem2[1]/objectItem2[0]) - (objectItem1[1]/objectItem1[0]);
            }
        });

        for (int index = 0; index < objectList.length; index++) {
            if (capacity - (double)objectList[index][0] > 0) {
                capacity -= (double)objectList[index][0];
                totalValue += (double)objectList[index][1];
            } else {
                fraction = capacity/(double)objectList[index][0];
                totalValue += (double)objectList[index][1] * fraction;
                break;
            }
        }

        System.out.println("총 담을 수 있는 가치: " + totalValue);
    }
}