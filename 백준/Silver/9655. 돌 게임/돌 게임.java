import java.io.*;
import java.util.*;

/**
 * 9655 돌 게임
 *
 * 입력:
 *      1. 첫째 줄 k (1 ~ 1000)
 *
 * 문제 분석:
 *      N 이 주어지고 돌을 번갈아가면서 1, 3개 가져갈 수 있다.
 *      마지막에 돌을 가져가는 사람이 게임 승리
 *      상근이가 항상 먼저 시작 상근이가 이기면 SK, 창영이가 이기면 CY 출력
 *
 * 출력
 *      상근이가 항상 먼저 시작 상근이가 이기면 SK, 창영이가 이기면 CY 출력
 * */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        //1개 상근이, 2개 찬영이 3개 상근이, 4개 찬영이 5개 상근이 
        if(N % 2 == 0) bw.write("CY");
        else bw.write("SK");
        
        bw.flush();
        br.close();
        bw.close();
    }


}