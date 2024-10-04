import java.io.*;
import java.util.*;

public class Main {

    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(String cro : croatia){
            str = str.replace(cro, "*");
        }

        System.out.println(str.length());

    }
}
