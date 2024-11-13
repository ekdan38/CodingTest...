import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         *  2018 수들의 합 5
         *  자연수 N의 범위 = (1 ≤ N ≤ 10,000,000) 범위가 크기때문에 O(n)의 시간 복잡도로 풀어야 한다.
         *  그러기 위해서 투포인터 사용
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 1;

        // N도 포함해야 하기 때문에 1
        int cnt = 1;

        // 투포인터 변수
        int startIdx = 1;
        int endIdx = 1;

        while(endIdx != N){
            if(sum == N){
                cnt++;
                endIdx++;
                sum += endIdx;
            }
            else if (sum > N) {
                sum -= startIdx;
                startIdx++;
            }
            else{
                endIdx++;
                sum += endIdx;
            }
        }
        System.out.println(cnt);


    }
}
