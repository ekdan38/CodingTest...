import java.io.*;
import java.util.*;

public class Main {
    //재귀함수에서 사용해야한다 
    public static int K;
    public static int[] inputArr;
    //list에 list 선언해서 이진트리 구성해보자
    public static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        /**
         * 19638 센티와 마법의 뿅망치
         * 입력:
         *          첫째줄 K(1 ~ 10) => depth
         *          둘째줄 1 ~ (2^k - 1) => node 수
         *          입력 값은 중위트리 결과로 주어진다.
         * 로직:
         *          
         *          1.입력값으로 주어진 중위트리를 이진트리로 만든다.
         *          2 depth별로 트리의 노드를 출력해야한다.
         *          3.출력하기 쉽게 List로 나타내보자
         *          4.이진트리 구성.. 재귀함수
         * 출력:
         *          depth별로 트리의 노드를 출력하면 된다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //트리의 깊이
        K = Integer.parseInt(br.readLine());

        inputArr = new int[(int) Math.pow(2, K) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < inputArr.length; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        //이진트리 구성
        list = new ArrayList<>(K);
        for(int i = 0; i < K; i++){
            list.add(new ArrayList<>());
        }

        //입력값을 이진트리로 만들자
        makeTree(0, inputArr.length - 1, 0);
        
        //값 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++){
            for(int j = 0; j < list.get(i).size(); j++){
                sb.append(list.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void makeTree(int start, int end, int depth){
        //마지막 노드
        if(start > end)return;

        //입력값은 중위순회 결과가 주어진다.
        //상위 노드 추출하자
        int parentNode = (start + end) / 2;

        //상위 노드 값 넣어주자
        list.get(depth).add(inputArr[parentNode]);

        //왼쪽 서브트리
        makeTree(start, parentNode - 1, depth + 1);

        //오른쪽 서브트리
        makeTree(parentNode + 1, end, depth + 1);
    }

}