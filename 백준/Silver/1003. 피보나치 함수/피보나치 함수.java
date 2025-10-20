import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[41];

        dp[1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        while(T --> 0){
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                bw.write("1 0\n");
            }
            else bw.write(dp[N - 1] + " " + dp[N] + "\n");
        }
        bw.flush();

    }
}