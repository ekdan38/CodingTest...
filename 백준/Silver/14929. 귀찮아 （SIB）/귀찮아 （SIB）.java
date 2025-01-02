import java.io.*;
import java.util.StringTokenizer;

/**
 * 14929 귀찮아(SIB)
 *
 * 입력:
 *      1. n과 xi가 주어짇나. n은 10만 이하ㅇ고, xi는 젗ㄹ댓값이 100이하인 정수디이다.
 *
 * 문제 분석:
 *      1. N = 3, 1, -2, 3이 주어진다...
 *      1(-2 + 3) + -2(3) = 1 + -6 = -5
 *      => 매번 이렇게 구하면 시간 초과 난다.
 *      배열 하나 만들어서 각 구간 누적합 갖고 있다가 추출해보자
 * 출력:
 *      1.
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] sumArr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            sumArr[i + 1] = sum;
        }

        long result = 0;
        for(int i = 0; i < N; i++){
            result += arr[i] * (sumArr[N] - sumArr[i + 1]);
        }

        bw.write(Long.toString(result));
        bw.flush();
        br.close();
        bw.close();
    }

}