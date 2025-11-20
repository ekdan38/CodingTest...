import java.util.*;
import java.io.*;
public class Main{
    static char[][] moveMap, fireMap;
    static int R, C;
    static int[][] moveDist, fireDist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] fireVisited, moveVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        moveMap = new char[R + 1][C + 1];
        fireMap = new char[R + 1][C + 1];

        moveDist = new int[R + 1][C + 1];
        fireDist = new int[R + 1][C + 1];

        fireVisited = new boolean[R + 1][C + 1];
        moveVisited = new boolean[R + 1][C + 1];

        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> moveQueue = new LinkedList<>();

        for(int i = 1; i <= R; i++){
            Arrays.fill(fireDist[i], Integer.MAX_VALUE);
        }

        for(int i = 1; i <= R; i++){
            String input = br.readLine();
            for(int j = 1; j <= C; j++){
                char s = input.charAt(j - 1);
                if(s == 'J'){
                    moveQueue.offer(new int[]{i, j, 0});
                    fireDist[i][j] = 0;
                    fireVisited[i][j] = true;
                }
                else if(s == 'F'){
                    fireQueue.offer(new int[]{i, j, 0});
                    moveDist[i][j] = 0;
                    moveVisited[i][j] = true;
                }
                moveMap[i][j] = s;
                fireMap[i][j] = s;
            }
        }

        fireBfs(fireQueue);
        int result = moveBfs(moveQueue);

        if(result == -1) bw.write("IMPOSSIBLE");
        else bw.write(String.valueOf(result));
        bw.flush();
    }
    static void fireBfs(Queue<int[]> fireQueue){

        while(!fireQueue.isEmpty()){
            int[] currents = fireQueue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int cd = currents[2];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 1 && nx <= R && ny >= 1 && ny <= C){
                    if(fireMap[nx][ny] != '#' && !fireVisited[nx][ny]){
                        fireQueue.offer(new int[]{nx, ny, cd + 1});
                        fireVisited[nx][ny] = true;
                        fireDist[nx][ny] = cd + 1;
                    }
                }
            }
        }
    }

    static int moveBfs(Queue<int[]> moveQueue){
        while(!moveQueue.isEmpty()){
            int[] currents = moveQueue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int cd = currents[2];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || nx > R || ny < 1 || ny > C){
                    return cd + 1;
                }


                if(moveMap[nx][ny] != '#' && !moveVisited[nx][ny]) {
                    int nextTime = cd + 1;
                    if(fireDist[nx][ny] > nextTime){
                        moveVisited[nx][ny] = true;
                        moveDist[nx][ny] = nextTime;
                        moveQueue.offer(new int[]{nx, ny, nextTime});
                    }
                }
            }
        }
        return -1;
    }

}