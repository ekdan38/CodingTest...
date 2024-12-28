import java.io.*;
import java.util.StringTokenizer;

/**
 * 5347 LCM
 *
 * 입력:
 *      1. 첫 번째 줄 테스트 케이스 수
 *      2. 이후 각 테스트 케이스마다 최소공배수 출력
 *
 * 문제 분석:
 *      1. 최대 공약수 찾고 => a x b / 최대 공약수
 *
 * 출력:
 *
 * */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            result.append((long)a * b / gcd(a, b)).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}