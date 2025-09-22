import java.util.*;
import java.io.*;
public class Main{
    static int[][] map;
    static int N;
    static boolean[][] visited;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            String input = br.readLine();
            for(int j = 1; j <= N; j++){
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        int result = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(map[i][j] == 1) {
                    list.add(bfs(i, j));
                    result++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");
        Collections.sort(list);
        for(int n : list){
            sb.append(n).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static int bfs(int x, int y){
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cX = current[0];
            int cY = current[1];
            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                if(nX > 0 && nX <= N && nY > 0 && nY <= N){
                    if(!visited[nX][nY] && map[nX][nY] == 1){
                        queue.offer(new int[]{nX, nY});
                        visited[nX][nY] = true;
                        map[nX][nY] = 0;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}