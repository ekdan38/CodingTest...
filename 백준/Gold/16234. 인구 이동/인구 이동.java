import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static boolean[][] visited;
    static int N, L, R;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean isMoved;
    static int day;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();

        bw.write(String.valueOf(day));
        bw.flush();
    }
    static void move(){
        while(true){
            isMoved = false;
            visited = new boolean[N + 1][N + 1];
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(!visited[i][j]) bfs(i, j);
                }
            }
            if(!isMoved) return;
            day++;
        }
    }
    static void bfs(int x, int y){
        List<int[]> unions = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        unions.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = currents[0] + dx[i];
                int ny = currents[1] + dy[i];
                if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                    int mid = Math.abs(graph[cx][cy] - graph[nx][ny]);
                    if(mid >= L && mid <= R){
                        if(!visited[nx][ny]){
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            unions.add(new int[]{nx, ny});
                            isMoved = true;
                        }
                    }
                }
            }
        }
        int sum = 0;
        int size = unions.size();
        for(int[] u : unions){
            sum += graph[u[0]][u[1]];
        }
        for(int[] u : unions){
            graph[u[0]][u[1]] = sum / size;
        }
    }
}