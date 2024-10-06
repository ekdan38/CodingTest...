import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new  StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 결국 하루에 a-b 만큼 올라갈 수 있다. 밤에 떨어진다는 가정하에
        // 밤에 떨어지면 하루 더 추가하자.
        int day = (v - b) / (a - b);
        if( (v - b) % (a - b) != 0)day++;
        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();

    }
}
