import java.io.*;
import java.util.*;

/**
 * 1946 신입 사원
 * 입력:
 *      1. 첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다.
 *      2. 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다.
 *      3. 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다.
 * 의사 결정:
 *      1. 어떤 지원자의 서류, 면접 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 설별한다..
 *      => 즉, 두 성적 모두 다른 지원자보다 떨어지면 탈락.
 *      2. 서류 순으로 정렬하면 1등은 무조건 합격이다.
 *      3. 나머지 2~N등은 보류상태이고 면접 순으로 갈린다.
 *      4. 면접 순으로 비교를 해야하는데 서류 1등은 합격한 사람의 면접 점수를 기준을 최소값으로 두고 면접 순 비교
 *      => 다른 합격자가 또 나오면 해당 합격자의 면접 점수를 최소값으로 두고 비교
 * 출력:
 *      1. 각 테스트 케이스의 합격자 수
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        //2차원 배열 선언하고 [][0] 에는 서류 성적, [][1]에는 면접 성적 넣어주자
        int [][]arr;
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            for(int j = 0; j  < N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                //서류
                arr[j][0] = Integer.parseInt(st.nextToken());
                //면접
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            //서류 순으로 정렬
            Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
            //합격자 수
            int cnt = 0;
            //면접 최소 성적
            int min = N;

            //면접 성적 비교하면서 합격자 카운트
            for(int q = 0; q < N; q++){
                //서류 합격자의 면접 점수가 기준이 되야한다.. <=
                if(arr[q][1] <= min){
                    min = arr[q][1];
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}