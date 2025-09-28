import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // M 부터 N까지의 소수 출력
        // 에라토스테네스 체 사용
        boolean[] arr = new boolean[N + 1];
        Arrays.fill(arr, true);
        arr[1] = false;

        // 탐색범위 줄이기
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(arr[i]){
                for(int j = i + i; j <= N; j += i){
                    if(arr[j]) arr[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = M; i <= N; i++){
            if(arr[i]) sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}