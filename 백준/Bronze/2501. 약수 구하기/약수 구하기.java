import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        // 각 테스트 케이스마다 첫 번째 숫자가 두 번째 숫자의 약수라면 factor를, 배수라면 multiple을, 둘 다 아니라면 neither를 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        System.out.print(find(N, K, cnt));

    }
    private static int find(int N, int K, int cnt){
        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                cnt++;
                if(cnt == K)return i;
            }
        }
        return 0;
    }
}
