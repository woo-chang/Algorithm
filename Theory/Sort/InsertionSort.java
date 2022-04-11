import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    
    public static void main(String[] args) {
        ArrayList<Integer> testArray = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            testArray.add((int)(Math.random()*100));
        }

        sort(testArray);
        System.out.println(testArray);
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index++) {
            for (int index2 = index + 1; index2 > 0; index2--) {
                if (dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }
}
