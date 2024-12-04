import java.io.*;
import java.util.*;

/**
 * 17609 회문
 * 입력:
 *      1. 문자열의 개수 T (1 ~ 30), T 만큼 문자열
 *
 *문제 분석:
 *      1. 회문인지, 문자 1개 제거해서 유사회문이 되는지, 아무것도 아닌지 판별..
 *      회문 => StringBuilder.reverse()
 *      유사 회문 => 시작, 끝 가운데로 들어가면서 탐색, 다르면 각각 index값 삭제해보고 2개중 1개가 회문인지 검사
 * 출력:
 *      1. 회문 => 0, 유사회문 => 1, 둘다 아니면 => 2
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i++){
            String original = br.readLine();
            // 회문
            if(palindrome(original)) result.append(0).append("\n");
            // 유사 회문
            else if (pseudoPalindrome(original)) result.append(1).append("\n");
            // 아무것도 아님
            else result.append(2).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    // 회문 검사
    static boolean palindrome(String original){
        StringBuilder reverse = new StringBuilder(original).reverse();
        return original.equals(reverse.toString());
    }

    // 유사 회문 검사
    static boolean pseudoPalindrome(String original){
        StringBuilder sb1 = new StringBuilder(original);
        StringBuilder sb2 = new StringBuilder(original);

        // 맨 앞, 맨 뒤 값을 가운데로 들어가면서 같은지 검사
        // 다르면
        // 1. 앞에 값 지우고 회문 검사
        // 2. 뒤에 값 지우고 회문 검사
        // => 둘중 하나라도 true이면 유사 회문임
        for(int i = 0; i < original.length() / 2 + 1; i++){
            if(original.charAt(i) != original.charAt((original.length() -1) - i)){
                sb1.deleteCharAt(i);
                sb2.deleteCharAt((original.length() - 1) -i);
                if(palindrome(sb1.toString())) return true;
                if(palindrome(sb2.toString())) return true;
                // 회문 검사 2개 전부다 false가 나오면 유사 회문 아님 탐색 종료
                break;
            }
        }
        return false;
    }
}