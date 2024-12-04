import java.io.*;
import java.util.*;

/**
 * 17609 회문
 * 입력:
 *      1. 문자열의 개수 T (1 ~ 30), T 만큼 문자열
 *
 *문제 분석:
 *      1. 회문인지, 문자 1개 제거해서 유사회문이 되는지, 아무것도 아닌지 판별..
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
            if(palindrome(original)) result.append(0).append("\n");
            else if (pseudoPalindrome(original)) result.append(1).append("\n");
            else result.append(2).append("\n");
        }
        //summuus

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static boolean palindrome(String original){
        StringBuilder reverse = new StringBuilder(original).reverse();
        return original.equals(reverse.toString());
    }

    static boolean pseudoPalindrome(String original){
        StringBuilder sb1 = new StringBuilder(original);
        StringBuilder sb2 = new StringBuilder(original);

        char[] arr = original.toCharArray();
        for(int i = 0; i < arr.length / 2 + 1; i++){
            if(arr[i] != arr[(arr.length -1) - i]){
                sb1.deleteCharAt(i);
                sb2.deleteCharAt((arr.length - 1) -i);
                if(palindrome(sb1.toString())) {
                    return true;
                }
                if(palindrome(sb2.toString())) return true;

                break;
            }
        }
        return false;
    }


}