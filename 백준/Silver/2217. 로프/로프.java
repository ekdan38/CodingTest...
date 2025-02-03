
import java.io.*;
import java.util.*;

/**
 * 2217 로프
 *
 * 입력:
 *      1. 첫째 줄에 정수 N이 주어진다.
 *      2. 다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다. 이 값은 10,000을 넘지 않는 자연수이다.
 *
 * 문제 분석:
 *      1. N 개의 로프가 있는데 로프 마다 최대 중량이 다르다.
 *      2. 이 로프를 병렬 연결하면 중량 분산 가능.
 *      3. 로프들 주어지면 들어올릴 수 있느 최대 중량 구하기
 *
 * 출력:
 *
 * */

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[] rope = new int[N];

            for (int i = 0; i < N; i++) {
                rope[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(rope);
            int max = 0;
            
            for (int i = 0; i < N; i++) {
                max = Math.max(max, rope[i] * (N - i));
            }

            bw.write(Integer.toString(max));
            bw.flush();
            br.close();
            bw.close();
        }

    }
