import java.io.*;
import java.util.*;

/**
 * 1343 폴리오미노
 *
 * 입력:
 *      1. 첫째 줄 보드판 이 주어진다. 최대 50
 *
 * 문제 분석:
 *      1. 폴리오미노 AAAA, BB를 무한개 자기고 있다.
 *      2. ., X 로 이루어진 보드판이 주어졌을 때 X를 모두 폴리오미노로 덮으려 한다.
 *      => XXXX -> AAAA, XX.XX -> BB.BB
 *      => 이런식으로 덮을 수 있으면 되는데 사전순으로 결과를 얻어야 한다. 즉 AAAA먼저
 *      3. 덮을 수 없으면 - 1 출력
 *
 * 출력
 *
 * */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String board = br.readLine();

        // 그냥 단순하게 접근해보자
        while (board.contains("XXXX")){
            board = board.replace("XXXX", "AAAA");
        }
        while (board.contains("XX")){
            board = board.replace("XX", "BB");
        }

        // 마지막에 "X" 남아있으면  - 1
        if(board.contains("X")) board = "-1";


        bw.write(board);
        bw.flush();
        br.close();
        bw.close();
    }
}