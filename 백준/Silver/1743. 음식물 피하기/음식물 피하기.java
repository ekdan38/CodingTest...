import java.util.*;
import java.io.*;
public class Main{
    static int N, M, K;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        List<int[]> trash = new ArrayList<>();

        while(K --> 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            trash.add(new int[]{x, y});
            graph[x][y] = 1;
        }

        int result = 0;
        for(int[] t : trash){
            int x = t[0];
            int y = t[1];
            if(!visited[x][y]) result = Math.max(bfs(new int[]{x, y}), result);
        }

        System.out.print(result);
    }
    static int bfs(int[] node){
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(node);
        visited[node[0]][node[1]] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int x = currents[0];
            int y = currents[1];
            cnt++;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                    if(!visited[nx][ny] && graph[nx][ny] == 1){
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return cnt;
    }
}
