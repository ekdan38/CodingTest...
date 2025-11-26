import java.util.*;
import java.io.*;
public class Main{
    static char[][] graph;
    static boolean[][] visited;
    static int N, M;
    static int lastWolves, lastSheep;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        List<int[]> searchList = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for(int j = 1; j <= M; j++){
                graph[i][j] = line.charAt(j - 1);
                if(graph[i][j] != '#') searchList.add(new int[]{i, j});
            }
        }

        for(int[] search : searchList){
            int x = search[0];
            int y = search[1];
            if(!visited[x][y]){
                bfs(x, y);
            }
        }

        System.out.print(lastSheep + " " + lastWolves);
    }
    static void bfs(int x, int y){
        int wolves = 0;
        int sheep = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            if(graph[cx][cy] == 'v') wolves++;
            else if(graph[cx][cy] == 'o') sheep++;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                    if(!visited[nx][ny] && graph[nx][ny] != '#'){
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        if(sheep > wolves) lastSheep += sheep;
        else lastWolves += wolves;
    }
}