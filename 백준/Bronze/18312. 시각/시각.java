import java.io.*;
import java.util.*;

/**
 * 18312 시각
 *
 * 입력:
 *      1. 첫째 줄에 정수 N (1 ~ 23)과 K (0 ~ 9)가 공백을 기준으로 주어진다.
 *      2. 이후 N개의 줄에 심사대에서 심사 하는데 걸리는 시간 (1 ~ 1,000,000,000)
 *
 *문제 분석:
 *      1. N 과 K 입력되었을 때 00시 00분 00초 ~ N시 59분 59초 까지 모든 시각 중에서
 *      K가 하나라도 포함되는 시각을 카운팅해라. (디지털 시계 기준, 초 단위로만 구분)
 *      => 24시간 있는 디지털 시계인데 K가 1개라도 있으면 카운팅해라.
 *
 *  출력:
 *      1. 00시 : 00분 : 00초 ~ N시 : 59분 :59초 사이에 k가 얼만큼있냐
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // N = 5, K = 3
        // 00시 : 00분 : 00초 ~ 05시 : 59분 :59초 => 3이 얼마만큼 들어있냐

        // 3중 for문?
        int cnt = 0;
        for(int h = 0; h <= N; h++){
            for(int m = 0; m < 60; m ++){
                for(int s = 0; s < 60; s++){
                    if(isIncludeK(K, h, m, s)) cnt++;
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        br.close();
        bw.close();
    }

    //contains 는 뭔가 문제가 있는듯 싶다 다른 테스트 케이스에서 통과 x
    static boolean isIncludeK(int K, int h, int m, int s){
        return h % 10 == K || m % 10 == K || s % 10 == K || h / 10 == K || m / 10 == K || s / 10 == K;
//        return String.valueOf(h).contains(K) || String.valueOf(m).contains(K) || String.valueOf(s).contains(K);
    }

}