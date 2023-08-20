package programmers.level1;

public class StringSplit {
    public static void main(String[] args) {

        String s = "abracadabra";
        int result = solution(s);
        System.out.println(result);
    }

    static int solution(String s) {

        int same, different;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            boolean flag2 = false;
            same = 0;
            different = 0;
            char target = s.charAt(i);
            same++;
            for (int j = i + 1; j < s.length(); j++) {
                flag = true;
                char temporary = s.charAt(j);
                if (target == temporary) {
                    same++;
                } else {
                    different++;
                }
                if (same == different) {
                    s = s.substring(j + 1, s.length());
                    result++;
                    i = -1;
                    break;
                }
                if (j == s.length() - 1) {
                    result++;
                    flag2 = true;
                }
            }
            if (!flag) {
                result++;
            }
            if (flag2) {
                break;
            }
        }

        return result;
    }
}
