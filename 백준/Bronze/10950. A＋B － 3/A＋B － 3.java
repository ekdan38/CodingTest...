import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
