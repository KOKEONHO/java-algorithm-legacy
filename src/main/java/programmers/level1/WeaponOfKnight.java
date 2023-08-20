package programmers.level1;

class WeaponOfKnight {

    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;

        int answer = solution(number, limit, power);

        System.out.println(answer);
    }
    public static int solution(int number, int limit, int power) {

        /**
         * number = 기사단원의 수
         * limit = 공격력의 제한 수치
         * power = 제한수치를 초과한 기사가 사용할 무기의 공격력
         */

        int answer = 0;
        int aliCount;       // 약수 갯수 세는 변수
        boolean flag;

        for (int i = 1; i <= number; i++) {
            aliCount = 0;
            flag = true;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    aliCount += 2;
                    if (j * j == i) {
                        aliCount--;
                    }
                    if (aliCount > limit) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) {
                answer += power;
                continue;
            }
            answer += aliCount;
        }


        return answer;
    }
}
