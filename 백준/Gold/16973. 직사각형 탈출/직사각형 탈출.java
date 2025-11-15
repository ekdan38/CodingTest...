/*
    문제
        1. 크기가 N X M 인 격자파에 크기가 H X W 인 직사각형 존재.
        2. 왼쪽 맨 위는 (1,1) 맨 아래는 (N, M)
        3. 직사각형 왼쪽 위는 (Sr, Sc) 이 부분을 (Fr, Fc)로 옮겨야한다. 이때 최소 횟수
        4. 빈 칸 혹은 벽 존재 -> 직사각형은 벽에는 존재 불가능 또한 벗어날 수 없음
        5. 직사각형은 상하좌우 4방향 이동 가능.
    입력
        1. 첫째 줄 N, M
        2. 둘째 줄 부터 격자판 정보(0 빈 칸, 1 벽)
        3. 마지막 줄에 직사각형 H, W, Sr, Sc, Fr, Fc
    출력
        1. 최소 이동 횟수, 이동할 수 없다면 -1

    해결 방법
        1. bfs 탐색 진행
        2. 맨 왼쪽 좌표 기준 4방향 탐색 하고 경계값 검사, 방문 검사 후 H X W 만큼 탐색하며 다 0인지 확인
*/
import java.util.*;
import java.io.*;
public class Main{
    static int[][] graph;
    static int N, M, H, W, Sr, Sc, Fr, Fc;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

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

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken());
        Sc = Integer.parseInt(st.nextToken());
        Fr = Integer.parseInt(st.nextToken());
        Fc = Integer.parseInt(st.nextToken());

        int result = bfs();
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M + 1];

        queue.offer(new int[]{Sr, Sc, 0});
        visited[Sr][Sc] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int cd = currents[2];
            if(cx == Fr && cy == Fc) return cd;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 1 && nx <= N - H + 1 && ny >= 1 && ny <= M - W + 1){
                    if(!visited[nx][ny]){
//                        System.out.println("nx = " + nx + ", ny = " + ny);
                        boolean isImPossible = false;
                        isImPossible = check(nx, ny);
                        if(!isImPossible) {
                            queue.offer(new int[]{nx, ny, cd + 1});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
    static boolean check(int nx, int ny){
        for(int h = nx; h < nx + H; h++){
            for(int w = ny; w < ny + W; w++){
                if(graph[h][w] == 1) return true;
            }
        }
        return false;
    }
}