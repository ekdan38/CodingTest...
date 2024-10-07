import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int j = 1; j < num; j++){
                if(num % j == 0)cnt++;
                if(cnt > 1)break;
            }
            if(cnt == 1) result++;
        }
        System.out.print(result);

    }
}
