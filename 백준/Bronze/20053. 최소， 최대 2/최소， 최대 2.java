import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            while(N -- > 0){
                list.add(Integer.parseInt(st.nextToken()));
            }
            bw.write(Collections.min(list) + " " + Collections.max(list) + "\n");
        }

        bw.flush();
    }
}