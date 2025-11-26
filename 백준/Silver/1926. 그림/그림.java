import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static boolean[][] visited;
    static int N, M;
    static int cnt, max;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        List<int[]> paintings = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) paintings.add(new int[]{i, j});
            }
        }

        for(int[] painting : paintings){
            int x = painting[0];
            int y = painting[1];
            if(!visited[x][y]) {
                bfs(x, y);
                cnt++;
            };
        }

        System.out.print(cnt + "\n" + max);

    }
    static void bfs(int x, int y){
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] c = queue.poll();
            int cx = c[0];
            int cy = c[1];

            result++;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                    if(!visited[nx][ny] && graph[nx][ny] == 1){
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        max = Math.max(result, max);
    }
}
