import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = 0;
        for(int i = 0 ; i < t; i++){
            result += Character.getNumericValue(str.charAt(i));
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}
