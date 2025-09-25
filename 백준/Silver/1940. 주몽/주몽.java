import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int start = 0;
        int end = N - 1;
        int cnt = 0;
        
        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == M){
                cnt++;
                start++;
                end--;
            }
            else if(sum < M){
                start++;
            }
            else if(sum > M){
                end--;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}