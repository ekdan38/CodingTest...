import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 31562 전주 듣고 노래 맞히기
         * 문제 분석:
         *
         * 의사 결정:
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        
        HashMap<String, String> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            String[] split = br.readLine().split(" ");
            String title = split[1];
            String scale = split[2] + " " + split[3] + " " +split[4];
            if(map.containsKey(scale)){
                map.put(scale, "Duplicated");
            }
            else{
                map.put(scale,title);
            }
        }
        
        for(int i = 0; i < M; i++){
            String scale = br.readLine();
            if(map.containsKey(scale)){
                String value = map.get(scale);
                if(value.equals("Duplicated")){
                    sb.append("?").append("\n");
                }
                else {
                    sb.append(value).append("\n");
                }
            }
            else sb.append("!").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}