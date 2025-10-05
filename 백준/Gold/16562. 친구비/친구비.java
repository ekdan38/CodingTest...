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
        int K = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        int[] pee = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            pee[i] = Integer.parseInt(st.nextToken());
        }

        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int result = 0;
        int[] arr = new int[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);

        for(int i = 1; i <= N; i++){
            arr[find(parents[i])] = Math.min(arr[find(parents[i])], pee[i]);
        }

        for(int n : arr){
            if(n != Integer.MAX_VALUE) result += n;
        }

        bw.write(result > K ? "Oh no" : String.valueOf(result));
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