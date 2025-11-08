import java.util.*;
import java.io.*;
public class Main{
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        // union-find...
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        while(m --> 0){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0){
                union(a, b);
            }
            else if(command == 1){
                if(find(a) == find(b)) sb.append("yes");
                else sb.append("no");
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void union(int a, int b){
        int A = find(a);
        int B = find(b);
        if(A != B) parent[B] = A;
    }
    static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
}
