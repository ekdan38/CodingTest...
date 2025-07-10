import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int current = toSeconds(sc.next().split(":"));
        int target = toSeconds(sc.next().split(":"));

        int result = target - current;
        if(result <= 0) result += (24 * 3600);

        int h = result / 3600;
        int m = result % 3600 / 60;
        int s = result % 3600 % 60;

        System.out.print(String.format("%02d:%02d:%02d", h, m, s));

    }
    static int toSeconds(String[] arr){
        return Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60 + Integer.parseInt(arr[2]);
    }
}