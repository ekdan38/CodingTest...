import java.io.*;
import java.util.StringTokenizer;

/**
 * 20546 🐜 기적의 매매법 🐜
 *
 * 입력:
 *      1. 첫 번째 줄에 준현이와 성민이에게주어진 현금 => 동일하게 주어진다.
 *      2. 두 번째 줄에 2021.1.1 ~ 2021.1.14 의 주가가 공백으로 주어진다. (1 ~ 1000)
 *
 * 문제 분석:
 *      1. 준현이
 *        1. 한번 산 주식은 팔지 않는다. 주식을 살 수 있다면 살 수 있는 만큼 산다.
 *      2. 성민이
 *        1. 보유 현금 만큼 최대로 주식 매수 => (주식 가격 * 수량 <= 보유 현금)
 *        2. 3일 연속 전날보다 가격이 오르면 전량 매도 => (전일 가격 < 금일 가격) 의 cnt가 3이면 매도
 *        3. 3일 연속 전날보다 가격이 낮아지면 전량 매수 => (전일 가격 > 금일 가격) 의 cnt가 3이면 매수
 *
 * 출력:
 *      1. 1.14일 기준으로 준현이와 성민이가 각각 보유하고 있는 자산을 기준으로 순위 비교
 *      2. 준현이가 이기면 "BNF", 성민이가 이기면 "TIMING"
 *
 * */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cash = Integer.parseInt(br.readLine());
        int junHyeon = cash;
        int junHyeonCnt = 0;

        int seongMin = cash;
        int seongMinCnt = 0;

        int increase = 0;
        int decrease = 0;

        int[] arr = new int[15];
        arr[0] = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 14; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            // 준현
            if(arr[i] <= junHyeon){
                int stock = junHyeon / arr[i];
                junHyeon -= arr[i] * stock;
                junHyeonCnt += stock;

            }
            // 성민
            if(arr[i] > arr[i - 1]) {
                increase++;
                decrease = 0;
                if(increase == 3){
                    increase = 0;
                    // 매도
                    seongMin += seongMinCnt * arr[i];
                    seongMinCnt = 0;
                }
            }
            else if(arr[i] < arr[i - 1]){
                decrease ++;
                increase = 0;
                if(decrease >= 3){
                    //매수
                    int stock = seongMin / arr[i];
                    seongMin -= stock * arr[i];
                    seongMinCnt += stock;
                }
            }
            else {
                increase = 0;
                decrease = 0;
            }
        }

        junHyeon += junHyeonCnt * arr[14];
        seongMin += seongMinCnt * arr[14];
        
        if(junHyeon > seongMin) bw.write("BNP");
        else if(junHyeon < seongMin) bw.write("TIMING");
        else bw.write("SAMESAME");
        bw.flush();
        br.close();
        bw.close();
    }
}