import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 6550 부분 문자열
 *
 * 입력:
 *      1. 여러개의 테스트 케이스가 주어진다. 각각 항목은 빈칸을 두고 주어진다. => EOF
 *
 * 문제 분석:
 *      1. 각 테스트 케이스의 문자열 순서대로 S ,T 가 있다. S 가 T의 부분 문자열이면 YSE, 아니면 NO
 *      => S의 index 값 0으로 초기화 시키고, for문 돌리면서 T 랑 같으면 index 증가
 * 출력:
 *      1. 각 테스트 케이스 결과값 출력
 *
 * */

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder result = new StringBuilder();
            String str;
            while((str = br.readLine())!=null){
                String[] split = str.split(" ");
                String S = split[0];
                String T = split[1];
                int idx = 0;
                for(int i = 0; i < T.length(); i++){
                    if(S.charAt(idx) == T.charAt(i)) idx++;
                    // S의 길이 고려 해야한다. 안해주면 idx가 범위 벗어남
                    if(idx == S.length()) break;
                }
                if(idx == S.length()) result.append("Yes").append("\n");
                else result.append("No").append("\n");
            }

            bw.write(result.toString());
            bw.flush();
            br.close();
            bw.close();
        }

    }