import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>((o1, o2) -> o2.compareTo(o1));

        StringTokenizer st;
        while(N --> 0){
            String[] log = br.readLine().split(" ");
            String name = log[0];
            String state = log[1];

            if(state.equals("enter")) set.add(name);
            else if(state.equals("leave")) set.remove(name);
        }

        StringBuilder sb = new StringBuilder();
        for(String n : set){
            sb.append(n).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}