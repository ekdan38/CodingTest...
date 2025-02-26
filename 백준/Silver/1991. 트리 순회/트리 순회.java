import java.io.*;
import java.sql.Array;
import java.util.*;

/**
 * 1991 트리 순회
 *
 * 입력:
 *      1. 첫째 줄 이진 트리 노드 개수 N (1 ~ 26)
 *      2. 둘째 줄 각 노드와 왼쪽 자식 노드, 오른쪽 자식 노드 (A가 항상 루트, 자식 노드 없으면 .)
 *
 * 문제 분석:
 *      1. 이진 트리 완성 하고, 전위, 중위, 후위 순위 구하면 된다.
 *
 * 출력:
 *      1.
 * */

public class Main {
    static StringBuilder result = new StringBuilder();
    static int[][] binaryTree = new int[26][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 노드는 A ~ Z 배열로 해결 가능
        // Node 값이 65 ~ 90 => -'A' 로 index 값 활용 가능
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            String left = st.nextToken();
            String right = st.nextToken();

            // . 이면 -1 저장
            if(left.equals(".")) binaryTree[node][0] = -1;
            else binaryTree[node][0] = left.charAt(0) - 'A';

            if(right.equals(".")) binaryTree[node][1] = -1;
            else binaryTree[node][1] = right.charAt(0) - 'A';
        }

        preOrder(0);
        result.append("\n");
        inOrder(0);
        result.append("\n");
        postOrder(0);
        result.append("\n");
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void preOrder(int current){
        if(current == -1) return;
        result.append((char) (current + 'A'));
        preOrder(binaryTree[current][0]);
        preOrder(binaryTree[current][1]);
    }

    static void inOrder(int current){
        if(current == -1) return;
        inOrder(binaryTree[current][0]);
        result.append((char) (current + 'A'));
        inOrder(binaryTree[current][1]);
    }

    static void postOrder(int current){
        if(current == -1) return;
        postOrder(binaryTree[current][0]);
        postOrder(binaryTree[current][1]);
        result.append((char) (current + 'A'));
    }
}
