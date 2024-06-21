import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        char[] arr = s.toCharArray();
        String result = "READY";
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            a += arr[i] - '0';
            b += arr[arr.length - 1 - i] - '0';
        }
        if (a == b) {
            result = "LUCKY";
        }
        System.out.println(result);
    }
}