import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for(int j = 0; j < k; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(command.equals("I")) treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
                else{
                    if(!treeMap.isEmpty()){
                        int key = (n == -1) ? treeMap.firstKey() : treeMap.lastKey();
                        int value = treeMap.get(key);
                        if(value > 1) treeMap.put(key, value - 1);
                        else treeMap.remove(key);
                    }
                }
            }

            if(treeMap.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}