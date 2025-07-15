/**
 *  입력 :
 *          첫째 줄 테스트 케이스 수 T
 *          케이스마다, 총 연산 수 k
 *          이후 D OR I 가 주어지고 숫자가 주어진다.
 *          I 숫자: Q에 삽입 (동일 값 가능)
 *          D 숫자: Q에서 최대값 삭제
 *          D -1 : Q에서 최솟값 삭제
 *          (최대값, 최소값 삭제시 2개이사 있으면 한개만 삭제)
 *          (Q가 비어잇는데 D라면 무시)
 *  출력 :
 *          각 테스트 케이스에 대해서 Q에 남아있는 최댓값, 최솟값 출력 공백 두고
 *          Q가 비어있으면 "EMPTY"
 *
 *  문제 분석 :
 *          (풀이 1)
 *          최대힙, 최소힙 갖는 우선순위 큐 2개 만들고 초기 size를 k 만큼 따로 변수에 저장
 *          이후 d,i 연산마다 저장해둔 변수에서 size 조정
 *          이후 최대힙, 최소힙에서 출력
 *          => 실패 특정 경우 양 큐 적합성 안맞음
 *
 *          (풀이 2)
 *          TreeMap 사용하고, 중복되는 수 value로 처리해주고
 *          firstKey, lastKey 삭제 처리
 *
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for(int j = 0; j < k; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(command.equals("I")) treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
                else{
                    if(!treeMap.isEmpty()){
                        int key = (n == -1) ? treeMap.firstKey() : treeMap.lastKey();
                        int value = treeMap.get(key);
                        if(value > 1) treeMap.put(key, value - 1);
                        else treeMap.remove(key);
                    }
                }
            }

            if(treeMap.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}