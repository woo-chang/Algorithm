import java.util.*;

class Solution
{       
    public int solution(int[] A, int[] B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        // 시간복잡도 효율성 실패
        // B = Arrays.stream(B)
        //     .boxed()
        //     .sorted(Collections.reverseOrder())
        //     .mapToInt(Integer::intValue)
        //     .toArray();
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length-i-1];   
        }
        return answer;
    }
    
    // 작은 수 끼리 곱한다고 최소의 값이 나오지 않는다.
    // 모든 경우의 수 -> 시간 초과
    // 처음 한번 구한 다음에 그 값을 넘어가면 멈추는 방법
    // dfs -> 시간 초과
    // 최소랑 최대를 곱한다?
}