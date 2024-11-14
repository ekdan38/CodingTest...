import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[1001];    

    public static void main(String[] args) throws IOException {
        /**
         * 2705 팰린드롬 파티션
         * 재귀적인 팰린드롬 파티션의 개수를 찾아야한다.
         * 팰린드롬 파티션이면서, 왼쪽, 오른쪽 파티션이 재귀적으로 팰린드롬 이어야한다.
         * 또한 모든 정수는 두개의 팰린드롬 파티션을 갖는다.
         * (자기 자신, 1로만 이루어진 파티션)
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 1001; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 1000; i++) {
            //짝수인 경우
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] + dp[i / 2];
            } else {
                //홀수인 경우
                dp[i] = dp[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }


}

