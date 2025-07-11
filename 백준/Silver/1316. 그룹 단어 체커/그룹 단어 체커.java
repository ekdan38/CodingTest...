import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // start, end 찾고 그 사이에 다른게 존재하면, return false;
        // 그게 아니라면 idx 값 end + 1로 idx 갱신
        // while문 끝까지 처리하면, 그냥 true return

        int cnt = 0;
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(check(str))cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
    static boolean check(String str){
        int idx = 0;
        while(idx < str.length()){
            char c = str.charAt(idx);
            int start = str.indexOf(c);
            int end = str.lastIndexOf(c);
            String sub = str.substring(start, end + 1);
            for(int i = 0; i < sub.length(); i++){
                if(sub.charAt(i) != c) return false;
            }
            idx = end + 1;
        }
        return true;
    }



}