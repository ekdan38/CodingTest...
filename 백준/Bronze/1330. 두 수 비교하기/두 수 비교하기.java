import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //A가 B보다 큰 경우에는 '>'를 출력한다.
        //A가 B보다 작은 경우에는 '<'를 출력한다.
        //A와 B가 같은 경우에는 '=='를 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if(A < B)bw.write("<");
        if(A > B)bw.write(">");
        if(A == B)bw.write("==");

        bw.flush();
        bw.close();
    }
}
