
import java.io.*;
import java.util.*;

/**
 * 18116 로봇 조립
 *
 * 입력:
 *      1. 첫째 줄에 호재의 지시 횟수 N (1 ~ 1,000,000)
 *      2. 다음 줄 부 터 N개의 지시가 들어온다.
 *      3. 부품 2개가 같은 로봇의 부품인지 알려주는 명령어 I a b (a,b => (1 ~ 1,000,000))
 *      => a, b 는 같은 로봇의 부품이다.
 *      4. 어떤 로봇의 부품이 몇개인지 물어볼 때는 Q c (c => (1 ~ 1,000,000))
 *      => 지금까지 알아낸 로봇 c의 부품이 몇개냐
 *      5. q는 최소 1번
 * 문제 분석:
 *      1. N개 만큼 지시가 들어오고, I 를 통해 두 부품이 같은 로봇의 부품이라고 알려줌
 *      => I 1 2 -> 1,2 번 부품은 같은 로봇의 부품
 *      => I 3 2 -> 3,2 번 부품은 같은 로봇의 부품
 *      ==> robot(1), robot(2), robot(3) 은 같은 로봇의 부품
 *      => Q 1 = 3이 맞다
 *      => Q 4 는? robot(4) 가된다. robot(4) 는 다른 로봇의 정보로 들어온 적이 없기에 1
 *      풀이법
 *      => robot(i) 를 노드로 보고 노드를 연결한다고 보면 된다. => 유니온 파인드
 *      => cnt 배열 하나 만들어서 노드 연결되면 cnt 더해주자.
 *
 *
 * 출력:
 *      1. 명령어 수행 결과값 줄 바꾸면서 출력
 *
 * */

public class Main {
        static int [] parent, cnt;
        static final int ARR_SIZE = 1000001;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringBuilder result = new StringBuilder();
            int N = Integer.parseInt(br.readLine());

            parent = new int[ARR_SIZE];
            cnt = new int[ARR_SIZE];

            // 초기화
            for(int i = 1; i <= ARR_SIZE - 1; i++){
                parent[i] = i;
                cnt[i] = 1;
            }

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if(command.equals("I")){
                    // 입력값 정렬 한번 시켜줘야 한다.
                    int first = Integer.parseInt(st.nextToken());
                    int second = Integer.parseInt(st.nextToken());
                    int a = Math.min(first, second);
                    int b = Math.max(first, second);
                    union(a, b);
                }
                else if(command.equals("Q")){
                    int c = Integer.parseInt(st.nextToken());
                    result.append(getSize(c)).append("\n");
                }
            }

            bw.write(result.toString());
            bw.flush();
            br.close();
            bw.close();
        }
        static void union(int a, int b){
            // a,b 의 대표 노드 탐색
            a = find(a);
            b = find(b);
            // 둘의 대표 노드가 다르면 연결 => b 에다가 a를 넣어줘야한다. a가 대표 노드
            if(a != b) {
                parent[b] = a;
                // 노드 연결 하면서 연결된 노드 수 더해주자.
                cnt[a] += cnt[b];
            }
        }

        static int find(int node){
            // node 가 자기 자신이면
            if(node == parent[node]) return node;
            // 부모 노드가 있으면
            else return parent[node] = find(parent[node]);
        }

        static int getSize(int node){
            return cnt[find(node)];
        }

    }
