import java.io.*;
import java.util.*;

/**
 * 15721 번데기
 *
 * 입력:
 *      1. 첫째 줄에 게임을 진행하는 사람 A명이 주어진다. A는 2,000보다 작거나 같은 자연수이다.
 *      2. 둘째 줄에는 구하고자 하는 번째 T가 주어진다. (T ≤ 10000)
 *      3. 셋째 줄에는 구하고자 하는 구호가 “뻔”이면 0, “데기”면 1로 주어진다.
 * 문제 분석:
 *      1. n-1회차 문장일 때는 ‘뻔 – 데기 – 뻔 – 데기 – 뻔(x n번) – 데기(x n번)
 *      1회차 => 뻔 데기 뻔 데기 뻔 번 데기 데기
 *      3회차 => 뻔 데기 뻔 데기 뻔 뻔 뻔 뻔 데기 데기 데기 데기
 *      T 번째로 뻔 OR 데기 외치는 사람 찾기
 *
 *
 * 출력:
 *
 * */

public class Main {
        static int A, T, target;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            A = Integer.parseInt(br.readLine());
            T = Integer.parseInt(br.readLine());
            target = Integer.parseInt(br.readLine());

            bw.write(Integer.toString((search())));
            bw.flush();
            br.close();
            bw.close();
        }
        static int search(){
            int 뻔 = 0;
            int 데기 = 0;
            int round = 2;
            while(true){
                for(int i = 0; i < 4; i++){
                    if(i % 2 == 0) 뻔++;
                    else 데기++;
                    if((target == 0 && 뻔 == T) || (target == 1 && 데기 == T)) return (뻔 + 데기 - 1) % A;
                }

                for(int i = 0; i < round; i++){
                    뻔++;
                    if((target == 0 && 뻔 == T) || (target == 1 && 데기 == T)) return (뻔 + 데기 - 1) % A;
                }

                for(int i = 0; i < round; i++){
                    데기++;
                    if((target == 0 && 뻔 == T) || (target == 1 && 데기 == T)) return (뻔 + 데기 - 1) % A;
                }
                round++;
            }
        }


    }
