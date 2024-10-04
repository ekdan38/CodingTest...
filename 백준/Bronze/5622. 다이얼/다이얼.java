import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "ABC");
        map.put(3, "DEF");
        map.put(4, "GHI");
        map.put(5, "JKL");
        map.put(6, "MNO");
        map.put(7, "PQRS");
        map.put(8, "TUV");
        map.put(9, "WXYZ");

        int result = 0;
        for(int i = 0; i < str.length(); i++){
            String s = String.valueOf(str.charAt(i));
            Optional<Integer> first = map.entrySet()
                    .stream()
                    .filter(entry ->
                            entry.getValue().contains(s))
                    .map(entry -> entry.getKey())
                    .findFirst();
            result += first.get() + 1;

        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}
