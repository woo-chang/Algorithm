import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println(split(new ArrayList<Integer>(Arrays.asList(10, 1, 6, 2, 13, 100, 20, 18))));
    }

    public static ArrayList<Integer> split(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        int mid = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr = split(new ArrayList<Integer>(dataList.subList(0, mid)));
        rightArr = split(new ArrayList<Integer>(dataList.subList(mid, dataList.size())));

        return merge(leftArr, rightArr);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE1 : left, right 둘다 있을 때
        while (leftArr.size() > leftPoint && rightArr.size() > rightPoint) {
            if (leftArr.get(leftPoint) > rightArr.get(rightPoint)) {
                mergedList.add(rightArr.get(rightPoint));
                ++rightPoint;
            } else {
                mergedList.add(leftArr.get(leftPoint));
                ++leftPoint;
            }
        }

        // CASE2 : right가 없을 때
        while (leftArr.size() > leftPoint) {
            mergedList.add(leftArr.get(leftPoint));
            ++leftPoint;
        }

        // CASE3 : left가 없을 때
        while (rightArr.size() > rightPoint) {
            mergedList.add(rightArr.get(rightPoint));
            ++rightPoint;
        }

        return mergedList;
    }
}
