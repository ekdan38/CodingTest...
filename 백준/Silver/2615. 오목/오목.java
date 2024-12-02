import java.io.*;
import java.util.*;

/**
 * 2615 오목
 * 입력:
 *      1. 각 줄마다 19 x 19 의 한 줄씩 흑돌 1, 흰돌 2, 빈 공간 0
 *문제 분석:
 *      1. 8개 방향으로 탐색해야한다. 같은 색상의 바둑알이 연속 5개 나오면 성공, 6개면 실패, 맨 왼쪽 위치 출력
 *      2. 맨 왼쪽 위치 출력해줘야한다.... 4방향으로 탐색하자 탐색하는데 이전 위치가 지금 색상이 아니고 19 x 19배열 
 *      이내이고, 다음 위치가 같은 색이라면 탐색 지속
 * 출력:
 *      1. 성공이면 색상, 위치 출력
 *      2. 실패면 0
 */

public class Main {
    static int[] dx = {-1, 0, 1, 1};
    static int[] dy = {1, 1, 1, 0};
    static int [][]field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        field = new int[19][19];
        for(int i = 0; i < 19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean hasAnswer = false;

        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(field[i][j] == 1 || field[i][j] == 2){
                    if(search(i, j)){
                        sb.append(field[i][j]).append("\n")
                                .append(i + 1).append(" ").append(j + 1);
                        hasAnswer = true;
                    }
                }
            }
        }
        if(!hasAnswer){
            sb.append(0);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static boolean search(int x, int y){
        int color = field[x][y];

        for(int i = 0; i < 4; i++){
            int cnt = 1;
            // 4개 방향으로 이동
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            // -> 로 이동한다고 가정해보자.
            // 항상 바둑돌의 맨 왼쪽에서 탐색 해야한다. 뒤에 같은 돌이 있으면 안된다.
            int prevX = x - dx[i];
            int prevY = y - dy[i];
            // 시작점 돌이 앞에 있는 돌과 같으면 탐색 의미가 없음
            if(prevX >= 0 && prevX < 19 && prevY >= 0 && prevY <19 && field[prevX][prevY] == color)continue;
            // 배열 벗어나지 않고, 다음 위치가 같은 색상이면 진행
            while(nextX >= 0 && nextX < 19 && nextY >= 0 && nextY <19 && field[nextX][nextY] == color){
                //바로 증가 시켜줘야한다.
                cnt++;
                //6개 이상이면 실패
                if(cnt > 5)break;
                //같은 방향으로 탐색
                nextX += dx[i];
                nextY += dy[i];
            }
            if(cnt == 5)return true;
        }

        return false;
    }
}