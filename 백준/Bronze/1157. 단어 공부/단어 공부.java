import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String upperCase = str.toUpperCase();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            String key = String.valueOf(upperCase.charAt(i));
            if(map.get(key) != null){
                map.put(key, map.get(key) + 1);
            }
            else{
                map.put(String.valueOf(upperCase.charAt(i)), 1);
            }
        }
        int cnt = 0;
        int max = Collections.max(map.values());
        String foundKey = null;
        for(int i : map.values()){
            if(i == max)cnt++;
        }
        if(cnt > 1)bw.write("?");
        else{
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getValue() == max){
                    foundKey = entry.getKey();
                    break;
                }
            }
            bw.write(String.valueOf(foundKey));
        }

        bw.flush();
        bw.close();

    }
}
