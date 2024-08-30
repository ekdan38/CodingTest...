
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < v; i++) {
            if (arr[i] == 'A') {
                aCount++;
            } else {
                bCount++;
            }
        }

        if (aCount > bCount) {
            System.out.println("A");
        } else if (aCount == bCount) {
            System.out.println("Tie");
        } else {
            System.out.println("B");
        }
    }
}