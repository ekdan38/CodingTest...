import java.io.*;
import java.util.*;

/**
 * 14916 거스름 돈
 *
 * 입력:
 *      1. 첫째 줄에 거스름 돈 액수 n (1 ~ 100,000)
 *
 *문제 분석:
 *      1. 2원, 5원 으로 돈을 거슬러 줘야한다. 최소의 동전 개수로 거슬러 주자.
 * 출력:
 *      1. 거스름돈 동전의 최소 개수, 거슬러 줄 수 없으면 -1
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if(n > 1){
            int min = 100000;
            for(int i = 0; i <= n / 5; i++){
                // 5원이 0개 일 때
                if(i == 0){
                    // 2원으로만 거슬러 줄 수 있고, 최소 동전 개수보다 작으면
                    // min 업데이트
                    if(n % 2 == 0 && min > n / 2) min = n / 2;
                }
                // 5원이 1개 이상일 때
                else{

                    // 돈 거슬러 줄 수 있으면, 최소 동전 개수보다 작으면
                    if((n - (i * 5)) % 2 == 0 && min > (n - (i * 5)) % 2) min = i + (n - (i * 5)) / 2;
                }
            }
            if(min == 100000)bw.write(String.valueOf(-1));
            else bw.write(String.valueOf(min));
        }
        else bw.write(String.valueOf(-1));

        bw.flush();
        br.close();
        bw.close();
    }
}
