import java.io.*;
import java.util.*;
/**
 * 2417 정수 제곱근
 *
 * 입력:
 *      1. 첫째 줄에 정수 n이 주어진다. (0 ≤ n < 2^63)
 *
 * 문제 분석:
 *      1. 정수 n의 제곱근 출력
 *      => 이진 탐색 활용
 *
 * 출력:
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        long start = 0;
        long end = N;
        long answer = 0;

        while (start <= end) {
            long mid = (end + start) / 2;
            if (Math.pow(mid, 2) >= N) {
                answer = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }

        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }


}
