/**
 <문제 분석>
 1. 모음(aeiou) 하나 반드시 포함
 2. 모음, 자음 모두 3개 연속으로 오면 x
 3. 같은 글자 두번 연속 불가 (ee, oo 제외)
 */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while(!(str = br.readLine()).equals("end")){
            // 모음 개수 확인
            int vCheckCnt = 0;
            // 모음 연속
            int vCnt = 0;
            // 자음 연속
            int cCnt = 0;
            boolean result = true;

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    vCheckCnt++;
                    vCnt++;
                    cCnt = 0;
                }
                else{
                    cCnt++;
                    vCnt = 0;
                }
                if(cCnt == 3 || vCnt == 3){
                    result = false;
                    break;
                }
            }
            if(vCheckCnt < 1) result = false;

            if(str.length() > 1){
                for(int i = 1; i < str.length(); i++){
                    char c = str.charAt(i);
                    if(c != 'e' && c != 'o'){
                        if(str.charAt(i) == str.charAt(i - 1)){
                            result = false;
                            break;
                        }
                    }
                }
            }

            bw.write(result ? "<" + str + ">" + " is acceptable.\n" : "<" + str + ">" + " is not acceptable.\n");

        }
        bw.flush();
    }
}