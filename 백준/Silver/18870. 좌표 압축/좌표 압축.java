import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 18870 좌표 압축
 * 입력:
 *      1. 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 *      2. 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다. (-10^9 ≤ Xi ≤ 10^9)
 *
 * 문제 분석:
 *      1. 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
 *      2. Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
 *      
 *
 * 의사 결정:
 *      1.오름차순으로 정렬하고 map에 key :좌표값, value : 좌표값의 빈도수를 넣어주고 원래의 배열에서 값을 찾아 출력하면 된다.
 * 출력:
 *      1. 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        //원본 저장 배열.. 출력할 때 원본 배열이 꼭 필요함
        int[] arr = new int[N];
        //순서 보장 해주기 위해 LinkedHashMap 사용, 각 숫자의 순위를 매겨줄거다. (중복 처리) 
        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //원본 배열 복사 하고 정렬
        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);

        
        int rank = 0;
        for(int i = 0; i < N; i++){
            //map에 배열 값이 존재 하지 않으면 map에 넣어준다.(중복 제거)
            if(!map.containsKey(sortArr[i])){
                map.put(sortArr[i], rank);
                rank++;
            }
        }

        for(int i  = 0; i < N; i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}