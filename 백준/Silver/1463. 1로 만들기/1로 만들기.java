
import java.io.*;
import java.util.*;

/**
 * 1463 1로 만들기
 *
 * 입력:
 *      1. 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 * 문제 분석:
 *      1.  X가 3으로 나누어 떨어지면, 3으로 나눈다.
 *          X가 2로 나누어 떨어지면, 2로 나눈다.
 *          1을 뺀다.
 *          => 3개 연산 사용해서 1을 만들어야한다. 최소 횟수 구해라
 *          => 탑 다운, 바텀-업 ..... 재귀 피해보자 바텀-업 사용
 *
 *
 *
 * 출력:
 *      1. 하얀색 종이, 파란색 종이 수
 *
 * */

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int X = Integer.parseInt(br.readLine());
            int []dp = new int[X + 1];
            dp[1] = 0;

            for(int i = 2; i <= X; i++){
                // - 1
                dp[i] = dp[i - 1] + 1; 
                // /3
                if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                // /2
                if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            bw.write(Integer.toString(dp[X]));
            bw.flush();
            br.close();
            bw.close();
        }

    }
