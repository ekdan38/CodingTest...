import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 2018 수들의 합 5
         * 투포인터
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        for(int q = 0; q < K; q++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int t = i; t < x; t++){
                for(int r = j; r < y; r++){
                    sum += arr[t][r];
                }
            }
            sb.append(sum + "\n");

        }

        System.out.println(sb);
    }
}
