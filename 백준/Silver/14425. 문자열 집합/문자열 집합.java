import java.io.*;
import java.util.*;

/**
 * 14425 문자열 집합
 *
 * 입력:
 *      1. 첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.
 *      2. 다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
 *      3. 다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
 *      => 소문자로만 이루어져있다.
 * 문제 분석:
 *      1. N 개 만큼 주어지는 집합에 M 개 만큼 주어지는 문자열이 몇개나 포함되어 있는가?
 * 출력:
 *      1. N 개 만큼 주어지는 집합에 M 개 만큼 주어지는 문자열이 몇개나 포함되어 있는가?
 *
 * */

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < N; i++){
                map.put(br.readLine(), 0);
            }

            int cnt = 0 ;
            for(int i = 0; i < M; i++){
                if(map.containsKey(br.readLine())) cnt++;
            }

            bw.write(Integer.toString(cnt));
            bw.flush();
            br.close();
            bw.close();
        }

    }