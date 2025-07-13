/**
 <문제 분석>
 뒤집어도 같으면 회문 => 0 -> 양쪽에서 가운데로 오면서 비교
 한문자만 삭제해서 같으면 유사회문 => 1 -> 다르면, 앞뒤 한칸씩 땡겨서 케이스 2개가 회문이면 유사회문

 */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String str = br.readLine();
            if(isP(str, 0, str.length() - 1)) bw.write("0\n");
            else if(isPP(str)) bw.write("1\n");
            else bw.write("2\n");
        }
        bw.flush();
    }
    static boolean isP(String str, int start, int end){
        while(start < end){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }

    static boolean isPP(String str){
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }
            else {
                return isP(str, start + 1, end) || isP(str, start, end - 1);
            }
        }
        return false;
    }
}