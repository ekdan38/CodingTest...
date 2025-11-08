import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while(A --> 0){
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while(B --> 0){
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for(int n : setA){
            if(setB.contains(n)){
                cnt += 2;
            }
        }

        int result = (setA.size() + setB.size()) - cnt;

        bw.write(String.valueOf(result));
        bw.flush();

    }
}