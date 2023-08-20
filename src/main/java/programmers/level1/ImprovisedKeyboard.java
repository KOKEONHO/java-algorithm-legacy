package programmers.level1;

import java.util.Arrays;

class ImprovisedKeyboard {

    public static void main(String[] args) {

        String[] keyMap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};

        int[] result = solution(keyMap, targets);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] keyMap, String[] targets) {

        /**
         * 1번 키에 "A","B","C" 순서대로 문자가 할당
         * 1번 키를 한 번 누르면 "A", 두 번 누르면 "B", 세 번 누르면 "C"
         *
         * 이러한 휴대폰 자판은 1개 ~ 100개
         * 특정 키를 눌렀을 때 입력되는 문자들도 무작위로 배열
         * 같은 문자가 자판 전체에 여러 번 할당 될 수 있음
         * 키 하나에 같은 문자가 여러 번 할당 될 수 있음
         * 아예 할당되지 않은 경우도 존재
         * ∴ 몇몇 문자열은 작성할 수 없을 수 있음
         *
         * 1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열 배열 - keyMap
         * 입력하려는 문자열들이 담긴 문자열 배열 - targets
         *
         * 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return
         * 목표 문자열을 작성할 수 없을 경우 -1
         *
         *
         * keyMap = {"ABACD", "BCEFD"}
         * target = {"ABCD", "AABB"}
         * result = {9, 4}
         */

        String targetString, searchString;      // 입력해야 하는 문자열
        int answer, searchIndex = 0, temporaryIndex;
        char targetCharacter;       // 입력해야 하는 글자
        int[] result = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            answer = 0;
            targetString = targets[i];
            for (int j = 0; j < targetString.length(); j++) {
                targetCharacter = targetString.charAt(j);
                searchIndex = Integer.MAX_VALUE;
                for (int k = 0; k < keyMap.length; k++) {
                    searchString = keyMap[k];
                    temporaryIndex = searchString.indexOf(targetCharacter);
                    if (temporaryIndex == -1) {
                        continue;
                    }
                    if (searchIndex > temporaryIndex) {
                        searchIndex = temporaryIndex;
                    }
                }
                if (searchIndex == Integer.MAX_VALUE) {
                    break;
                }
                answer += (searchIndex + 1);
            }
            if (searchIndex == Integer.MAX_VALUE) {
                result[i] = -1;
                continue;
            }
            result[i] = answer;
        }

        return result;
    }
}