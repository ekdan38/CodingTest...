import java.util.*;
import java.io.*;
public class Main{
    static final int ROW = 12;
    static final int COL = 6;
    static char[][] graph = new char[ROW + 1][COL + 1];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= ROW; i++){
            String line = br.readLine();
            for(int j = 1; j <= COL; j++){
                graph[i][j] = line.charAt(j - 1);
            }
        }

        int cnt = 0;

        while(true){
            List<int[]> removeList = new ArrayList<>();
            boolean[][] visited = new boolean[ROW + 1][COL + 1];

            for(int i = 1; i <= ROW; i++){
                for(int j = 1; j <= COL; j++){
                    if(graph[i][j] != '.' && !visited[i][j]) {
                        bfs(i, j, visited, removeList);
                    }
                }
            }

            if(removeList.isEmpty()) break;

            // 터트리기
            for(int[] r : removeList){
                graph[r[0]][r[1]] = '.';
            }

            // 이동
            gravity();

            cnt++;
        }

        System.out.print(cnt);
    }

    private static void gravity() {
        for (int j = 1; j <= COL; j++) {
            int bottom = ROW;

            for (int i = ROW; i >= 1; i--) {
                if (graph[i][j] != '.') {
                    char t = graph[i][j];
                    graph[i][j] = '.';
                    graph[bottom][j] = t;
                    bottom--;
                }
            }
        }
    }

    static void bfs(int x, int y, boolean[][] visited, List<int[]> removeList){
        List<int[]> list = new ArrayList<>();
        char color = graph[x][y];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            list.add(new int[]{cx, cy});

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || nx > ROW || ny < 1 || ny > COL) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny] != color) continue;

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        if(list.size() >= 4) removeList.addAll(list);
    }
}