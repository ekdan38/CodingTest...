import java.io.*;
import java.util.*;

/**
 * 1965 상자 넣기
 *
 * 입력:
 *      1. 첫째 줄 상자의 개수 N (1 ~ 1,000)
 *      2. 각 상자의 크기가 순서대로 주어진다. (1 ~ 1,000)
 *
 *문제 분석:
 *      1. (1, 5, 2, 3, 7)이 있으면 {1,2,3} 처럼 증가하는 순열은 7까지 증가하는 순열을 만족하기에 7에 담을 수 있다.
 *      이렇게 한번에 넣을 수 있는 최대의 상자 개수를 구해야한다.
 *      => 증가하는 최장 길이 순열을 찾고 길이를 출력하면 된다.
 *
 * 출력:
 *      1. 증가하는 최장 길이 순열 길이 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int [] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            if(max < dp[i])max = dp[i];
        }

        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();
    }
}