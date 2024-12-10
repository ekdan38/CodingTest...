import java.io.*;
import java.util.*;

/**
 * 15649 N 과 M (1)
 *
 * 입력:
 *      1. 자연수 N 과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 *
 *문제 분석:
 *      1. 1 ~ N까지 자연수 중에서 중복 없이 M개를 고른 수열 이면서 길이가 M인 수열
 *      => 가능한 모든 경우 구하고 중복 제거하고 사전순으로 정리
 *
 *  출력:
 *      1. 얻을 수 있는 최대 아이템 수 출력
 */

public class Main {
    static int N;
    static int M;
    static int [] sequence, numbers;
    static boolean [] visited;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1번 index부터 사용
        // 1 ~ N 까지 숫자로 조합 해보자
        numbers = new int[N + 1];
        // M 자리 만큼 조합 가능한 숫자
        sequence = new int[M + 1];
        visited = new boolean[N + 1];

        dfs(1);

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static void dfs(int depth){
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