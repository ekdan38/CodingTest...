import java.io.*;
import java.util.*;

/**
 * 15681 트리와 쿼리
 *
 * 입력:
 *      1. 첫째 줄 N (2 ~ 10^5), R (1 ~ N), Q (1 ~ 10^5)
 *      2. 이후 N - 1 줄에 걸쳐서  U V 형태로 트리에 속한 간선 정보가 주어진다.
 *      3. 이후 Q 줄에 걸쳐 문제에 설명한 U가 하나씩 주어진다. (1 ~ N)
 *
 * 문제 분석:
 *      1. dfs로 서브트리 크기를 구해주자.
 *
 * 출력
 *
 * */

public class Main {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[] subtreeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        // index 1부터 사용
        subtreeSize = new int[n + 1];
        visited = new boolean[n + 1];

        // 인접 리스트 사용
        for(int i = 0; i <= n; i++){
            tree.add(new ArrayList<>());
        }

        // 양방향 그래프
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(r);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < q; i++){
            result.append(subtreeSize[Integer.parseInt(br.readLine())]).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int node){
        // 방분 표시
        visited[node] = true;
        // 1로 설정하고 시작
        subtreeSize[node] = 1;

        // subtreeSize[node] = 1 (자기 자신) + 모든 자식의 서브트리 크기 합
        for (Integer child : tree.get(node)) {
            if(!visited[child]){
                dfs(child);
                subtreeSize[node] += subtreeSize[child];
            }
        }
    }

}