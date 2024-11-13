import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 2477
         * 1. 동쪽
         * 2. 서쪽
         * 3. 남쪽
         * 4. 북쪽
         * 풀이법 : 가장 큰 직사각형의 넓이를 구하고 작은 직사각형의 넓이를 빼준뒤 참외의 수를 곱해주자.
         * 우선 가장 큰 가로 세로를 구하려면 1,2 인지 3,4인지 구분하고 가장 큰 값을 가져온다.
         * 각각의 값은 가장 큰 직사각형의 가로 세로 길이이다.
         * 작은 직사각형의 가로세로는 가장 큰 직사각형 의 가로, 세로 의 위치에서 3번째 위치로 고정되어있다.
         * 따라서 배열을 통해 가장 큰 직사각형의 가로 세로 위치부터 3번째 뒤에있는 값들으 찾아서 곱해주면 작은 직사각형 넓이이다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] length = new int[6];
        int maxWidth = 0;
        int maxHeight = 0;
        int maxWidthIdx = -1;
        int maxHeightIdx = -1;

        for(int i = 0; i < 6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
            if(direction == 1 || direction == 2){
                if(maxWidth < length[i]){
                    maxWidth = length[i];
                    maxWidthIdx = i;
                }
            }
            else{
                if(maxHeight < length[i]){
                    maxHeight = length[i];
                    maxHeightIdx = i;
                }
            }
        }
        int maxSquare = maxHeight * maxWidth;
        int minSquare = length[(maxHeightIdx + 3) % 6] * length[(maxWidthIdx + 3) % 6];

        int result = (maxSquare - minSquare) * N;
        System.out.print(result);
    }
}
