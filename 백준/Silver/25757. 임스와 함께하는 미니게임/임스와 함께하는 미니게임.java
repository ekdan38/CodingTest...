import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(st.nextToken());
        String g = st.nextToken();

        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        if (g.equals("Y")) System.out.println(set.size() / 1);
        else if (g.equals("F")) System.out.println(set.size() / 2);
        else if (g.equals("O")) System.out.println(set.size() / 3);
    }
}