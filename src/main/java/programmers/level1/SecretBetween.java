package programmers.level1;

public class SecretBetween {
    public static void main(String[] args) {

        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        String result = solution(s, skip, index);

        System.out.println(result);
    }

    public static String solution(String s, String skip, int index) {

        /**
         * 문자열 s, 문자열 skip
         * 자연수 index
         *
         * 문자열 s의 각 알파벳을 index 만큼 뒤의 알파벳으로 교체
         * index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a
         * skip에 있는 알파벳은 제외하고 건너뜀
         */

        /**
         * s = "aukks"
         * skip = "wbqd"
         * index = 5
         */

        String answer = "";
        char target;
        int targetAscii;
        boolean flag;

        int[] skipAscii = new int[skip.length()];
        for(int i=0; i<skipAscii.length; i++) {
            skipAscii[i]=(int)skip.charAt(i);
        }       // skip 문자열의 문자들을 아스키 코드 배열로 생성

        for(int i=0; i<s.length(); i++) {
            target = s.charAt(i);       // 문자열 s에서 글자 하나를 선택
            targetAscii = target;       // target의 아스키 코드 값
            for(int j=0; j<index; j++) {
                flag = true;
                targetAscii++;
                if(targetAscii>'z') {       // 알파벳 z를 초과 시 -> 다시 a로
                    targetAscii = 'a';
                }
                for(int k=0; k<skipAscii.length; k++) {
                    if(targetAscii==skipAscii[k]) {
                        j--;
                        flag = false;
                        break;
                    }
                }
                if(!flag) {
                    continue;
                }
            }
            answer+=(char)targetAscii;
        }
        return answer;
    }
}
