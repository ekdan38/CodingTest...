import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for(int i = 1; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean result = bfs();
        if(result) System.out.print("HaruHaru");
        else System.out.print("Hing");
    }
    static boolean bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 1});
        visited[1][1] = true;

        while(!queue.isEmpty()){
            int[] c = queue.poll();
            int cx = c[0];
            int cy = c[1];

            if(graph[cx][cy] == -1) return true;

            int jump = graph[cx][cy];

            int nx = cx + jump;
            int ny = cy;
            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                if(!visited[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

            nx = cx;
            ny = cy + jump;
            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                if(!visited[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }
}