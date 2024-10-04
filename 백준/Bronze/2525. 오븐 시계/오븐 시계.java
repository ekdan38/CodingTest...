import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // "오븐 시간 더하기.."
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int cookingTime = Integer.parseInt(br.readLine());

        minute += cookingTime;
        if(minute >= 60){
            hour += (minute / 60);
            minute %= 60;
        }

        if(hour > 23){
            hour -= 24;
        }

        bw.write(String.valueOf(hour) + " " + String.valueOf(minute));
        bw.flush();
        bw.close();
    }
}
