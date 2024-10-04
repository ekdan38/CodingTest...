import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 1; i < n + 1; i++){
            result += i;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
