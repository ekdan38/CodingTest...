import java.io.*;
import java.util.*;

/**
 * 3187 양치기 꿍
 * 입력:
 *      1. 첫 번째 줄에는 각각 영역의 세로와 가로의 길이를 나타내는 두 개의 정수 R, C (3 ≤ R, C ≤ 250)가 주어진다.
 *      2. 다음 각 R줄에는 C개의 문자가 주어진다.
 *      3. 빈 공간 : '.'
 *      울타리 : '#'
 *      늑대 : 'v'
 *      양 : 'k'
 * 로직:
 *      1. 울타리로 막히면 해당 영역에 늑대 >= 양 이면 양 전멸
 *      2. 반대의 경우 늑대가 전멸
 *      3. 울타리로 막히지 않는 영역에는 양과 늑대가 없다. => 울타리가 막힌 영역만 계산 하자
 *      4. v, k 이면 bfs 수행. 다만 탐색 했던 구역이면 제외. => 탐색시에 탐색했던 구역 저장 필요
 * 출력:
 *       1. 살아남게 되는 양과 늑대의 수를 각각 순서대로 출력한다.
 */

public class Main {
    public static int R;
    public static int C;
    //입력값으로 배열 생성
    public static char[][] arr;
    //방문 했거나 울타리면 저장해줄 배열
    public static boolean[][] visited;
    //좌우 탐색
    public static int[] dx = {0, 0, -1, 1};
    //상하 탐색
    public static int[] dy = {-1, 1, 0, 0};

    public static int wolf = 0;
    public static int sheep = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == '#'){
                    visited[i][j] = true;
                }
            }
        }

        int totalWolf = 0;
        int totalSheep = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] != '#' && !visited[i][j]){
                    dfs(i, j);
                    if(wolf >= sheep){
                        totalWolf += wolf;
                    }
                    else{
                        totalSheep += sheep;
                    }
                    wolf = 0;
                    sheep = 0;
                }
            }
        }

        bw.write(totalSheep + " " + totalWolf);
        bw.flush();
        bw.close();
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;

        if(arr[x][y] == 'k'){
            sheep++;
        }
        if(arr[x][y] == 'v'){
            wolf++;
        }

        for(int i = 0; i < 4; i++){
            int di = x + dx[i];
            int dj = y + dy[i];
            //다음 탐색할 구역이 울타리가 아니거나 탐색 하지 않았어야한다.
            if((di >= 0 && di < R) && (dj >= 0 && dj < C) && !visited[di][dj]){
                dfs(di, dj);
            }
        }
    }


}