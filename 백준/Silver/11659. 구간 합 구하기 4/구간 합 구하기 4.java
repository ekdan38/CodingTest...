import java.util.*;
import java.io.*;
/**
 첫째줄 N M => 수의 개수, 합을 구해야 하는 횟수
 둘째줄 N개의 수
 */

// 구간합 문제
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sumArr = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum += num;
            sumArr[i] = sum;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 2;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if(start > -1) bw.write(sumArr[end] - sumArr[start] + "\n");
            else bw.write(sumArr[end] + "\n");
        }
        bw.flush();

    }
}