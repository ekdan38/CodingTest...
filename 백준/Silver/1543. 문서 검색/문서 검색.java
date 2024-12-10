import java.io.*;
import java.util.*;

/**
 * 1543 문서검색
 *
 * 입력:
 *      1. 첫째 줄 문서가 주어진다. (1 ~ 2500)
 *      2. 둘째 줄 검색하고 싶은 단어가 주어진다. (1 ~ 50)
 *      => 소문자, 공백
 *
 *문제 분석:
 *      1. 단어가 문서에서 몇 번 등장하는지
 *      => subString으로 index ~ index + 단어길이 만큼 잘라서 word랑 같은지 확인
 *
 *
 *  출력:
 *      1. 단어가 문서에 중복되지 않고 최대 몇번 등장하는지 출력

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String document = br.readLine();
        char[] arr = document.toCharArray();
        String word = br.readLine();

        int cnt = 0;
        int index = 0;
        for(int i = 0; i <= document.length() - word.length();){
            if(document.substring(i, i + word.length()).equals(word)){
                i += word.length();
                cnt++;
            }
            else i ++;
        }

        System.out.print(cnt);

        bw.flush();
        br.close();
        bw.close();
    }
}