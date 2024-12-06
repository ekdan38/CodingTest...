import java.io.*;
import java.util.*;

/**
 * 9461 파도반 수열
 *
 * 입력:
 *
 *문제 분석:
 *
 * 출력:
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정삼각형이 나선 모양, 변의 길이는 1로 시작
        // P(N) 출력
        // 1 1 1 2 2 3 4 5 7 9
        // 점화식 : DP(N) = DP(N - 5) + DP(N - 1)
        // N은 1 ~ 100이다 => 배열 미리 만들어두자.
        int T = Integer.parseInt(br.readLine());
        // index 1부터 사용
        long [] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for(int i = 6; i <= 100; i++){
            dp[i] = dp[i - 5] + dp[i - 1];
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            result.append(dp[N]).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}