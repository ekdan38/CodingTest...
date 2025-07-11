/**
<문제 분석>
    s,t 주어질때 t 에서 몇개 문자 제거하고 s가 부분 문자열이 되냐?
    s 의 index 값 주고 t기준으로 for문 돌리면서, s[idx]와 t[i] 일치하면 idx ++;
    끝나고나서 idx 값이 s.length() 이면 성공 
*/
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        String str;
        while((str = br.readLine()) != null){
            String[] splitedStr = str.split(" ");
            String s = splitedStr[0];
            String t = splitedStr[1];
            
            int idx = 0;
            for(int i = 0; i < t.length(); i++){
                if(s.charAt(idx) == t.charAt(i)) {
                    idx++;
                    if(idx == s.length()){
                        sb.append("Yes").append("\n");
                        break;
                    }
                }
            }
            
            if(idx != s.length())sb.append("No").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}