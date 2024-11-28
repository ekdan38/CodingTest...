import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 15829 Hashing
         * 문제 분석:
         *          HashFunction을 만드는 문제이다.
         *
         * 의사 결정:
         *          a~z로 이루어진 문자열을 문제에서 제시하는 방식으로 HashFunction을 돌려야된다.
         *          문자열 각 알파벳에 - 96을 해주고 HashFunction을 적용시켜보자.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = 1234567891;
        String str = br.readLine();

        long result = 0;
        long pow = 1;
        for(int i = 0; i < N; i++){
            int c = str.charAt(i) - 'a' + 1;
            result +=  c * pow % M;
            pow = 31 * pow % M;
        }

        result %= M;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}