import java.io.*;
import java.util.*;

/**
 * 1620 나는야 포켓몬 마스터 이다솜
 *
 * 입력:
 *      1. 첫째 줄에 N과 M (1 ~ 100,000)
 *      2. 둘째줄 부터 N개의 포켓몬 입력
 *      3. 이후 M 만큼 문제가 주어진다.
 *      => 숫자면 해당하는 포켓몬의 이름, 문자면 해당하는 포멧몬의 숫자
 *문제 분석:
 *      1. List 로 값 저장하고 출력 시키자. 최대 100,000개라 큰 문제 없다.
 *  출력:
 *      1. 숫자면 해당하는 포켓몬의 이름, 문자면 해당하는 포멧몬의 숫자
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> stringMap = new HashMap<>();
        HashMap<String, Integer> integerMap = new HashMap<>();
        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            stringMap.put(i, str);
            integerMap.put(str, i);
        }

        // 첫글자 대문자? 아스키 코드로 찾자
        for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(str.charAt(0) >= 65) result.append(integerMap.get(str)).append("\n");
            else result.append(stringMap.get(Integer.parseInt(str))).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}