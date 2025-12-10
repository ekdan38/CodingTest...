import java.util.*;
import java.io.*;
public class Main{
    static int[][] map;
    static int[][] islandMap;
    static boolean[][] visited;
    static List<List<int[]>> edges = new ArrayList<>();
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        islandMap = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        List<int[]> searchList = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) searchList.add(new int[]{i, j});
            }
        }

        int islandNum = 1;
        for(int[] s : searchList){
            int x = s[0];
            int y = s[1];
            if(!visited[x][y]) {
                edges.add(new ArrayList<>());
                findEdges(x, y, islandNum);
                islandNum++;
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < islandNum - 1; i++){
            for(int[] e : edges.get(i)){
                visited = new boolean[N + 1][N + 1];
                result = Math.min(findBridge(e[0], e[1], i + 1), result);
            }
        }

        System.out.print(result);

    }
    static void findEdges(int x, int y, int islandNum){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        islandMap[x][y] = islandNum;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];

            boolean isEdge = false;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    islandMap[nx][ny] = islandNum;
                }
                if(map[nx][ny] == 0) isEdge = true;
            }
            if(isEdge) edges.get(islandNum - 1).add(new int[]{cx, cy});
        }
    }

    static int findBridge(int x, int y, int islandNum){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] currents = queue.poll();
            int cx = currents[0];
            int cy = currents[1];
            int cd = currents[2];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    queue.offer(new int[]{nx, ny, cd + 1});
                    visited[nx][ny] = true;
                }
                if(map[nx][ny] != 0 && islandMap[nx][ny] != islandNum){
                    return cd;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}