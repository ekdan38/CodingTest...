import java.util.*;
import java.io.*;
public class Main{
    static int N, M;
    static int[][] graph;
    static Queue<int[]> queue = new LinkedList<>();
    static int time;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        boolean isZero = false;
        graph = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 0) isZero = true;
                else if (input == 1) queue.offer(new int[]{i, j});
                graph[i][j] = input;
            }
        }

        if(!isZero) bw.write("0");
        else{
            bfs();
            if(checkMinus()) bw.write("-1");
            else bw.write(String.valueOf(time));
        }

        bw.flush();
    }
    static void bfs(){
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] currents = queue.poll();
                int cx = currents[0];
                int cy = currents[1];

                for(int j = 0; j < 4; j++){
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
                    if(nx >= 1 && nx <= N && ny >= 1&& ny <= M){
                        if(graph[nx][ny] == 0){
                            queue.offer(new int[]{nx, ny});
                            graph[nx][ny]  = 1;
                        }
                    }
                }
            }
            if(!queue.isEmpty()) time++;
        }

    }
    static boolean checkMinus(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(graph[i][j] == 0) return true;
            }
        }
        return false;
    }
}