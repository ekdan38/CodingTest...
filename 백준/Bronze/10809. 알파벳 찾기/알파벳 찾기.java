import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int search = 'a';
        int[] arr = new int['z' - 'a' + 1];
        
        Arrays.fill(arr, -1);
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            
            if(arr[index] == -1){
                arr[index] = i;
            }
        }

        for(int i:arr){
            System.out.print(i + " ");
        }


        bw.flush();
        bw.close();

    }
}
