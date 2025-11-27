import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int[][] dist;
    static int N, M, sx, sy;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(dist[i], -1);
        }

        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for(int j = 1; j <= M; j++){
                graph[i][j] = line.charAt(j - 1) - '0';
                if(graph[i][j] == 2){
                    sx = i;
                    sy = j;
                }
            }
        }

        int result = bfs();
        if(result == -1) System.out.print("NIE");
        else System.out.print("TAK\n" + result);
    }
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while(!queue.isEmpty()){
            int[] c = queue.poll();
            int cx = c[0];
            int cy = c[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if(dist[nx][ny] != -1) continue;
                if(graph[nx][ny] == 1) continue;

                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[cx][cy] + 1;

                if(graph[nx][ny] != 0) return dist[nx][ny];
            }
        }
        return -1;
    }
}
