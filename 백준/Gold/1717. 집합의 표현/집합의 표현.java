import java.util.*;
import java.io.*;
public class Main{
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 0 합집합
        // 1 교집합
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];

        // 배열 자기 자신으로 초기화
        for(int i = 0; i <= N ; i++){
            parents[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        while(M --> 0){
            st = new StringTokenizer(br.readLine());
            int commend = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 합집합
            if(commend == 0){
                union(a, b);
            }
            // 교집합
            else if(commend == 1){
                if(find(a) == find(b)) sb.append("YES");
                else sb.append("NO");
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
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