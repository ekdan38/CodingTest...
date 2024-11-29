import java.io.*;
import java.util.*;

/**
 * 2210 숫자판 펌프
 * 입력:
 *          1. 5개의 줄에 5개의 정수가 주어진다. (0 ~ 9)
 * 로직:
 *          1. DFS탐색(5번), 상하좌우로, 한 번 거쳤던 칸을 다시 거쳐도 되기때문에 모든 경우의 수 탐색
 *          2. 다만 결과값은 중복되면 안된다. Set으로 중복값 제거
 *          3. 탐색시에 5x5 배열을 벗어나면 안된다.
 * 출력:
 *          1. set의 size 출력해주면 된다.
 */

public class Main {
    //5x5 배열 생성
    public static int[][] arr = new int[5][5];
    //좌우 이동
    public static int[] dx = {0, 0, -1, 1};
    //상하 이동
    public static int[] dy = {-1, 1, 0, 0};
    //결과 중복값 제거에 사용할 set
    public static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, null);
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y, int depth, String num) {
        //5회만 탐색 해야한다
        if (depth > 5){
            set.add(num);
            return;
        }
        num += arr[x][y];

        //4방향으로 보내자
        for(int i = 0; i < 4; i++){
            int di = x + dx[i];
            int dj = y + dy[i];

            //배열 벗어나면 안된다.
            if(di >= 0 && di < 5 && dj >= 0 && dj < 5){
                dfs(di, dj, depth + 1, num);
            }
        }


    }

}