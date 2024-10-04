import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
        // 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
        // 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i < 10; i++){
            sb.append(N + " * " + i + " = " + N * i + "\n");
        }


        bw.write(String.valueOf(sb.toString()));
        bw.flush();
        bw.close();
    }
}
