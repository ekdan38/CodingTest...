import java.io.*;

/**
 * 4659 비밀번호 발음하기
 *
 * 입력:
 *      1. 테스트 케이스 주어진다. end로 테스트 마지막 알려줌
 *
 * 문제 분석:
 *      1. pw 만들 때 다음 규칙 준수해야함
 *      1.1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
 *      1.2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
 *      1.3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
 *
 * 출력:
 *      1. pw가 규칙 준수 하는지 출력
 *      => <pw> is acceptable. OR is not acceptable.
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        while(true){
            String password = br.readLine();
            if(password.equals("end")) break;

            // 모음 1개 이상 검사
            boolean checkVowel = false;
            boolean isAcceptable = true;
            int vowelCnt = 0;
            int consonantCnt = 0;

            for(int i = 0; i < password.length(); i++){
                char c = password.charAt(i);
                boolean isVowel = false;
                // 1번 조건
                for (char v : vowels) {
                    if (c == v) {
                        isVowel = true;
                        break;
                    }
                }
                // 2번 조건
                // 모음 이면 모음 체크해주고, 모음 cnt 증가, 자음 cnt 는 초기화
                if (isVowel) {
                    checkVowel = true;
                    vowelCnt++;
                    consonantCnt = 0;
                }
                // 자음 이면 자음 체크해주고, 자음 cnt증가, 모음 cnt 는 초기화
                else {
                    consonantCnt++;
                    vowelCnt = 0;
                }

                // 모음 자음 연속 최종 판별
                if(vowelCnt > 2 || consonantCnt > 2){
                    isAcceptable = false;
                    break;
                }

                // 3번 조건
                if(i > 0){
                    char c1 = password.charAt(i - 1);
                    if(c1 == c && !(c1 == 'e' || c1 == 'o')){
                        isAcceptable = false;
                        break;
                    }
                }
            }

            if(!checkVowel || !isAcceptable) result.append("<" + password + ">" + " is not acceptable.").append("\n");
            else result.append("<" + password + ">" + " is acceptable.").append("\n");



        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}
