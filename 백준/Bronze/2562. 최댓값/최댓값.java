import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] arr = new Integer[9];
        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        Integer max = Collections.max(list);
        bw.write(max + "\n");
        if(max != null){
            bw.write(String.valueOf((list.indexOf(max)) + 1));
        }

        bw.flush();
        bw.close();
    }
}
