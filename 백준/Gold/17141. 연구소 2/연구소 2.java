import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int N, M;
    static List<int[]> virusList = new ArrayList<>();
    static int[] picked;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        picked = new int[M];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2) virusList.add(new int[]{i, j});
            }
        }

        comb(0, 0);
        if(result == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(result);

    }
    static void comb(int start, int depth){
        if(depth == M){
            bfs();
            return;
        }
        for(int i = start; i < virusList.size(); i++){
            picked[depth] = i;
            comb(i + 1, depth + 1);
        }
    }

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[N + 1][N + 1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(dist[i], -1);
        }

        for(int p : picked){
            int x = virusList.get(p)[0];
            int y = virusList.get(p)[1];

            queue.offer(new int[]{x, y});
            dist[x][y] = 0;
        }

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if(dist[nx][ny] != -1) continue;
                if(graph[nx][ny] == 1) continue;

                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[cx][cy] + 1;
            }
        }

        int max = 0;
        boolean isFinish = true;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(graph[i][j] != 1){
                    if(dist[i][j] == -1) {
                        isFinish = false;
                        break;
                    }
                    max = Math.max(max, dist[i][j]);
                }
            }
            if(!isFinish) break;
        }

        if(isFinish) result = Math.min(max, result);
    }

}