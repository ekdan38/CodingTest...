import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int min = 0;
        for(int i = M; i <= N; i++){
            if(i == 1)continue;
            int cnt = 0;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                   cnt++;
                   break;
                }
            }
            if(cnt == 0){
                result += i;
                if(min == 0)min = i;
            }

        }
        if(result == 0 && min == 0)System.out.print(-1);
        else System.out.print(result + "\n" + min);
    }
}
