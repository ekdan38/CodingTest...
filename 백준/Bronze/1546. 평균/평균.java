import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int subjects = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> scoreList = new ArrayList<>();

        for(int i = 0; i < subjects; i++){
            scoreList.add(Integer.parseInt(st.nextToken()));
        }

        int max = Collections.max(scoreList);

        double result = 0;
        for(int i = 0; i < subjects; i++){
            result += Double.valueOf(scoreList.get(i)) / max * 100;
        }
        bw.write(String.valueOf(result / subjects));

        bw.flush();
        bw.close();
    }
}
