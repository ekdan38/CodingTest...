import java.io.*;
import java.util.*;

public class Main {
    static int n, num;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }
        answer = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            num = i;
            dfs(i);
            visited[i] = false;
        }

        Collections.sort(answer);
        bw.write(String.valueOf(answer.size()));
        bw.write("\n");
        for (Integer n : answer){
            bw.write(String.valueOf(n + 1));
            bw.write("\n");
        }

        bw.flush();
    }

    public static void dfs(int i){
        if(arr[i] == num)answer.add(num);

        if(!visited[arr[i]]){
            visited[arr[i]] = true;
            dfs(arr[i]);
            visited[arr[i]] = false;
        }
    }
}