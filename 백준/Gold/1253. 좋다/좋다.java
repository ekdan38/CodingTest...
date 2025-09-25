import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int cnt = 0;

        for(int i = 0; i < N; i++){
            int start = 0;
            int end = N - 1;
            long kindNum = arr[i];
            
            while(start < end){
                if(start == i){
                    start++;
                    continue;
                }
                if(end == i){
                    end--;
                    continue;
                }
                
                long sum = arr[start] + arr[end];
                if(sum == kindNum){
                    cnt++;
                    break;
                }
                else if(sum < kindNum){
                    start++;
                }
                else if(sum > kindNum){
                    end--;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
