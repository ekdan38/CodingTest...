import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 20291 파일 정리
         * 파일의 확장자를 찾고, 확장자 명과 개수를 출력해야한다.
         * 확장자 명은 사전순으로 출력해야한다.
         * Map중 TreeMap은 오름차순을 보장해준다. HashMap을 사용하고 stream을 돌려 사전순으로 정렬해도 되지만
         * TreeMap을 사용하여 풀어보겠다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // 파일 이름, 개수 저장
        Map<String, Integer> extentionMap = new TreeMap<>();
        for(int i = 0; i < N; i++){
            String fileName = br.readLine();
            String extention = fileName.substring(fileName.lastIndexOf('.') + 1);
            extentionMap.put(extention, extentionMap.getOrDefault(extention, 0) + 1);
        }

        // 정렬된 값 출력
        for(Map.Entry<String, Integer> entry : extentionMap.entrySet()){
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        bw.flush();
        bw.close();
    }
}

