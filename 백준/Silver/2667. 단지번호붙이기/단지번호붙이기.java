/**
 * <문제 분석>
 *     1. 1이거나 visited == false 면 bfs 작동
 *     bfs 내부에서 각 단지의 수 기입
 *
 *     for i/-....
 *     for j....
 *     if[i][j] == 1 && ij == false; bfs
 *
 *
 *
 */
import org.w3c.dom.Node;

import java.io.*;
import java.util.*;
public class Main{
    static boolean[][] visited;
    static int[][] graph;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= N; j++){
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }


        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(graph[i][j] == 1 && !visited[i][j]) bfs(i, j);
            }
        }

        bw.write(list.size() + "\n");
        Collections.sort(list);
        for(int i : list){
            bw.write(i + "\n");
        }

        bw.flush();
    }
    static void bfs(int x, int y){
        int cnt = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            cnt++;
            for(int i = 0; i < 4; i++){
                int nX = current.x + dx[i];
                int nY = current.y + dy[i];

                if(nX >= 1 && nX <= N && nY >= 1&& nY <=N && graph[nX][nY] == 1 && !visited[nX][nY]){
                    queue.offer(new Node(nX, nY));
                    visited[nX][nY] = true;
                }
            }
        }
        if(cnt > 0) list.add(cnt);
    }
    
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}