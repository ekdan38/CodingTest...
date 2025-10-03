import java.util.*;
import java.io.*;
public class Main{
    static int[] parents;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Union - Find
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        for(int i = 0; i <= N; i++){
            parents[i] = i;
        }

        StringTokenizer st;

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 1) union(i, j);
            }
        }

        List<Integer> plans = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(M --> 0){
            plans.add(Integer.parseInt(st.nextToken()));
        }

        boolean result = possible(plans);
        bw.write(result ? "YES" : "NO");
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

    static boolean possible(List<Integer> plans){
        int root = find(plans.get(0));
        for(int n : plans){
            if(find(n) != root) return false;
        }
        return true;
    }
}
