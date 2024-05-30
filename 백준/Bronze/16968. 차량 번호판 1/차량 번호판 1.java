import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init();		
        String str = br.readLine();
        String temp = str.charAt(0) + "";
        int answer = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == str.charAt(i-1))
                temp += str.charAt(i);
            else{
                answer *= map.get(temp);
                temp = str.charAt(i) + "";
            }
        }
        answer *= map.get(temp);
        bw.write(answer + "");
        bw.flush();		
        bw.close();
        br.close();
    }
    static void init(){
        map.put("d" , 10);
        map.put("dd", 90);
        map.put("ddd", 810);
        map.put("dddd", 7290);
        map.put("c", 26);
        map.put("cc", 650);
        map.put("ccc", 16250);
        map.put("cccc",406250);

    }
}