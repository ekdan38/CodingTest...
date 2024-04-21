import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int A, B, C, X, Y;
        A = stringToInt(input[0]);
        B = stringToInt(input[1]);
        C = stringToInt(input[2]);

        X = stringToInt(input[3]);
        Y = stringToInt(input[4]);

        int count = 0;

        if ((A + B) <= C * 2) {
            count += (A * X) + (B * Y);
        } else {
            if (X > Y) {
                count += Y * (C * 2);
                count += Math.min((X - Y) * A, (X - Y) * (C * 2));
            } else {
                count += X * (C * 2);
                count += Math.min((Y - X) * B, (Y - X) * (C * 2));
            }

        }
        System.out.println(count);
    }
}