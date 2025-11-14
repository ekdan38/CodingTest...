import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int time;

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

        int pastSize = 0;
        while(true){
            // bfs 돌리는데 return 값으로 meltlist오는데 이거 비어있지 않을때 까지.
            List<int[]> meltList = bfs();
            if(meltList.isEmpty()) break;
            for(int[] c : meltList){
                graph[c[0]][c[1]] = 0;
            }
            pastSize = meltList.size();
            time++;
        }

        bw.write(String.valueOf(time) + "\n" + String.valueOf(pastSize));
        bw.flush();

    }
    static List<int[]> bfs(){
        List<int[]> meltList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N + 1][M + 1];
        queue.offer(new int[]{1, 1});
        visited[1][1] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                    if(!visited[nx][ny]){
                        if(graph[nx][ny] == 0){
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                        else if(graph[nx][ny] == 1){
                            visited[nx][ny] = true;
                            meltList.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return meltList;
    }
}