import java.util.*;
import java.io.*;
public class Main{
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            char[][] graph = new char[N + 1][M + 1];
            int[][] fireTime = new int[N + 1][M + 1];
            int[][] exitTime = new int[N + 1][M + 1];
            for(int i = 0; i <= N; i++){
                Arrays.fill(fireTime[i], -1);
                Arrays.fill(exitTime[i], -1);
            }
            List<int[]> fireList = new ArrayList<>();
            int sx = 0;
            int sy = 0;

            for(int i = 1; i <= N; i++){
                String line = br.readLine();
                for(int j = 1; j <= M; j++){
                    graph[i][j] = line.charAt(j - 1);
                    if(graph[i][j] == '*') fireList.add(new int[]{i, j});
                    if(graph[i][j] == '@'){
                        sx = i;
                        sy = j;
                    }
                }
            }

            fireBfs(graph, fireTime, fireList);
            int result = exitBfs(graph, fireTime, exitTime, sx, sy);
            sb.append(result == -1 ? "IMPOSSIBLE" : result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static int exitBfs(char[][] graph, int[][] fireTime, int[][] exitTime, int sx, int sy){
        int result = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        exitTime[sx][sy] = 0;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];


            for(int i = 0; i < 4; i++){
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if(nx < 1 || nx > N || ny < 1 || ny > M) return exitTime[cx][cy] + 1;
                if(exitTime[nx][ny] != -1) continue;
                if(graph[nx][ny] == '#') continue;
                if(fireTime[nx][ny] == -1 || fireTime[nx][ny] > exitTime[cx][cy] + 1){
                    queue.offer(new int[]{nx ,ny});
                    exitTime[nx][ny] = exitTime[cx][cy] + 1;
                }
            }

        }
        return result;
    }
    static void fireBfs(char[][] graph, int[][] fireTime, List<int[]> fireList){
        Queue<int[]> queue = new LinkedList<>();
        for(int[] f : fireList){
            queue.offer(f);
            fireTime[f[0]][f[1]] = 0;
        }

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if(fireTime[nx][ny] != -1) continue;
                if(graph[nx][ny] == '#') continue;
                queue.offer(new int[]{nx, ny});
                fireTime[nx][ny] = fireTime[cx][cy] + 1;
            }
        }
    }
}