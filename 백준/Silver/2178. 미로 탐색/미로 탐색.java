import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= M; j++){
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }
        boolean[][] visited = new boolean[N + 1][M + 1];
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        Queue<Miro> queue = new LinkedList<>();
        queue.offer(new Miro(1, 1, 1));
        visited[1][1] = true;

        while(!queue.isEmpty()){
            Miro currentMiro = queue.poll();
            int currentX = currentMiro.x;
            int currentY = currentMiro.y;
            int currentD = currentMiro.d;
            if(currentX == N && currentY == M) {
                bw.write(String.valueOf(currentD));
                break;
            }
            for(int i = 0; i < 4; i++){
                int nextX = dx[i] + currentX;
                int nextY = dy[i] + currentY;

                if(nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= M && !visited[nextX][nextY] && graph[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    queue.offer(new Miro(nextX, nextY, currentD + 1));
                }
            }
        }
        bw.flush();
    }
    static class Miro{
        int x;
        int y;
        int d;
        Miro(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}