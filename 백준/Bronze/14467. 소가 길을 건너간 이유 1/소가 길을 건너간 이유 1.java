import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            Integer value = map.get(cow);
            if(value == null){
                map.put(cow, position);
            }
            else{
                if(value != position) cnt++;
                map.put(cow, position);
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
