import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 전부다 소문자니깐 소문자로 index접근해서 확인해보자.
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String str = new StringTokenizer(br.readLine()).nextToken();
            if(isGroupWords(str)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isGroupWords(String str) {
        boolean[] checkArr = new boolean['z' - 'a' + 1];
        char previous = str.charAt(0);
        checkArr[previous - 'a'] = true;
        for(int i = 1; i < str.length(); i++){
            char current = str.charAt(i);
            if(current != previous){
                if(checkArr[current - 'a']){
                    return false;
                }
                checkArr[current - 'a'] = true;
            }
            previous = current;
        }
        return true;
    }
}
