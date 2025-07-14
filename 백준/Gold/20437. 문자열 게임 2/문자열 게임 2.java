import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int[] arr = new int[26];
            for(int i = 0; i < W.length(); i++){
                arr[W.charAt(i) - 'a']++;
            }

            for(int i = 0; i < W.length(); i++){
                if(arr[W.charAt(i) - 'a'] < K) continue;
                int cnt = 0;
                for(int j = i; j < W.length(); j++){
                    if(W.charAt(j) == W.charAt(i)) cnt++;
                    if(cnt == K){
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }
            bw.write(min != Integer.MAX_VALUE && max != Integer.MIN_VALUE ? min + " " + max +"\n" : "-1\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}