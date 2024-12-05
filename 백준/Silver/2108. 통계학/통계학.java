import java.io.*;
import java.util.*;

/**
 * 2108 통계학
 * 입력:
 *      1. 첫째 줄 수의 개수 N (1 ~ 500,000) 홀수임
 *      2. N개의 정수들 (1~ 4,000)
 *
 *문제 분석:
 *      1. 산술 평균 : N 개의 수 합을 N으로 나눈 값, 소수점 첫째 자리에서 반올림
 *      2. 중앙 값 : N개의 수들을 오름차순 정렬하고 중앙에 위치하는 값
 *      3. 최빈 값 : N개의 수들 중 가장 많이 나타나는 값, 여러개 있으면 두번째로 작은 값
 *      4. 범위 : N개의 수들 중 최대값과 최소값 차이
 *
 * 출력:
 *      1. 산술 평균, 중앙 값, 최빈 값, 범위 => 줄 바꾸면서 출력
 */

public class Main {
    static int[] arr;
    static int N;
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 값 수
        N = Integer.parseInt(br.readLine());

        // 입력 값 저장
        arr = new int[N];
        map = new HashMap<>();
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        result.append(average()).append("\n");
        result.append(median()).append("\n");
        result.append(mode()).append("\n");
        result.append(range());

        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    static int average(){
        // 산술 평균 : N 개의 수 합을 N으로 나눈 값, 소수점 첫째 자리에서 반올림
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += arr[i];
        }
        return (int) Math.round((double) sum / N);
    }

    static int median(){
        // 중앙 값 : N개의 수들을 오름차순 정렬하고 중앙에 위치하는 값
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);
        return sortedArray[N / 2];
    }

    static int mode() {
        // 최빈 값 : N개의 수들 중 가장 많이 나타나는 값, 여러개 있으면 두번째로 작은 값
        // map value 에 따라 key : value 정렬 불가 => list로 바꿔주고 정렬하자
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // value 따라 내림차순 정렬

        list.sort((a, b) -> b.getValue() - a.getValue());
        // 가장 큰 최빈 값
        int max = list.get(0).getValue();

        // 가장 큰 최빈 값과 같으면 key를 list에 넣는다.
        ArrayList<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            if(entry.getValue() == max)resultList.add(entry.getKey());
        }

        // 가장 큰 최빈값 2개 이상이면 두번째로 작은 key 출력
        Collections.sort(resultList);
        if(resultList.size() > 1)return resultList.get(1);
        else return resultList.get(0);
    }

    static int range() {
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);
        return sortedArray[N - 1] - sortedArray[0];
    }

}