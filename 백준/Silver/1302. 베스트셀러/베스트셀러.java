import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] dp = new int[1001];    // 메모이제이션을 위한 배열

    public static void main(String[] args) throws IOException {
        /**
         * 1302 베스트셀러
         * Map에 <제목, 팔린 수> 형태로 저장한다.
         * 이후 value값을 꺼내서 최대값을 구하고, 최대값에 해당되는 key값을 꺼내서 정렬한다.
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // 책 저장
        Map<String, Integer> booksMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            booksMap.put(book, booksMap.getOrDefault(book, 0) + 1);
        }

        // 가장 많이 팔린 수량 구하기
        List<Integer> values = booksMap.values().stream().collect(Collectors.toList());
        Integer max = Collections.max(values);

        // 가장 많이 팔린 책들 구하기
        List<String> results = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : booksMap.entrySet()){
            if(entry.getValue() == max){
                results.add(entry.getKey());
            }
        }

        // 가장 많이 팔린 책들 정렬(사전순)
        Collections.sort(results);

        // 가장 많이 팔린 책(사전 순으로 가장 앞서는 책)
        bw.write(results.get(0) + "\n");

        bw.flush();
        bw.close();
    }
}

