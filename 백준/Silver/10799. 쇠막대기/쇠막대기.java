import java.io.*;
import java.util.*;

/**
 * 10799 쇠막대기
 *
 * 입력:
 *      1. 한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다.
 *      => '()' 는 레이저, 쇠막대기는 '(' 시작 ')' 끝
 * 문제 분석:
 *      1. 자신 보다 긴 막대기 위에 놓일 수 있다.
 *      2. 레이저 적어도 1개 존재
 *      3. 레이저는 어느 쇠막대기 양 끝점하고 겹치지 않는다.
 *      => stack 이용, '(' 면 push, ')' 면 pop, 다만 pop 하고 나서 전 문자가 '(' 이면, 스택 사이즈만큼 더해준다.
 *      => pop 하고 나서 '(' 아니면? 1 더해줘보자
 *
 *
 * 출력:
 *
 * */

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            int result = 0;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c == '(') stack.push(c);
                else if (c == ')'){
                    stack.pop();
                    result = str.charAt(i - 1) == '(' ? result + stack.size() : result + 1;
                }
            }

            bw.write(Integer.toString(result));
            bw.flush();
            br.close();
            bw.close();
        }

    }
