import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

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

        boolean isAllMelt = false;
        int time = 0;
        while(!isAllMelt){
            boolean isMelt = bfs();
            if(isMelt) time++;
            if(!isMelt) isAllMelt = true;
        }

        System.out.print(time);
    }
    static boolean bfs(){
        List<int[]> meltList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int[][] cheese = new int[N + 1][M + 1];
        boolean[][] visited = new boolean[N + 1][M + 1];

        queue.offer(new int[]{1, 1});
        visited[1][1] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if(visited[nx][ny]) continue;
                // 치즈
                if(graph[nx][ny] == 1){
                    cheese[nx][ny]++;
                    if(cheese[nx][ny] == 2) meltList.add(new int[]{nx, ny});
                }
                // 외부 공기
                else{
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        // 녹일거 있어서 녹였으면 true;
        if(!meltList.isEmpty()){
            for(int[] c : meltList){
                graph[c[0]][c[1]] = 0;
            }
            return true;
        }
        return false;
    }
}