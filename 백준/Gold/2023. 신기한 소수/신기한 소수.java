import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] primeArr = new int[]{2, 3, 5, 7};
        for(int prime : primeArr){
            dfs(prime, 1);
        }

        bw.write(sb.toString());
        bw.flush();
    }
    static void dfs(int n, int depth){
        if(depth == N) {
            sb.append(n).append("\n");
            return;
        }
        for(int i = 1; i <= 9; i++){
            int next = n * 10 + i;
            if(isPrime(next)){
                dfs(next, depth + 1);
            }
        }
    }
    static boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}