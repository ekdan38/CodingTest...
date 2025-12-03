import java.util.*;
import java.io.*;
public class Main{
    static char[][] graph;
    static int R, C;
    static int[][] waterTime;
    static int[][] dist;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R + 1][C + 1];
        waterTime = new int[R + 1][C + 1];
        dist = new int[R + 1][C + 1];

        for(int i = 0; i <= R; i++){
            Arrays.fill(waterTime[i], -1);
            Arrays.fill(dist[i], -1);
        }

        List<int[]> waters = new ArrayList<>();
        // ., *, X, D, S
        // S -> D
        int sx = 0;
        int sy = 0;

        for(int i = 1; i <= R; i++){
            String line = br.readLine();
            for(int j = 1; j <= C; j++){
                graph[i][j] = line.charAt(j - 1);
                if(graph[i][j] == '*') waters.add(new int[]{i, j});
                else if(graph[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }
            }
        }

        Queue<int[]> waterQueue = new LinkedList<>();
        for(int[] water : waters){
            waterQueue.offer(water);
            waterTime[water[0]][water[1]] = 0;
        }
        // 물 퍼지는 시간 처리
        waterBfs(waterQueue);
        // 고슴도치 탐색
        int result = bfs(sx, sy);
        if(result == -1) System.out.print("KAKTUS");
        else System.out.print(result);

    }
    static int bfs(int sx, int sy){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            if(graph[cx][cy] == 'D') return dist[cx][cy];

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if(nx < 1 || nx > R || ny < 1 || ny > C) continue;
                if(dist[nx][ny] != -1) continue;
                if(waterTime[nx][ny] != -1 && waterTime[nx][ny] <= dist[cx][cy] + 1) continue;
                if(graph[nx][ny] == '*' || graph[nx][ny] == 'X') continue;
                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[cx][cy] + 1;
            }
        }
        return -1;
    }

    static void waterBfs(Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if(nx < 1 || nx > R || ny < 1 || ny > C) continue;
                if(waterTime[nx][ny] != -1) continue;
                if(graph[nx][ny] == 'X' || graph[nx][ny] == 'D') continue;
                queue.offer(new int[]{nx, ny});
                waterTime[nx][ny] = waterTime[cx][cy] + 1;
            }
        }
    }
}