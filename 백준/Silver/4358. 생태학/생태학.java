/**
 나무 주어지고, 해당 나무가 몇번 등장하는지 전체 빈도수에서 퍼센티지 계산.
 출력은 사전순으로 해야한다.
 TreeMap 사용하면서 값 넣고
 이후 entry 순회하면서 퍼센티지 변환 해서 출력
 */
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //EOF
        Map<String, Double> treeMap = new TreeMap<>();

        int cnt = 0;
        String tree;
        while((tree = br.readLine()) != null){
            treeMap.put(tree, treeMap.getOrDefault(tree, 0.0) + 1);
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Double> entry : treeMap.entrySet()){
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", entry.getValue() / cnt * 100)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }
}