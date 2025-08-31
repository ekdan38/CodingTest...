import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n=Integer.parseInt(br.readLine());
        int[] num=new int[n + 1];
        int answer = 1;
        
        for(int i = 2; i < n + 1; i++){
            if(num[i] != 0) continue;
            
            for(int j = i + i; j< n + 1; j += i){
                num[j] = i;
            }
            num[i] = i;
        }
        int k = Integer.parseInt(br.readLine());
        for(Integer i : num){
            if(i != 0 && i <= k) answer++;
        }
        bw.write(answer + "");
        bw.flush();
    }
}