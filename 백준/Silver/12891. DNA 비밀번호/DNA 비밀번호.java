import java.io.*;
import java.util.*;

public class Main{
    static char[] arr;
    static int[] checkArr;
    static int[] validate;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int result = 0;
        arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        checkArr = new int[4];
        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        validate = new int[4];
        for(int i = 0; i < P; i++){
            add(i);
        }
        if(validateDNA()) result++;

        for(int i = 1; i <= S - P; i++){
            remove(i - 1);
            add(i + (P - 1));
            if(validateDNA()) result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();

    }
    static void add(int index){
        if(arr[index] == 'A') validate[0]++;
        else if(arr[index] == 'C') validate[1]++;
        else if(arr[index] == 'G') validate[2]++;
        else if(arr[index] == 'T') validate[3]++;
    }
    static void remove(int index){
        if(arr[index] == 'A') validate[0]--;
        else if(arr[index] == 'C') validate[1]--;
        else if(arr[index] == 'G') validate[2]--;
        else if(arr[index] == 'T') validate[3]--;
    }
    static boolean validateDNA(){
        int check = 0;
        for(int i = 0; i < 4; i++){
            if(validate[i] >= checkArr[i]) check++;
        }
        return check == 4;
    }
}