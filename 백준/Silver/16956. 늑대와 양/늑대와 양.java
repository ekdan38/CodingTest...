import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];

        for(int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 'W') {
                    if(!check(i, j)) {
                        bw.write("0");
                        bw.flush();
                        return;
                    }
                }
            }
        }

        bw.write("1\n");
        for(int i = 0; i < N; i++) {
            bw.write(graph[i]);
            bw.write("\n");
        }
        bw.flush();
    }

    public static boolean check(int x, int y) {
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if(graph[nx][ny] == 'S') return false;
            if(graph[nx][ny] == '.') graph[nx][ny] = 'D';
        }
        return true;
    }
}
