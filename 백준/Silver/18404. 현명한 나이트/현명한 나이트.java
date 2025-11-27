import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int[][] dist;
    static int N;
    static int sx, sy;
    static List<int[]> targets = new ArrayList<>();
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i++){
            Arrays.fill(dist[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            targets.add(new int[]{x, y});
        }

        bfs();

        StringBuilder sb = new StringBuilder();

        for(int[] t : targets){
            sb.append(dist[t[0]][t[1]]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();

    }
    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < dx.length; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                    if(dist[nx][ny] == -1){
                        queue.offer(new int[]{nx, ny});
                        dist[nx][ny] = dist[cx][cy] + 1;
                    }
                }
            }
        }
    }
}