import java.util.*;
import java.io.*;
public class Main{
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] inDegree;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            inDegree[B]++;
        }
        String result = topologicalSort();
        bw.write(result);
        bw.flush();
    }
    static String topologicalSort(){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            sb.append(current).append(" ");
            for(int n : graph.get(current)){
                inDegree[n]--;
                if(inDegree[n] == 0) queue.offer(n);
            }
        }
        return sb.toString();
    }
}
