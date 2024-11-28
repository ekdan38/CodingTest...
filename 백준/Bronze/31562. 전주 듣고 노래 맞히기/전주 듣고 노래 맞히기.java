import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 31562 전주 듣고 노래 맞히기
         * 문제 분석:
         *          3개의 음을 기준으로 노래를 구분한다.
         *          중복, 아무것도 없을경우 고려
         *
         * 의사 결정:
         *          HashMap 사용
         *          3개의 음을 기준으로 key : 음, value : 노래 제목
         *          다만, 음이 증복되면 value를 Duplicated로 바꿔준다.
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