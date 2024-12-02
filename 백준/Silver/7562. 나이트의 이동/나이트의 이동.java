import java.io.*;
import java.util.*;

/**
 * 7562 나이트의 이동
 * 입력:
 *      1. 첫째 줄은 테스트 케이스의 개수
 *      2. 각 테스트 케이스는 세 줄로 이루어져있다.
 *      첫째 줄에는 한 변의 길이 l(4 ~ 300) 체스판의 크기는 lxl
 *      3. 둘째 줄에는 나이트가 있는 칸
 *      4. 셋째 줄에는 나이트가 이동하려고 한는 칸
 *문제 분석:
 *      1. 8개 방향으로 이동하면서 이동 하려고 하는 칸으로 최소 이동 횟수.
 *      2. bfs 사용, 8방향 이동, 깊이 깊어질 수록 cnt++;, 목표 위치랑 이동 위치랑 같아지면 종료
 *
 * 출력:
 *      1. 테스트 케이스마다  나이트 최소 이동 수
 */

public class Main {
    static int startX;
    static int startY;
    static int targetX;
    static int targetY;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
    static Queue<int[]> queue;

    static int l;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            //체스판 한 변 길이
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            //현재 칸
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            //목표 칸
            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            //체스판 방문
            visited = new boolean[l][l];
            //bfs에서 사용할 큐
            queue= new LinkedList<>();
            int bfsResult = bfs(startX, startY);
            if(bfsResult != -1){
                sb.append(bfsResult).append("\n");
            }
        }


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static int bfs(int startX, int startY){
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int cnt = 0;

        while(!queue.isEmpty()){
            //큐의 size만큼 돌아야한다. 즉 현재 레벨의 노드 수만큼 돌아야 한다.
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                //목표 도달하면 종료
                if(x == targetX && y == targetY){
                    return cnt;
                }

                //8개 방향으로 보내자
                for(int j = 0; j < 8; j++){
                    int di = x + dx[j];
                    int dj = y + dy[j];

                    //체스 판 범위 이내이고 방문 한적 없을때만 진행
                    if(di >= 0 && l > di && dj >= 0 && l > dj && !visited[di][dj]){
                        queue.add(new int[]{di, dj});
                        visited[di][dj] = true;
                    }
                }
            }
            //여기서 증가 시켜줘야 한다. 위치 헷갈리지 말자
            cnt++;
        }
        return -1;
    }

}
