import java.io.*;
import java.util.*;

/**
 * 1541 잃어버린 괄호
 * 입력:
 *      1. 첫째 줄에 식이 주어진다.
 *      식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있다.
 *      가장 처음과 마지막 문자는 숫자이다.
 *      => 처음 숫자는 무조건 양수
 *      연속해서 두 개 이상의 연산자 xx
 *
 *문제 분석:
 *      1. 괄호를 치면서 식을 최소로 만들어라...
 *      2. + 연산을 먼저 다 해주고 - 연산을 하면 최소값
 * 출력:
 *      1. 최소값 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        // -로 split => + 연산 끼리 분류
        String[] splitByMinus = str.split("[-]");

        // +로 split => + 연산 다해주고 다시 splitByMinus에 넣는다.
        for(int i = 0; i < splitByMinus.length; i++){
            String[] splitByPlus = splitByMinus[i].split("[+]");
            int sum = 0;
            for(int j = 0; j < splitByPlus.length; j++){
                sum += Integer.parseInt(splitByPlus[j]);
            }
            splitByMinus[i] = String.valueOf(sum);
        }

        // 연산 결과에서 각각 index 값 빼주면 됨-
        // 다만, 첫번째는 양수이다..수동으로 넣어주자
        int result = Integer.parseInt(splitByMinus[0]);
        
        for(int i = 1; i< splitByMinus.length; i++){
            result -= Integer.parseInt(splitByMinus[i]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

}