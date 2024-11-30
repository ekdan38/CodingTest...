import java.io.*;
import java.util.*;

/**
 * 입력:
 *      1. 첫째 줄에 해결 한 문제의 수 P, 입학년도 Y, 성씨 S
 *      2. 둘째 줄 셋째 줄에는 두 팀원의 정보 PYS, 세번째 팀원의 정보 PYS 동일하게 주어짐
 *      2.  둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. (50 이하)
 *문제 분석:
 *      1. 가이드라인에 따라 팀 이름을 지어야 한다.
 *      2. 세 참가자의 Y % 100 를 오름차순 정렬해서 이어 붙임
 *      3. 세 참가자중 S의 첫 글자를 백준 온라인 저지에서 해결한 문제가 가장 많은 사람부터 차례로 이어붙임
 * 출력:
 *      1. 두가지 방법 각각 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Character> map = new TreeMap<>((a, b) -> b - a);
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char S = st.nextToken().charAt(0);
            arr[i] = y % 100;
            map.put(P, S);
        }

        Arrays.sort(arr);
        for (int i : arr) {
            sb.append(i);
        }
        sb.append("\n");
        for (Character value : map.values()) {
            sb.append(value);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}