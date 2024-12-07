import java.io.*;
import java.util.*;

/**
 * 31926 밤양갱
 *
 * 입력:
 *      1. 첫째 줄에 머리속에 떠오른 daldidalgo 의 횟수 N (1 ~ 1,000,000,000)
 *      => N = 3이면 daldidalgo, daldidalgo, daldidalgo, daldidan
 *
 *문제 분석: 두가지 작업 가능
 *      1. a ~ z 중에서 하나 골라서 지금까지 입력한 내용의 맨뒤에 추가
 *      2. 지금까지 입력된 문자열 중 연속된 부분 문자열을 복사해서 입력한 내용의 맨뒤에 추가
 *      =>
 *      N = 1 = 10, // 2^0 = 1
 *      N = 2 = 11,
 *      N = 3 = 11, // 2^1 =2
 *      N = 4 = 12,
 *      N = 5 = 12,
 *      N = 6 = 12,
 *      N = 7 = 12, // 2^2 = 4
 *      N = 8 = 13,
 *      ~
 *      N = 15 = 13 // 2^3 = 8
 *      => 2의 거듭 제곱에 대해 구간을 갖는 규칙이 생김
 *      => N = 3 은 2^1 < 3 < 2^2 이다 그러면 2^1 구간의 값을 갖게 된다..
 *      => 2의 어느 제곱 구간에 속 하나를 알면 된다.
 *      => 2로 나눠지는 값을 구하자
 * 출력:
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 모든 값에 10을 더해줘야 한다.
        int cnt = 10;
        // 2로 나눠질때 까지 반복 => 2의 거듭제곱에 속해야함
        while(N > 1){
            N /= 2;
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}
