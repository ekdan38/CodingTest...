import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //첫번째 줄만m, n 으로 받기
        String[] split = br.readLine().split(" ", 2);
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        //map에 저장
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < N; i ++){
            split = br.readLine().split(" ",2);
            map.put(split[0], split[1]);
        }
        // 나머지 줄은 바로 맵에서 탐색
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            sb.append(map.get(br.readLine())).append("\n");
        }

        System.out.println(sb.toString());
    }
}
