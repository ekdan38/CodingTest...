import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());

            while(N --> 0){
                st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String category = st.nextToken();
                map.put(category, map.getOrDefault(category, 1) + 1);                
            }
                
            int result = 1;
            for(int value : map.values()){
                result *= value;
            }
            
            sb.append(result - 1).append("\n");
            
        }
        bw.write(sb.toString());
        bw.flush();
    }
}