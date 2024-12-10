import java.io.*;
import java.util.*;

/**
 * 15651 N 과 M (3)
 *
 * 입력:
 *      1. 자연수 N 과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
 *
 *문제 분석:
 *      1. 1 ~ N까지 자연수 중에 M개를 고른 수열 이면서 길이가 M인 수열
 *      => 가능한 모든 경우 구하고 중복 제거하고 사전순으로 정리
 *
 *  출력:
 *      1. 조건 만족하는 수열 구하고 사전순 출력
 */

public class Main {
    static int N, M;
    static int [] sequence;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M + 1];


        dfs(1);

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static void dfs(int depth){
        boolean []visited = new boolean[N + 1];

        if(depth > M){
            for(int i = 1; i < sequence.length; i++){
                result.append(sequence[i]).append(" ");
            }
            result.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                sequence[depth] = i;
                dfs(depth + 1);
                visited[i] = false;

            }
        }

    }

}