import java.util.*;
import java.io.*;
public class Main{
    static int N, M;
    static char[][] graph;
    static int result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N + 1][M + 1];

        List<int[]> searchList = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for(int j = 1; j <= M; j++){
                graph[i][j] = line.charAt(j - 1);
                if(graph[i][j] == 'L') searchList.add(new int[]{i, j});
            }
        }

        for(int[] s : searchList){
            bfs(s);
        }

        System.out.print(result);
    }
    static void bfs(int[] s){
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[N + 1][M + 1];

        for(int i = 0; i <= N; i++){
            Arrays.fill(dist[i], -1);
        }

        queue.offer(s);
        dist[s[0]][s[1]] = 0;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if(dist[nx][ny] != -1) continue;
                if(graph[nx][ny] == 'W') continue;
                queue.offer(new int[]{nx ,ny});
                dist[nx][ny] = dist[cx][cy] + 1;
                max = Math.max(max, dist[nx][ny]);
            }
        }

        result = Math.max(max, result);
    }
}