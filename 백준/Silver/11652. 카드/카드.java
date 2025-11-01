import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Long, Long> map = new HashMap<>();
        long N = Long.parseLong(br.readLine());

        while(N --> 0){
            long input = Long.parseLong(br.readLine());
            map.put(input, map.getOrDefault(input, 0L) + 1L);
        }

        long max = -1L;
        long result = 0;

        for(Map.Entry<Long, Long> entry : map.entrySet()){
            Long value = entry.getValue();
            Long key = entry.getKey();
            if(max < value){
                max = value;
                result = key;
            }
            else if(max == value){
                result = Math.min(result, key);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
