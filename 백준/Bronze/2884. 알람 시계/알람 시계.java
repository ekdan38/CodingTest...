import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // "45분 일찍 알람 설정하기"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        minute -= 45;
        if(minute < 0){
            hour -= 1;
            minute += 60;
        }

        if(hour < 0){
            hour += 24;
        }

        bw.write(String.valueOf(hour) + " " + String.valueOf(minute));
        bw.flush();
        bw.close();
    }
}
