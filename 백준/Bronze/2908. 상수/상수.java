import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(br.readLine()).reverse();
        String[] str = sb.toString().split(" ");
        bw.write(String.valueOf(Math.max(Integer.parseInt(str[0]), Integer.parseInt(str[1]))));

        bw.flush();
        bw.close();

    }
}
