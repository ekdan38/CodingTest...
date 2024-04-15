import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int sumAccount = getSumAccount(st);
        int C = 2 * Integer.parseInt(br.readLine());

        if(sumAccount >= C){
            System.out.println(sumAccount - C);
        }
        else {
            System.out.println(sumAccount);
        }

    }

    private static int getSumAccount(StringTokenizer st) {
        return Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
    }
}
