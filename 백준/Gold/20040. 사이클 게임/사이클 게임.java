import java.util.*;
import java.io.*;
public class Main{
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        for(int i = 0; i < N; i++){
            parents[i] = i;
        }

        int result = 0;
        boolean end = false;
        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result++;
            if(find(a) == find(b)) {
                end = true;
                break;
            }
            else{
                union(a, b);
            }
        }
        bw.write(end ? String.valueOf(result) : "0");
        bw.flush();
    }
    static void union(int a, int b){
        int A = find(a);
        int B = find(b);
        if(A != B) parents[B] = A;
    }
    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}