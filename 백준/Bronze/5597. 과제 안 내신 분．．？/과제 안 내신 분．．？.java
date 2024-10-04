import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // X대학 M교수님은 프로그래밍 수업을 맡고 있다. 교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.
        // 교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.
        //

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i < 31; i++){
            arr.add(i);
        }

        String str;
        while((str = br.readLine()) != null){
            if(arr.contains(Integer.parseInt(str))){
                arr.remove(Integer.valueOf(str));
            }
        }
        bw.write(Collections.min(arr) + "\n" + Collections.max(arr));

        bw.flush();
        bw.close();
    }
}
