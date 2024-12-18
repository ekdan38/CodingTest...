import java.io.*;
import java.util.*;

/**
 * 18222 튜에-모스 문자열
 *
 * 입력:
 *      1. 첫째 줄 k (1 ~ 10^18)
 *
 * 문제 분석:
 *      1. 문자열 x 은 0으로 시작
 *      2. 다음과 같은 과정을 반복한다.
 *      => 1, 0 을 각각 0, 1 로 바꾸고 x' 라고 한다.
 *      => 이후 x + x'
 *      이 과정을 반복하는데 k번째에 오는 문자 출력
 *
 * 출력
 *      1. k 번째 위치에 오는 문자 출력
 * */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long k = Long.parseLong(br.readLine());
        long cnt = 0;
        
        while (k > 0) {
            long cur = 1;
            while (cur * 2 < k) {
                cur <<= 1;
            }
            k -= cur;
            cnt++;
        }
        long ans = ~cnt & 1;

        bw.write(Long.toString(ans));
        bw.flush();
        br.close();
        bw.close();
    }


}