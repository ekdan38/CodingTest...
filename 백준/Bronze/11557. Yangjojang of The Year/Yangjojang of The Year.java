import java.io.*;
import java.util.*;

/**
 * 11557 Yangjojang of The Year
 * 입력:
 *      1. 입력의 첫 줄에는 테스트 케이스의 숫자 T가 주어진다.
 *      2. 매 입력의 첫 줄에는 학교의 숫자 정수 N(1 ≤ N ≤ 100)이 주어진다.
 *      2. N줄에 걸쳐 학교이름 S(1 ~ 20, 공백 x, 대소문자 알파벳 문자열), 지난 해 소비한 술의 양L(0 ~ 10,000,000)
 *문제 분석:
 *      1. 테스트 케이스마다 N이 가장 많은 S를 구하면 된다.
 *      2. 스택 사용하자. L이 max가 될때마다 스택에 넣어주고 pop()해서 L이 가장 큰 S출력
 * 출력:
 *      1. 각 테스트 케이스마다 L소비가 가장 많은 S출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int max = 0;
            //stack 사용
            Stack<String> stack = new Stack<>();
            int N = Integer.parseInt(br.readLine());
            for(int j = 0; j < N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String S = st.nextToken();
                int L = Integer.parseInt(st.nextToken());
                //L이 max보다 클때마다 stack에 push
                if(L > max){
                    max = L;
                    stack.push(S);
                }
            }
            sb.append(stack.pop()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}