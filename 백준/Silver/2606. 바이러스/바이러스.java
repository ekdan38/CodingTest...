import java.io.*;
import java.util.*;

/**
 * 2606 바이러스
 * 입력:
 *      1. 첫째 줄 컴퓨터의 수 (1 ~ 100)
 *      2. 둘째 줄 연결 되어 잇는 컴퓨터 쌍의 수
 *      3. 쌍의 수 만큼 컴퓨터의 번 호 쌍
 *문제 분석:
 *      1. 한 컴퓨터가 바이러스에 연결되어 있는 컴퓨터도 바이러스에 걸린다. (1번으로 고정)
 *      => 1번과 그래프로 연결되어 있는 컴퓨터 수 구하자
 *      2. bfs 사용하자
 *
 *수정 사항:
 *      1. 단방향 그래프로 가정하고 풀었는데 양방향 그래프로 풀어야한다.
 *
 * 출력:
 *      1. 1번과 열결되어 있는 컴퓨터 수 출력
 */

public class Main {
    static List<List<Integer>> graph;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //컴퓨터 수
        int C = Integer.parseInt(br.readLine());
        //네트워크 수
        int N = Integer.parseInt(br.readLine());
        //index 1번부터 사용 하자
        graph = new ArrayList<>(C + 1);
        // 0,1,2,3,4,5,6,7
        visited = new boolean[C + 1];

        for(int i = 0; i < C + 1; i++){
            graph.add(new ArrayList<>());
        }

        //단방향 그래프 아니다. 양방향 그래프로 이해해야한다.(pc 통신 생각)
        for(int i  = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);

        }

        int result = bfs(1);
        
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
    static int bfs(int startC){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startC);
        visited[startC] = true;
        //카운트 해주자
        int cnt = 0;

        while (!queue.isEmpty()){
            int currentC = queue.poll();
            cnt++;

            int size = graph.get(currentC).size();
            for(int i = 0; i < size; i++){
                Integer nextC = graph.get(currentC).get(i);
                if(!visited[nextC]){
                    queue.add(nextC);
                    visited[nextC] = true;
                }
            }
        }
        // 1도 포함되어서 -1 꼭 해주자
        return cnt - 1;
    }



}
