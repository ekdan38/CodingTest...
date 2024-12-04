import java.io.*;
import java.util.*;

/**
 * 12904 A와 B
 *
 * 입력:
 *      1. 첫째 줄에 S가 둘째 줄에 T가 주어진다.
 *      (1 ≤ S의 길이 ≤ 999, 2 ≤ T의 길이 ≤ 1000, S의 길이 < T의 길이)
 *
 *문제 분석:
 *      1. 문자열 뒤에 A 추가, 문자열 뒤집고 B 추가 가능
 *      2. T가 A로 끝나면 A를 추가 했다는 뜻, T가 B로 끝나면 뒤집고 B를 추가 했다는 뜻이다.
 *      => T가 A로 끝나면 A 빼고, T가 B로 끝나면 B빼고 뒤집으면서 T와 같아지면 성공
 *      => T.length - S.length 만큼 동작하면서..!
 *
 * 출력:
 *      1. S를 T로 바꿀 수 있으면 1 불가능하면 0
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());
        
        int cnt = T.length() - S.length();

        for(int i = 0 ; i < cnt; i++){
            // 마지막 글자가 A면 A지워준다.
            if(T.charAt(T.length() - 1) == 'A'){
                T.deleteCharAt(T.length() - 1);
            }
            else{
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }

        if (S.toString().equals(T.toString())){
            bw.write(String.valueOf(1));
        }
        else bw.write(String.valueOf(0));
        // 문자열에 A 추가

        // 문자열 뒤집고 B 추가

        bw.flush();
        br.close();
        bw.close();
    }


}