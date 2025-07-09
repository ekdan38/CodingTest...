import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        // 투포인터 탐색
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int start = 1;
        int end = N;
        int result = 0;
        int sum = 0;
        while(start < end){
            sum = arr[start] + arr[end];
            if(sum == M){
                result++;
                start++;
                end--;
            }
            else if(sum > M){
                end--;
            }
            else if(sum < M){
                start++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

    }
}