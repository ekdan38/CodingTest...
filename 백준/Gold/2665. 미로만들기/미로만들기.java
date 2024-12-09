import java.io.*;
import java.util.*;

/**
 * 2665 미로만들기
 *
 * 입력:
 *      1. 첫째 줄 방의 수 n (1 ~ 50)
 *      2. 이후 n개 줄에 0과 1로 이루어진 길이 n인 수열
 *      => 0: 검은 방, 1: 흰방
 *
 *문제 분석:
 *      1. n * n 바둑판 모양, 검은방, 흰방으로 되어있다.
 *      => 흰방은 이동 가능, 검은방은 불가
 *      => 최소한으로 검은방을 흰방으로 바꿔서 목적지에 도달해야한다.
 *      => 흰방 0, 검은방 1로 가중치 주고 다익스트라 사용
 *  출력:
 *      1. 최소한으로 검은 방을 흰방으로 바꾼 횟수 출력
 */

public class Main {
    static int [][] field;
    static int [][] dist;

    static int n;
    static int [] dx = {1, -1, 0 ,0};
    static int [] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        // index 1번부터 사용
        field = new int[n + 1][n + 1];
        dist = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            String input = br.readLine();
            for(int j = 1; j <= n; j++){
                field[i][j] = input.charAt(j - 1) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        bw.write(Integer.toString(dijkstra()));
        bw.flush();
        br.close();
        bw.close();
    }
    static int dijkstra(){
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        // 1,1 부터 시작 흰색이라 0
        dist[1][1] = 0;
        queue.offer(new Edge(1, 1, 0));

        while (!queue.isEmpty()){
            Edge current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int currentWeight = current.weight;

            if(currentWeight > dist[currentX][currentY]) continue;

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                // 배열 경계 검사
                if(nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= n){
                    int nextWeight = 0;
                    nextWeight += currentWeight;
                    // 다음 탐색 대상이 검은색이면 1증가 
                    if(field[nextX][nextY] == 0) nextWeight++;
                    
                    if(nextWeight < dist[nextX][nextY]) {
                        dist[nextX][nextY] = nextWeight;
                        queue.offer(new Edge(nextX, nextY, nextWeight));
                    }

                }
            }
        }
        // 목적지는 n,n이다. 
        return dist[n][n];

    }
    static class Edge {
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}