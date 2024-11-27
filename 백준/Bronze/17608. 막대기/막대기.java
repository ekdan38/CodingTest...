import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 17608 막대기
         * 문제 분석: 막대기 길이를 입력 받고 마지막 막대 길이보다 크거나 같은 경우를 구해주면 된다.
         * 의사 결정: 단순 for문으로 풀수도 있지만 스택으로 풀어보자.
         *           Array에 모든 값을 받고, 마지막 값을 스택에 먼저 넣어두자.
         *           이후 스택에 최상단 값보다 큰 값이 Array에 있다면 stack에 추가
         *           이렇게 하면 중복 제거도 바로 된다.
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        //입력값 마지막은 배열에 추가할 필요없다.
        //바로 스택에 넣어줄거다.
        int[] arr = new int[N - 1];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        stack.push(Integer.parseInt(br.readLine()));

        //스택에 넣은 순서 반대로 연산 해야한다.
        for(int i = arr.length - 1; i >= 0; i--){
            if(stack.peek() < arr[i])
                stack.push(arr[i]);
        }

        bw.write(String.valueOf(stack.size()));
        bw.flush();
        bw.close();
    }
}

