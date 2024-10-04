import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        boolean start = false;
        boolean end = false;
        int space = 0;
        if(str.startsWith(" ")){
            start = true;
        }
        if(str.endsWith(" ")){
            end = true;
        }

        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) == ' '){
                space++;
            }
        }

        if(!start && !end){
            bw.write(String.valueOf(space + 1));
        }
        if((start && !end) || (!start && end)){
            bw.write(String.valueOf(space));
        }
        if(start && end){
            bw.write(String.valueOf(space - 1));
        }


        bw.flush();
        bw.close();

    }
}
