import java.util.*;
import java.io.*;

public class Main{
    static int[][] graph;
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(graph[i][j] == 1 && !visited[i][j]){
                    bfs(i, j, idx);
                    idx++;
                }
            }
        }

        int result = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                Set<Integer> set = new HashSet<>();
                if(graph[i][j] == 0){
                    for(int w = 0; w < 4; w++){
                        int nx = i + dx[w];
                        int ny = j + dy[w];

                        if(nx < 1 || nx > N || ny < 1 || ny > M) continue;

                        if(graph[nx][ny] == 0) continue;
                        set.add(graph[nx][ny]);
                    }
                }
                int max = 1;
                for(int n : set){
                    max += map.get(n);
                }
                result = Math.max(result, max);
            }
        }

        System.out.print(result);
    }
    static void bfs(int x, int y, int idx){
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 1});
        visited[x][y] = true;
        graph[x][y] = idx;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if(visited[nx][ny]) continue;

                if(graph[nx][ny] == 1){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    graph[nx][ny] = idx;
                    cnt++;
                }
            }
        }
        map.put(idx, cnt);
    }
}