import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            dataList.add((int)(Math.random()*100));
        }

        sort(dataList);

        System.out.println(dataList);
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size()-1; index++) {
            // 한번이라도 자리가 스왑되었는지 체크하는 변수
            boolean swap = false;

            for (int index2 = 0; index2 < dataList.size()-1-index; index2++) {
                if (dataList.get(index2) > dataList.get(index2+1)) {
                    Collections.swap(dataList, index2, index2+1);
                    swap = true;
                }
            }

            if (swap==false) {
                break;
            }
        }

        return dataList;
    }
}