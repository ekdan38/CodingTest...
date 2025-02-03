
import java.io.*;
import java.util.*;

/**
 * 14940 쉬운 최단거리
 *
 * 입력:
 *      1. 지도의 크기 n과 m이 주어진다. n은 세로의 크기, m은 가로의 크기다.(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)
 *      2. 다음 n개의 줄에 m개의 숫자가 주어진다. (0 == 갈 수 없는 땅, 1 == 갈 수 있는 땅, 2 == 목표 지점)
 *
 * 문제 분석:
 *      1. 목표지점 부터 각 갈 수 있는 땅으로 bfs 4개 방향으로 돌리면서 거리 저장
 *      !!!!!! 원래 갈 수 있는데 도달하지 못하는 위치는 -1
 *
 * 출력:
 *
 * */

public class Main {
    static int N, M;
    static int [][] field;
    static int [][] resultField;
    static boolean [][] visited;
    static int targetX, targetY;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = { 0, 0, -1, 1};
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            field = new int[N][M];
            resultField = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    field[i][j] = Integer.parseInt(st.nextToken());
                    if (field[i][j] == 2) {
                        targetX = i;
                        targetY = j;
                    }
                    if(field[i][j] == 1) resultField[i][j] = -1;
                }
            }

            // 시작 지점은 거리 0
            resultField[targetX][targetY] = 0;
            // bfs 수행
            bfs();

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    result.append(resultField[i][j]).append(" ");
                }
                result.append("\n");
            }

            bw.write(result.toString());
            bw.flush();
            br.close();
            bw.close();
        }

        static void bfs(){
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{targetX, targetY});
            visited[targetX][targetY] = true;

            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                int nextDistance = resultField[currentX][currentY] + 1;

                // 4방향 이동
                for(int i = 0; i < 4; i++){
                    int mx = currentX + dx[i] ;
                    int my = currentY + dy[i] ;
                    // 경계 확인, 방문, field 값이 1인지 확인
                    if(mx >= 0 && mx < N && my >= 0 && my < M && !visited[mx][my] && field[mx][my] == 1){
                        visited[mx][my] = true;
                        resultField[mx][my] = nextDistance;
                        queue.offer(new int[]{mx, my});
                    }
                }

            }

        }

    }
