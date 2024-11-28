import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 9375 패션왕 신해빈
         * 문제 분석:
         *          T의 범위 1 ~ 100
         *          n의 범위 0 ~ 30
         *          해빈이는 한번 입었던 의상 조합은 입지 않는다.
         *          같은 종류의 의상은 하나만 착용 가능
         *          해빈이의 의상이 주어졌을때 몇일 동안 옷을 입고 돌아다닐 수 있는가?
         * 의사 결정:
         *          한번 입었던 의상 조합은 입지 않는다..
         *          경우의 수를 따질 때 어떠한 종류의 의상이 값이 1개이상 존재해도
         *          해당 종류의 의상을 입지 않을때도 고려해야한다.
         *          따라서 (의상의 종류의 개수 + 1) * (다른 의상 종류의 개수 + 1) ... *
         *          을 해주고 의상을 아무것도 입지 않는 경우 1개를 빼주면 된다.
         *          HashMap으로 종류별로 정리하자
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            //HashMap 생성
            HashMap<String, Integer> map = new HashMap<>();
            //옷 종류별로 카운트
            for(int j = 0; j < n; j++){
                String clothe = br.readLine();
                String category = clothe.substring(clothe.indexOf(" ") + 1);
                //category별로 카운트, 이미 값이 존재한다면 + 1
                map.put(category, map.getOrDefault(category, 1) + 1);
            }
            
            int result = 1;
            //모든 경우의 수 구하기
            for (Integer value : map.values()) {
                result *= value;
            }
            //아무것도 입지 않았을 경우 빼주기
            sb.append(result - 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}