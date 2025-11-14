import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static boolean[][] visited;
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
        List<int[]> viruses = new ArrayList<>();
        List<int[]> empty = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                int input = Integer.parseInt(st.nextToken());
                graph[i][j] = input;
                if(input == 2) viruses.add(new int[]{i, j});
                else if(input == 0) empty.add(new int[]{i, j});
            }
        }

        int result = 0;
        for(int i = 0; i < empty.size(); i++){
            for(int j = i + 1; j < empty.size(); j++){
                for(int k = j + 1; k < empty.size(); k++){
                    visited = new boolean[N + 1][M + 1];
                    int[] first = empty.get(i);
                    int[] second = empty.get(j);
                    int[] third = empty.get(k);

                    visited[first[0]][first[1]] = true;
                    visited[second[0]][second[1]] = true;
                    visited[third[0]][third[1]] = true;

                    int sum = 0;
                    for(int[] v : viruses){
                        sum += bfs(v[0], v[1]);
                    }
                    result = Math.max(result, (empty.size() - sum - 3));
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
    static int bfs(int x, int y){
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M){
                    if(!visited[nx][ny] && graph[nx][ny] == 0){
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}