import java.io.*;
import java.util.*;
/**
 * 2504 괄호의 값
 *
 * 입력:
 *      1. 찻쩨 즐에 괄호열을 나타내는 문자열이 주어진다. (길이 : 1 ~ 30)
 *
 * 문제 분석:
 *      1. 4개의 기호 ‘(’, ‘)’, ‘[’, ‘]’를 이용해서 만들어지는 괄호열 중에서 올바른 괄호열 구해야함
 *      2.
 * 출력:
 *      1.
 *
 * */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] strArr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int midResult = 1;
        boolean isWrong = false;
        for(int i = 0; i < strArr.length; i++){
            char c = strArr[i];
            if(c == '('){
                stack.push(c);
                midResult *= 2;
            }
            else if(c == '['){
                stack.push(c);
                midResult *= 3;
            }
            else if(c == ')'){
                // 잘못된 괄호열
                if(stack.isEmpty() || stack.peek() != '(') {
                    isWrong = true;
                    break;
                }
                if(strArr[i - 1] == '(') result += midResult;
                stack.pop();
                midResult /= 2;
            }
            else if(c == ']'){
                // 잘못된 괄호열
                if(stack.isEmpty() || stack.peek() != '[') {
                    isWrong = true;
                    break;
                }
                if(strArr[i - 1] == '[') result += midResult;
                stack.pop();
                midResult /= 3;
            }
        }

        if(isWrong || !stack.isEmpty()) bw.write(Integer.toString(0));
        else bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
