import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static char[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new char[N + 1][N + 1];

        for(int i = 1; i <= N ; i++){
            String line = br.readLine();
            for(int j = 1; j <= N; j++){
                graph[i][j] = line.charAt(j - 1);
            }
        }

        // R + G, B
        int num = 0;
        visited = new boolean[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(!visited[i][j]) {
                    bfs(false, i, j);
                    num++;
                }
            }
        }

        // R, G, B
        int rgNum = 0;
        visited = new boolean[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(!visited[i][j]) {
                    bfs(true, i, j);
                    rgNum++;
                }
            }
        }

        System.out.print(num + " " + rgNum);
    }
    static void bfs(boolean isRG, int x, int y){
        int cnt = 0;
        char target = graph[x][y];

        Queue<int[]> queue = new LinkedList<>();

        // x, y
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if(visited[nx][ny]) continue;

                if(isRG){
                    if(target == 'R' || target == 'G'){
                        if(graph[nx][ny] == 'R' || graph[nx][ny] == 'G'){
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                    else{
                        if(graph[nx][ny] != target) continue;
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
                else{
                    if(graph[nx][ny] != target) continue;
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }

            }
        }
    }
}