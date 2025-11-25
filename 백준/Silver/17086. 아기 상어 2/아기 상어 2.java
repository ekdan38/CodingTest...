import java.util.*;
import java.io.*;
public class Main{
    static int N, M;
    static int[][] graph;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(graph[i][j] == 0) {
                    max = Math.max(bfs(i, j), max);
                }
            }
        }

        System.out.print(max);

    }
    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M + 1];
        // x, y, dist
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int dist = currents[2];

            for(int i = 0; i < 8; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                    if(!visited[nx][ny]){
                        if(graph[nx][ny] == 1) return dist + 1;
                        else{
                            queue.offer(new int[]{nx, ny, dist + 1});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}