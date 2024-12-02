import java.io.*;
import java.util.*;

/**
 * 17198 Bucket Brigade
 * 입력:
 *      1. 10 x 10으로 행렬 주어짐 (각 1개의 B, R, L 포함)
 *      B => 헛간, R => 바위, L => 호수
 *
 *문제 분석:
 *      1. 호수에서 출발해서 B로 도달 할 수 있는 최단거리 구하면 된다.
 *      (R은 지나갈 수 없다. 상하좌우로 움직일 수 있다.
 * 출력:
 *      1. 최단 거리 출력
 */

public class Main {
    static char [][] arr = new char[10][10];
    static boolean [][] visited = new boolean[10][10];
    static int rX, rY;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {-1, 1 ,0 ,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 10; i ++){
            String str = br.readLine();
            for(int j = 0; j < 10; j++){
                char field = str.charAt(j);
                arr[i][j] = field;
                //R 위치 표시
                if(field == 'R')visited[i][j] = true;
                //L 위치 표시
                if(field == 'L'){
                    rX = i;
                    rY = j;
                }
            }
        }

        //L에서 시작해서 B까지 이동, 단 R은 지날 수 없다. (최단 거리)
        System.out.println(bfs() - 1);

        bw.flush();
        br.close();
        bw.close();
    }
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rX, rY});
        visited[rX][rY] = true;

        int cnt = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] poll = queue.poll();
                int currentX = poll[0];
                int currentY = poll[1];

                if(arr[currentX][currentY] == 'B')return cnt;

                for(int j = 0; j < 4; j++){
                    int nextX = currentX + dx[j];
                    int nextY = currentY + dy[j];

                    if(nextX >= 0 && nextX < 10 && nextY >= 0 && nextY < 10 && !visited[nextX][nextY]){
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }


}
