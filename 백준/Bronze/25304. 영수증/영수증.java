import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하면 Yes를 출력한다. 일치하지 않는다면 No를 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int totalPrice = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            totalPrice += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        if(totalPrice == X)bw.write("Yes");
        else bw.write("No");

        bw.flush();
        bw.close();
    }
}
