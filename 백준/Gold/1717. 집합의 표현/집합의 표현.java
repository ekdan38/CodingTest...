import java.io.*;
import java.util.*;

/**
 * 1717 집합의 표현
 *
 * 입력:
 *      1. 첫째줄 n, m 이 주어진다. m은 연산의 개수, m 개의 줄에 각각 연산
 *      2. 0 a b => a 가 포함된 집합과 b 과 포함된 집합을 합친다.
 *      3. 1 a b => a 와 b가 같은 집합에 포함되어 있는지 확인
 *
 * 문제 분석:
 *      1. UnionFind 문제 
 *
 * 출력
 *      1. 1로 시작하는 입력에 대해서 yes or no
 */

public class Main {
    static int [] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb= new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        // 배열 초기화
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
       
            if(command == 0) union(a, b);
            else{
                if(check(a, b)) sb.append("yes").append("\n");
                else sb.append("no").append("\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static void union(int a , int b){
        // a, b 합치는 연산
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
    
    static boolean check(int a, int b){
        return find(a) == find(b);
    }
}