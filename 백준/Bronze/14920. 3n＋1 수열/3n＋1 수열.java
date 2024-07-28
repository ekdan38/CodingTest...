import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        long seqNum = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (cnt < Integer.MAX_VALUE) {
            cnt++;
            if (seqNum == 1) {
                break;
            }
            if (seqNum % 2 == 1) {
                seqNum = seqNum * 3 + 1;
            }
            else {
                seqNum = seqNum / 2;
            }
        }

        System.out.print(cnt);
    }
}

