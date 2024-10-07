import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();
        int resultX = 0;
        int resultY = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            listX.add(Integer.parseInt(st.nextToken()));
            listY.add(Integer.parseInt(st.nextToken()));
        }
        if (listX.get(0).equals(listX.get(1))) {
            resultX = listX.get(2);
        } else if (listX.get(0).equals(listX.get(2))) {
            resultX = listX.get(1);
        } else resultX = listX.get(0);

        if (listY.get(0).equals(listY.get(1))) {
            resultY = listY.get(2);
        } else if (listY.get(0).equals(listY.get(2))) {
            resultY = listY.get(1);
        } else resultY = listY.get(0);

        System.out.print(resultX + " " + resultY);
    }
}
