import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 바구니 1~N
        // M번 공을 넣는다. 공을 넣을때 버ㅁ위를 지정한다. 지정한 바구니에 모두 같은 번호의 공을 넣ㄴ느다.
        // 바구니에 공이 있으면 공을 모두 빼고 색공을 ㄴ허는다.
        // i j k => i~ j까지 k를 넣는다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] basket = new int[N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            for(int j = start - 1; j < end; j++){
                basket[j] = ball;
            }
        }

        for(int ball : basket){
            bw.write(ball + " ");
        }
        bw.flush();
        bw.close();
    }
}
