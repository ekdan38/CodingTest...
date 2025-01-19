import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

/**
 * 21939 문제 추천 시스템 Version 1
 *
 * 입력:
 *      1.첫째 줄추천 문제 리스틍 있는 문제의 개수 N
 *      2.둘째 줄부터 N + 1 줄까지 문제 번호 P 와 난이도 L 이 주어진다.
 *      3. N + 2 줄은 입력될 명령문의 개수 M
 *      4. 그 다음줄부터 M개의 명령문
 * 문제 분석:
 *      1. 명령어
 *          1. recommend x
 *          => x == 1 이면,가장 어려운 문제 번호 출력
 *          => 가장 어려운 문제가 여러개면 문제 번호가 큰거 출력
 *          2. x == -1 이면, 가장 쉬운 문제 번호 출력
 *          => 가장 쉬운 문제가 여러개면 문제 번호가 작은것 출력
 *          2. add P L
 *          => 난이도가 L인 문제 번호 P 추가
 *          => 추천 문제 리스트에 없는 문제 번호 P 만 입력으로 주어진다.
 *          3. solved P
 *          => 추천 문제 리스트에서 문제 번호 P를 제거 한다.
 *          => 추천 문제 리스트에 있는 번호 P 만 입력으로 주어진다.
 *          
 *          => 2개 우선순위큐 시도 실패
 *          => treeSet 사용
 * 출력:
 *      1. 명령어 수행 결과값 줄 바꾸면서 출력
 *
 * */

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // treeSet
            // 정렬 조건 => L 내림차순, P 내림차순
            TreeSet<Problem> treeSet = new TreeSet<>((p1, p2) -> {
                if(p2.L.equals(p1.L)) return p2.P - p1.P;
                return p2.L - p1.L;
            });

            // remove 시 필요
            HashMap<Integer, Integer> map = new HashMap<>();

            StringBuilder result = new StringBuilder();
            int N = Integer.parseInt(br.readLine());

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(P, L);
                treeSet.add(problem);
                map.put(P, L);
            }
            int M = Integer.parseInt(br.readLine());
            for(int i = 0; i < M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if(command.equals("recommend")){
                    int x = Integer.parseInt(st.nextToken());
                    if(x == 1) {
                        Problem first = treeSet.first();
                        result.append(first.P).append("\n");
                    } else if (x == -1) {
                        Problem last = treeSet.last();
                        result.append(last.P).append("\n");
                    }
                }
                else if(command.equals("add")){
                    int P = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());
                    treeSet.add(new Problem(P, L));
                    map.put(P, L);
                }
                else if (command.equals("solved")) {
                    int P = Integer.parseInt(st.nextToken());
                    int L = map.get(P);
                    treeSet.remove(new Problem(P, L));
                }
            }


            bw.write(result.toString());
            bw.flush();
            br.close();
            bw.close();
        }

        static class Problem{
            Integer P;
            Integer L;

            public Problem(Integer p, Integer l) {
                P = p;
                L = l;
            }
        }
    }
