import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int sum = 1;
        int result = 1;

        while(end < N){
            if(sum == N){
                end++;
                sum += end;
                result++;
            }
            else if(sum > N){
                sum -= start;
                start++;
            }
            else if(sum < N){
                end++;
                sum += end;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}