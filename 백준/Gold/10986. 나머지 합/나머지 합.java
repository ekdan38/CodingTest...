import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // s[1 0 0 1 0]
        //=> (s[j] - s[i - 1]) % M = 0
        // => s[j] % M = s[i - 1] % M, 즉 누적합에서 M으로 나누고 그중에서 2개 집으면 만족
        // s[i] % 3 == 0인 녀석들은 애초에 시작부터 i까지 누접합이 m으로 나눠 떨어진다.
        // 얘네는 먼저 더해주고 이후 combination 연산
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] s = new long[N + 1];
        long[] count = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            s[i] = (s[i - 1] + Integer.parseInt(st.nextToken())) % M;
            count[(int) s[i]]++;
        }

        long result = 0;
        result += count[0];

        for(int i = 0; i < M; i++){
            result += (count[i] * (count[i] - 1) / 2);
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}