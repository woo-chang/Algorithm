import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)), 5));
    }

    public static int binarySearch(ArrayList<Integer> dataList, int data) {
        if (dataList.size() == 0) {
            return -1;
        }

        if (dataList.size() == 1 && dataList.get(0) == data) {
            return data;
        }

        if (dataList.size() == 1 && dataList.get(0) != data) {
            return -1;
        }

        int mid = dataList.size() / 2;

        if (dataList.get(mid) == data) {
            return data;
        } else if (dataList.get(mid) > data) {
            return binarySearch(new ArrayList<Integer>(dataList.subList(0, mid)), data);
        } else {
            return binarySearch(new ArrayList<Integer>(dataList.subList(mid, dataList.size())), data);
        }
    }
}
