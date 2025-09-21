import java.util.*;
import java.io.*;
public class Main{
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R;
    static int C;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        for(int i = 1; i <= R; i++){
            String input = br.readLine();
            for(int j = 1; j <= C; j++){
                map[i][j] = input.charAt(j - 1) == 'O' ? 2 : -1;
            }
        }
        int time = 1;

        while(time < N){
            time++;
            if(time % 2 == 0) plantBomb();
            else explodeBomb();
        }

        printMap();
        bw.write(sb.toString());
        bw.flush();
    }
    static void plantBomb(){
        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                if(map[i][j] != -1) map[i][j]--;
                if(map[i][j] == -1) map[i][j] = 3;
            }
        }
    }
    static void explodeBomb(){
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                if(map[i][j] != -1) map[i][j]--;
                if(map[i][j] == 0){
                    list.add(new int[]{i, j});
                }
            }
        }

        for(int[] target : list){
            int x = target[0];
            int y = target[1];

            map[x][y] = -1;
            for(int t = 0; t < 4; t++){
                int nextX = x + dx[t];
                int nextY = y + dy[t];
                if(nextX > 0 && nextX <= R && nextY > 0 && nextY <= C){
                    map[nextX][nextY] = -1;
                }
            }
        }
    }
    static void printMap(){
        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                if(map[i][j] == -1) sb.append(".");
                else sb.append("O");
            }
            sb.append("\n");
        }
    }
}