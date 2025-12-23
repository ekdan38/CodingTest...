import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int score1 = 0;
        int score2 = 0;
        int lastTime = 0;
        int leadTime1 = 0;
        int leadTime2 = 0;
        int endTime = 60 * 48;

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());

            String[] str = st.nextToken().split(":");
            int scoreTime = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);

            if(score1 > score2) leadTime1 += scoreTime - lastTime;
            else if(score2 > score1) leadTime2 += scoreTime - lastTime;

            if (team == 1) score1++;
            else score2++;
            lastTime = scoreTime;
        }
        
        if(score1 > score2) leadTime1 += endTime - lastTime;
        else if(score2 > score1) leadTime2 += endTime - lastTime;

        int min1 = leadTime1 / 60;
        int sec1 = leadTime1 % 60;
        int min2 = leadTime2 / 60;
        int sec2 = leadTime2 % 60;
        bw.write(String.format("%02d:%02d\n", min1, sec1));
        bw.write(String.format("%02d:%02d\n", min2, sec2));
        bw.flush();
    }
}