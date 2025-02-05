import java.io.*;
import java.util.StringTokenizer;

/**
 * 20438 출석 체크
 *
 * 입력:
 *      1. 첫째 줄 학생의 수 N, 졸고 있느 학생 수 K, 지환이가 출석 코드를 보낼 학생 수 Q, 주어질 구간의 수 M
 *      2. 둘째 줄 K명의 졸고 있는 학생의 입장 번호
 *      3. 셋째 줄 Q명의 출석 코드를 받을 학생의 입장 번호들
 *      4. 넷째 줄 M개의 줄 동안 구간의 범위 S,E
 *
 * 문제 분석:
 *      1. 학생들은 3번 ~ N + 2 까지 입장 번호를 받는다.
 *      2. 지환이가 한 학생한테 출석 코드 보내면 해당 학생은 본인의 번호의 배수인 학생들에게 출석 코드 보낸다.
 *      => 한명한테 출서코드 보냈는데 해당 학생의 입장 번호가 3이면 3,6,9?
 *      3. k명의 졸고 있는 할생들은 무시
 *      4. 무작위로 한 학생한테 추럭 코드 보내는 행위를 Q번 하고 출석 처리 안된 학생들 수 구하기
 *
 *      예제 해석
 *
 *          * 10 1 3 1
 *          * 7
 *          * 3 5 7
 *          * 3 12
 *          * => N = 10, K = 1, Q = 3, M = 1
 *          * => 입장 번호 = 3 ~ 12 번
 *          * => K = 1 만큼의 학생이 졸고 있는데 그 번호는 7
 *          * => 3, 5, 7 입장 번호를 갖는 학생들에게 출석 코드를 보낸다.
 *          * => M 개의 줄 동안 S, E가 주어진다.
 *
 * 출력:
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // idx 3 ~ N + 2 까지 사용
        boolean[] checkArr = new boolean[N + 3];
        boolean[] sleepArr = new boolean[N + 3];
        int[] prefix = new int[N + 3];


        // 자는 학생들 표시
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) sleepArr[Integer.parseInt(st.nextToken())] = true;

        // 출석 코드 전송 처리
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++){
            int sendNumber = Integer.parseInt(st.nextToken());
            if(!sleepArr[sendNumber]){
                for(int j = sendNumber; j <= N + 2; j += sendNumber) {
                    if(!sleepArr[j]) checkArr[j] = true;
                }
            }
        }

        for (int i = 3; i <= N + 2; i++) {
            prefix[i] = prefix[i - 1] + (checkArr[i] ? 0 : 1);
        }

        // 구간 별 결과 출력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            bw.write((prefix[E] - prefix[S - 1]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
