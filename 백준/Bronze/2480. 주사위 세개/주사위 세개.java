import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
        // 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
        // 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int price = 0;

        if(A == B && B ==C){
            price = 10000 + A * 1000;
        }

        else if(A == B){
            price = 1000 + A * 100;
        }

        else if(A == C){
            price = 1000 + A * 100;
        }

        else if(C == B){
            price = 1000 + B * 100;
        }

        else{
            int max = Math.max(A, B);
            max = Math.max(max, C);
            price = max * 100;
        }


        bw.write(String.valueOf(price));
        bw.flush();
        bw.close();
    }
}
