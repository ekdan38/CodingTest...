import java.io.*;
import java.util.*;

/**
 * 25178 두라무리 휴지
 * 입력:
 *      1. 첫째 줄에 N (2 ~ 100,000)
 *      2. 둘째 셋째 줄에 길이가 N이고 소문자로만 이루어진 2개의 문자열
 *
 *문제 분석:
 *      1. 3개의 조건을 만족해야함
 *      * 한 단어를 재배열해 다른 단어를 만들 수 있어야한다.
 *      * 두 단어의 첫 글자와 마지막 글자를 서로 동일 해야한다.
 *      * 각 단어에서 모음(a, e, i , o ,u)을 제거한 문자열은 동일해야 한다.
 *      2. 두 문자열이 조건을 만족하면 YES, 아니면 NO
 * 출력:
 *      1. YES OR NO
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        if(first(str1, str2) && second(str1, str2, N) && third(str1, str2, N)) bw.write("YES");

        else bw.write("NO");

        bw.flush();
        br.close();
        bw.close();
    }
    static boolean first(String str1, String str2){
        // 한 단어를 재배열해 다른 단어를 만들 수 있어야한다.
        // => 정렬해서 비교
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
    static boolean second(String str1, String str2, int N){
        // 두 단어의 첫 글자와 마지막 글자를 서로 동일 해야한다.
        return str1.charAt(0) == str2.charAt(0) && str1.charAt(N - 1) == str2.charAt(N - 1);
    }

    static boolean third(String str1, String str2, int N){
        // 각 단어에서 모음(a, e, i , o ,u)을 제거한 문자열은 동일해야 한다.
        String s1 = str1.replaceAll("[aeiou]", "");
        String s2 = str2.replaceAll("[aeiou]", "");
        return s1.equals(s2);
    }
}