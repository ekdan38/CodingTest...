import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        char[][] leftQwerty = {
                {'q', 'w', 'e', 'r', 't'},
                {'a', 's', 'd', 'f', 'g'},
                {'z', 'x', 'c', 'v'}
        };

        char[][] rightQwerty = {
                {' ', 'y', 'u', 'i', 'o', 'p'},
                {' ', 'h', 'j', 'k', 'l'},
                {'b', 'n', 'm'}
        };

        Map<Character, int[]> map = new HashMap<>(); // 키보드 좌표 저장

        // 왼손 자판 위치 저장
        for (int i = 0; i < leftQwerty.length; i++) {
            for (int j = 0; j < leftQwerty[i].length; j++) {
                map.put(leftQwerty[i][j], new int[]{i, j});
            }
        }

        // 오른손 자판 위치 저장
        for (int i = 0; i < rightQwerty.length; i++) {
            for (int j = 0; j < rightQwerty[i].length; j++) {
                map.put(rightQwerty[i][j], new int[]{i, j});
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char sL = st.nextToken().charAt(0); // 현재 왼손 검지손가락
        char sR = st.nextToken().charAt(0); // 현재 오른손 검지손가락

        char[] s = br.readLine().toCharArray(); // 문자열

        int time = 0; // 걸리는 시간

        int[] currentLeft = map.get(sL);
        int[] currentRight = map.get(sR);

        for (int i = 0; i < s.length; i++) {
            int[] currentS = map.get(s[i]);

            if (leftKey(s[i])) { // 왼손, 자음
                time += Math.abs(currentLeft[0] - currentS[0]) + Math.abs(currentLeft[1] - currentS[1]); // 왼손 x, y 좌표 차
                currentLeft = currentS; // 왼손 위치 변경
            } else { // 오른손, 모음
                time += Math.abs(currentRight[0] - currentS[0]) + Math.abs(currentRight[1] - currentS[1]); // 오른손 x, y 좌표 차
                currentRight = currentS; // 오른손 위치 변경
            }

            time += 1; // 키 누르는 시간
        }

        System.out.println(time);
    }

    // 자음 확인
    static boolean leftKey(char c) {
        return "qwertasdfgzxcv".indexOf(c) != -1;
    }
}