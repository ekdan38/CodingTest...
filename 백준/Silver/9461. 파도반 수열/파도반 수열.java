import java.io.*;
import java.util.*;

/**
 * 9461 파도반 수열
 *
 * 입력:
 *      1. 첫째 줄 테스트 케이스 수 T (1 ~ 1,000)
 *      2. T 만큼 N (1 ~ 100)
 *
 *문제 분석:
 *      1. P(N)을 구해야 한다. 점화식 찾아보자.
 *      1 1 1 2 2 3 4 5 7 9 12 16~
 *      P(N) = P(N - 2) + P(N - 3)
 *      ex) 7 + 9 = 16
 *
 * 출력:
 *      1. 각 테스트 케이스의 P(N) 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index 1번 부터 사용, 100까지 만들어야 하기 때문에 long
        // => 출력 해보니 int 범위 벗어남
        long arr[] = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        // 100 까지 만들어야 한다.
        for(int i = 4; i < 101; i++){
            arr[i] = arr[i -2] + arr[i - 3];
        }
        
        int T = Integer.parseInt(br.readLine());
        // P(N) 받으면서 바로 출력 
        for(int i = 0; i < T; i++){
            bw.write(arr[Integer.parseInt(br.readLine())] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}