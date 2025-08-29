import java.io.*;
import java.util.*;

public class Main {

    public static int cardNum, choiceNum;
    public static boolean[] visited;
    public static int[] list;
    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cardNum = Integer.parseInt(br.readLine());
        choiceNum = Integer.parseInt(br.readLine());

        list = new int[cardNum];
        visited = new boolean[cardNum];

        for (int x = 0; x < cardNum; x++) {
            list[x] = Integer.parseInt(br.readLine());
        }

        canMakeNum(0, "");

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

    
    public static void canMakeNum(int choiceIdx, String num){
        if (choiceIdx == choiceNum) {
            set.add(num);
            return;
        }

        for (int x = 0; x < cardNum; x++) {
            if (!visited[x]) {
                visited[x] = true;
                canMakeNum(choiceIdx+1, num + list[x]);
                visited[x] = false;
            }
        }
    }
}