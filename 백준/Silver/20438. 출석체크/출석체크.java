import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // idx 3 ~ N+2 까지 사용
        boolean[] arr = new boolean[N + 3];  // 출석 여부
        boolean[] sleepArr = new boolean[N + 3];  // 졸고 있는 학생

        // 졸고 있는 학생 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sleepArr[Integer.parseInt(st.nextToken())] = true;
        }

        // 출석 코드 전송
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int sendNumber = Integer.parseInt(st.nextToken());
            if (!sleepArr[sendNumber]) {  // 출석 코드 보내는 학생이 안 졸고 있으면
                for (int j = sendNumber; j <= N + 2; j += sendNumber) {
                    if (!sleepArr[j]) {  // 배수인 학생도 졸고 있지 않아야 함
                        arr[j] = true; 
                    }
                }
            }
        }

        // M개의 구간 입력 후 결과 출력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int j = S; j <= E; j++) {
                if (!arr[j]) cnt++;
            }
            bw.write(cnt + "\n"); // 여러 줄 출력
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
