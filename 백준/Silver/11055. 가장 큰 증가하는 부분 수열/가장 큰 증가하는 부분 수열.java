import java.io.*;
import java.util.*;

/**
 * 11055 가장 큰 증가하는 부분 수열
 *
 * 입력:
 *      1. 첫째 줄 수열 A의 크기 N (1 ~ 1,000)
 *      2. 둘째 줄 부터 수열 A을 이루고 잇는 Ai (1 ~ 1,000)
 *
 *문제 분석:
 *      1. 합이 가장 큰 길이가 증가하는 부분 수열을 찾아야한다.
 *      2. 앞에 있는 요소가 더 작으면 증가하는 부분 수열
 *      => dp 배열 만들어주고 조건 만족하면 값 더해주자
 *
 * 출력:
 *      1. 가장 긴 증가하는 부분 수열 합 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i  = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 증가하는 수열 길이
        int max = 1;
        int []dp = arr.clone();
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < i; j++){
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], arr[i] + dp[j]);
            }
        if(max < dp[i])max = dp[i];
        }


        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();
    }
}