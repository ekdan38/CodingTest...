import java.io.*;
import java.util.*;

/**
 * 1789 수들의 합
 *
 * 입력:
 *      1. 첫째 줄에 자연수 S(1 ~ 4,294,967,295)
 *
 *문제 분석:
 *      1. 서로 다른 N개의 자연수의 합이 S라고 한다. 자연수 N의 최댓값은 얼마일지
 *      => N개의 합이 S이다.. => 일단 더해보자
 *  출력:
 *      1. N 최대값 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long num = 1;
        while(sum <= S){
            sum += num++;
        }

        bw.write(Long.toString(num - 2));
        bw.flush();
        br.close();
        bw.close();
    }

}