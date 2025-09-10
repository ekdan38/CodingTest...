import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        
        int i = 1;
        while(N --> 0){
            String name = br.readLine();
            map1.put(name, i);
            map2.put(i, name);
            i++;
        }
        
        while(M --> 0){
            String target = br.readLine();
            if(target.charAt(0) >= 'A') sb.append(map1.get(target));
            else sb.append(map2.get(Integer.parseInt(target)));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}