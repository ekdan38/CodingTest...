import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int answer = 0;
        for(int i=0; i<M; i++) {
            if(str.charAt(i) == 'I') {
                int tmp = i;
                int cnt = 0;
                
                while(tmp + 2 < M) {
                    if(str.charAt(tmp+1) == 'O' && str.charAt(tmp+2) == 'I') {
                        cnt++;
                        tmp += 2;
                        if(cnt == N) {
                            cnt--;
                            answer++;
                        }
                    }
                    else  break;
                }
                i = tmp;
            }
        }
        System.out.println(answer);
    }
}