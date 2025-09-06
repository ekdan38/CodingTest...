import java.io.*;
import java.util.*;

public class Main {

    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        number = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){ 
            number[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i <= N - K; i++){
            int sum = 0;
            for(int j = i; j < i + K; j++){ 
                sum += number[j];
            }
            max = Math.max(sum, max); 
        }
       System.out.println(max); 
    }
}