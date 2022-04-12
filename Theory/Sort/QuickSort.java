import java.util.Arrays;
import java.util.ArrayList;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(sort(new ArrayList<Integer>(Arrays.asList(10, 2, 6, 20, 1, 4, 13))));
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        int pivot = dataList.get(0);

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        for (int index = 1; index < dataList.size(); index++) {
            if (dataList.get(index) > pivot) {
                rightArr.add(dataList.get(index));
            } else {
                leftArr.add(dataList.get(index));
            }
        }

        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        mergedList.addAll(sort(leftArr));
        mergedList.addAll(new ArrayList<Integer>(Arrays.asList(pivot)));
        mergedList.addAll(sort(rightArr));

        return mergedList;
    }
}
