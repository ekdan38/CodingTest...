import java.io.*;
import java.util.*;

/**
 * 1958 LCS3
 * 입력:
 *      1. 3줄로 문자열 주어짐
 *
 *문제 분석:
 *      1. LCS 문제 3개의 LCS 길이 구해라
 * 출력:
 *      1. LCS 길이
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int [][][] dp = new int[A.length() + 1][B.length() + 1][C.length() + 1];
        for(int i = 1; i <= A.length(); i++){
            for(int j = 1; j <= B.length(); j++){
                for(int k = 1; k <= C.length(); k++){
                    if(A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1)){
                        //같은면 왼쪽 상단 값
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    }
                    else{
                        //아니면 세개 값중 가장 큰 값 
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]) ,dp[i][j][k - 1]);
                    }
                }
            }
        }

        bw.write(String.valueOf(dp[A.length()][B.length()][C.length()]));
        bw.flush();
        br.close();
        bw.close();
    }


}