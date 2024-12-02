import java.io.*;
import java.util.*;

/**
 * 24444 알고리즘 수업 - 너비 우선 탐색 1
 * 입력:
 *      1. 첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)
 *      2. 다음 M개 줄에 간선 정보 u v
 *
 *문제 분석:
 *      1. 호수에서 출발해서 B로 도달 할 수 있는 최단거리 구하면 된다.
 *      (R은 지나갈 수 없다. 상하좌우로 움직일 수 있다.
 *수정 사항
 *      1. 결과에서 계속 +1이 더 나와서 다시 문제를 보니 L부터가 아니라 L주변의 소 부터 탐색을 하는 문제였다.
 *      L부터 탐색을 시작하니 + 1이 더 나왔다. => 최종 결과 값에서 - 1해줌
 *
 * 출력:
 *      1. 최단 거리 출력
 */

public class Main {
    static List<List<Integer>> graph;
    static boolean[]visited;
    static int [] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList<>(N + 1);
        //012345
        result = new int[N + 1];


        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 0; i < N; i++) {
            graph.get(i).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }

        bfs(R);
        for(int i = 1; i < N + 1; i++){
            sb.append(result[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int cnt = 1;
        result[start] = cnt++;

        while(!queue.isEmpty()){
            Integer current = queue.poll();
            int size = graph.get(current).size();
            for(int i = 0; i < size; i++){
                Integer next = graph.get(current).get(i);
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                    result[next] = cnt++;
                }
            }
        }
    }


}
