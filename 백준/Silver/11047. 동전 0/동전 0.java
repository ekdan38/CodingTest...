import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 동전 저장
        int[] coins = new int[N];
        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i = coins.length - 1; i >= 0; i--){
            if(K / coins[i] > 0){
                cnt += K / coins[i];
                K %= coins[i];
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
