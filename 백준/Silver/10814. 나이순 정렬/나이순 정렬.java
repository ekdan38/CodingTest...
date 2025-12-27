import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, List<String>> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            map.putIfAbsent(age, new ArrayList<>());
            map.get(age).add(name); // 입력 순서 유지
        }

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            int age = entry.getKey();
            for (String name : entry.getValue()) {
                sb.append(age).append(" ").append(name).append("\n");
            }
        }
        System.out.print(sb);
    }
}