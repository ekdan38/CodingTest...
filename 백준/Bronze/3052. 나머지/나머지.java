import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();
        String str;
        while((str = br.readLine()) != null){
            set.add(Integer.parseInt(str) % 42);
        }
        
        bw.write(String.valueOf(set.size()));

        bw.flush();
        bw.close();
    }
}
