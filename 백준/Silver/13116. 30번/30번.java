import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        /**
         * 13116 30번
         * 입력:
         *          1. 첫째줄 T(테스트 케이스 수) (1 ~ 50,000)
         *          2. 이후에 테스트 케이스가 주어진다. A, B (1 ~ 1023)
         * 로직:
         *          1. 1부터 1023까지의 수로 이루어진 완전 이진 트리 생성
         *          (배열로 생성하자), 다만 이미 입력값이 이진트리 구조기에 값 바로 넣어주자
         *          2. 테스트 케이스 받아서 A 와 B의 부모 노드가 같으면 된다.
         *          부모노드 값은 노드 값 / 2 이다.
         *          3. 우선 각각의 깊이를 구하고 두 노드의 깊이를 맞춰주자.
         *          4. 부모 노드로 이동하면서 값이 같아질때 멈추자
         * 출력:
         *          1. 부모노드 * 10
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //배열 생성
        int [] tree = new int[1023];
        for(int i = 0; i < tree.length; i++){
            tree[i] = i + 1;
        }


        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(search(A, B) * 10).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    public static int search(int A, int B) {
        int depthA = findDepth(A);
        int depthB = findDepth(B);

        //A > B이면 A의 부모 노드를 depthB - depthA만큼 찾아야한다.
        while(depthA > depthB){
            A /= 2;
            depthA --;
        }
        while(depthB > depthA){
            B /= 2;
            depthB --;
        }
        //이제 양쪽 depth가 같아짐

        while (A != B) {
            A /= 2;
            B /= 2;
        }
        //A와 B중 아무거나 return 해주면 된다.
        return A;
    }

    //깊이 구하기
    public static int findDepth(int num){
        //둘다 깊이를 알아야 한다. => 노드값 / 2 반복
        int depth = 0;
        while(num /2 > 0){
            num /= 2;
            depth++;
        }
        return depth;
    }
}