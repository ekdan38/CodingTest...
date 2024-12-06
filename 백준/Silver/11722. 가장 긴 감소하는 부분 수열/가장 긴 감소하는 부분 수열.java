import java.io.*;
import java.util.*;

/**
 * 11722 가장 긴 감소하는 부분 수열
 *
 * 입력: 1. 첫째 줄 수열 A의 크기 N (1 ~ 1,000)
 *      2. 둘째 줄 부터 수열 A을 이루고 잇는 Ai (1 ~ 1,000)
 *
 *문제 분석: 1. 감소하는 가장 긴 수열을 구해야한다.
 *         2. i 인덱스 앞에 있는 수가 i 보다 크면 감소하는 수열이다.
 *         이때 가장 긴 수열을 구해야한다. 각각 인덱스는 1의 감소하는 수열 길이를 갖고 있다.(자기 자신)
 *         그러면 i랑 0번 인덱스부터 비교하면서 찾는다.
 *
 * 출력: 1. 가장 긴 감소하는 부분 수열 길이 출력
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

        // 감소하는 수열 길이
        int []dp = new int[N];
        // 자기 자신만 갖고있을 테니깐 길이 1로 초기화
        Arrays.fill(dp, 1);
        
        int max = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                // 앞 부분이랑 비교하면서 앞부분이 크면 해당 부분의 최대 길이 수열, (i의 길이 + 1) 중에 가장 큰값 가져온다.
                // => 감소하는 가장 긴 수열 길이 구해야 하기 때문
                if(arr[i] < arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if(max < dp[i]) max = dp[i];
        }

        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();
    }


}