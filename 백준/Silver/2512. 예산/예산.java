import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); 
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine()); 
        
        int left = 0;
        int right = -1; 
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }
        int M = Integer.parseInt(br.readLine()); 
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long budget = 0;
            for (int i = 0; i < N; i++) {
                budget += Math.min(arr[i], mid);
            }
            if (budget <= M) left = mid + 1;
            else right = mid -1;
        }
        System.out.println(right);
    }
}