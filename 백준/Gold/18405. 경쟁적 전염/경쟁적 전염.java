import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int N, K;
    static int S, X, Y;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        List<Virus> virusList = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] != 0) virusList.add(new Virus(graph[i][j], i, j, 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        // 바이러스 순서대로 정렬
        Collections.sort(virusList, (v1, v2) -> v1.num - v2.num);

        int result = bfs(virusList);
        System.out.print(result);
    }
    static int bfs(List<Virus> virusList){
        Queue<Virus> queue = new LinkedList<>();

        for(Virus v : virusList){
            queue.offer(v);
        }

        while(!queue.isEmpty()){
            Virus cv = queue.poll();

            if(cv.time == S) continue;

            for(int i = 0; i < 4; i++){
                int nx = cv.x + dx[i];
                int ny = cv.y + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                    if(graph[nx][ny] == 0){
                        graph[nx][ny] = cv.num;
                        queue.offer(new Virus(cv.num, nx, ny, cv.time + 1));
                    }
                }
            }
        }
        return graph[X][Y];
    }
    static class Virus{
        int num;
        int x;
        int y;
        int time;
        public Virus(int num, int x, int y, int time){
            this.num = num;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
