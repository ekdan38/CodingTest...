
import java.io.*;
import java.util.*;
public class Main{
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][M + 1];
        graph = new int [N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= M; j++){
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }
    static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1,1, 0));
        visited[1][1] = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.x == N && current.y == M) return current.d + 1;
            for(int i = 0; i < 4; i++){
                int nX = current.x + dx[i];
                int nY = current.y + dy[i];

                if(nX >= 1 && nX <= N && nY >= 1 && nY <= M && graph[nX][nY] == 1 && !visited[nX][nY]){
                    queue.offer(new Node(nX, nY, current.d + 1));
                    visited[nX][nY] = true;
                }
            }
        }
        return -1;
    }

    static class Node{
        int x;
        int y;
        int d;
        Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

}