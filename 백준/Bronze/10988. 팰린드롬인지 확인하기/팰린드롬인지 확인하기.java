import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String strReverse = new StringBuilder(str).reverse().toString();
        if(str.equals(strReverse)){
            bw.write("1");
        }
        else{
            bw.write("0");
        }
        bw.flush();
        bw.close();

    }
}
