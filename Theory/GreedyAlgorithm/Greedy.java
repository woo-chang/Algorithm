import java.util.ArrayList;
import java.util.Arrays;

public class Greedy {

    public static void main(String[] args) {
        ArrayList<Integer> coinList = new ArrayList<Integer>(Arrays.asList(500, 100, 50, 1));
        coinFunc(4720, coinList);
    }

    public static void coinFunc(Integer price, ArrayList<Integer> coinList) {
        // 전체 동전 개수
        Integer totalCoinCount = 0;
        // 각각의 동전 개수
        Integer coinNum = 0;

        ArrayList<Integer> details = new ArrayList<Integer>();

        // 큰 동전부터 채워져 있다고 가정
        for (int index = 0; index < coinList.size(); index++) {
            coinNum = price / coinList.get(index);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(index);
            details.add(coinNum);
            System.out.println(coinList.get(index) + "원:" + coinNum + "개");
        }

        System.out.println("총 동전 갯수:" + totalCoinCount);

    }
    
}
