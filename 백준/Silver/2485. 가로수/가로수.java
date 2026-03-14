import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        
        Arrays.sort(arr);
        
        int GCD = 0;
        for (int i = 1; i < N; i++) {
            GCD = gcd(arr[i] - arr[i - 1], GCD);
        }
        long result = (long)(arr[N - 1] - arr[0]) / GCD + 1 - N;
        
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        System.out.println(sb.toString());
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}