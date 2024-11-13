import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 17207 돌려막기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 난이도 저장 배열
        int [][] difficulty = new int[5][5];
        // 처리 시간 저장 배열
        int [][] time = new int[5][5];

        // 난이도 저장
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                difficulty[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처리 시간 저장
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 인원마다 최종 일량 저장.
        int [] result = new int [5];
        for(int i = 0; i < 5; i++){
            int total = 0;
            for(int j = 0 ; j < 5; j++){
                //40 50 20 70 10
                int sum = 0;

                for(int q = 0; q < 5; q++){
                    sum += difficulty[i][q] * time[q][j];
                }
                total += sum;
            }
            result[i] = total;
        }

        // 최소값 찾고 해당하는 이름 출력, 최소값이 겹치면 이름 역순으로 출력
        String[] names = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};

        int min = result[0];
        int idx = 0;
        List<Integer> idxList = new ArrayList<>();

        // 최소값 찾기
        for(int i = 0; i < 5; i++){
            if(min > result[i]){
                min = result[i];
                idx = i;
            }
        }

        for(int i = 0; i < 5; i++){
            if(min == result[i]){
                idxList.add(i);
            }
        }

        if(idxList.size() == 1){
            System.out.println(names[idx]);
        }

        else{
            System.out.println(names[Collections.max(idxList)]);
        }

    }
}
