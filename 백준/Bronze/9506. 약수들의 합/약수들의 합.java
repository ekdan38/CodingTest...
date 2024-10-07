import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;
        while((n = Integer.parseInt(br.readLine())) != -1){
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for(int i = 1; i < n; i++){
                if(n % i == 0){
                    sum += i;
                    list.add(i);
                }
            }
            if(sum == n){
                sb.append(n + " = ");
                for(int i = 0; i < list.size(); i++){
                    if(i == list.size() - 1)sb.append(list.get(i) + "\n");
                    else sb.append(list.get(i) + " + ");
                }
            }
            else{
                sb.append(n + " is NOT perfect.\n");
            }
            list.clear();
        }
        System.out.print(sb);

    }
}
