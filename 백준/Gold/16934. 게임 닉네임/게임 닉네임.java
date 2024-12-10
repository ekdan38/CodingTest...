import java.io.*;
import java.util.*;

/**
 * 16934 게임 닉네임
 *
 * 입력:
 *      1. 첫째 줄 가입한 유저의 수 N (1 ~ 100,000)
 *      2. 둘째 줄부터 N개의 줄에는 유저의 닉네임이 가입한 순서대로 주어진다.(소문자, 1 ~ 10)
 *      => 닉네임 중복 가능
 *문제 분석:
 *      1. 닉네임으로 별칭을 만든다. => 최소 길이로
 *      2. 별칭은 접두사중에서 가장 길이가 짧은 것 사용, 다만, 이전에 가입한 닉네임의 접두사가 아니어야한다.
 *      => set이랑 map사용해서 set으로 중복값 제거하면서 접두사들 관리
 *      => map으로 최대길이 접두사 카운팅 추후에 번호 붙여야함 2부터
 *
 *  출력: 
 *      1. 유저 가입 순서대로 별칭을 한 줄에 하나씩 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String name = br.readLine();
            // 접두사 인데 나온적 없는 접두사인지 확인
            boolean isFirst = false;
            for(int j = 0; j < name.length(); j++){

                String substring = name.substring(0, j + 1);
                // 접두사가 set에 없고, 처음나온 녀석이면 결과에 추가
                if(!set.contains(substring) && !isFirst){
                    result.append(substring).append("\n");
                    isFirst = true;
                }
                // 어쨋든 모든 subString값은 set에 넣어줘야함
                set.add(substring);
            }

            // 입력값이랑 똑같으면, 즉 접두사의 길이가 최장길이면 무조건 카운팅 해줘야 한다. map에 넣자
            // 위에 if문 못거치고 결과값 출력 못하면 글자 자체가 접두사이다.
            map.put(name, map.getOrDefault(name, 0) + 1);
            // 글자 자체를 출력해줘야 하는데 2부터 뒤에 붙음
            if(map.get(name) > 1) result.append(name + map.get(name)).append("\n");
            else if(!isFirst) result.append(name).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}