import java.io.*;
import java.util.*;

/**
 * 10971 외판원 순회 2
 *
 * 입력:
 *      1. 첫째 줄에 도시의 수 N이 주어진다. (2 ≤ N ≤ 10) 다음 N개의 줄에는 비용 행렬이 주어진다.
 *      각 행렬의 성분은 1,000,000 이하의 양의 정수이며, 갈 수 없는 경우는 0이 주어진다. W[i][j]는 도시 i에서 j로 가기 위한 비용을 나타낸다.
 *
 * 문제 분석:
 *      1. 한 도시에서 출발해서 N개의 도시를 모두 거쳐 원래의 도시로 돌아오는 최소 경로 찾기 => 백트래킹
 *      => 길이 없을수도 있고, 중복 xx,
 *      => 값 저장할 변수 필요함
 *
 * 출력:
 *
 * */

public class Main {
        static int [][] field;
        static boolean [] visited;
        static int N;
        static int minCost = Integer.MAX_VALUE;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            // 1번 index 부터 사용
            field = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for(int i = 1; i <= N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++){
                    field[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            visited[1] = true;
            // cnt 1부터 시작
            dfs(1, 1, 1, 0);


            bw.write(Integer.toString(minCost));
            bw.flush();
            br.close();
            bw.close();
        }
        static void dfs(int start, int current, int cnt, int cost){
            // 모든 도시 방문 했으면
            if(cnt == N){
                // start로 다시 들오갈 수 있으면 (0 이면 못돌아간다.)
                if(field[current][start] != 0) minCost = Math.min(minCost, cost + field[current][start]);
                return;
            }

            // 모든 도시 방문
            for(int i = 1; i <= N; i++){
                // 방문 안했거나 0 이 아니면 탐색
                if(!visited[i] && field[current][i] != 0){
                    visited[i] = true;
                    dfs(start, i, cnt + 1, cost + field[current][i]);
                    visited[i] = false;
                }
            }
        }

    }