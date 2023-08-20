package programmers.level1;

class NumberPartner {
    public String solution(String X, String Y) {

        int[] numberCountX = new int[10];
        int[] numberCountY = new int[10];

        for (int i = 0; i < X.length(); i++) {
            char temporary = X.charAt(i);
            numberCountX[Character.getNumericValue(temporary)]++;
        }

        for (int i = 0; i < Y.length(); i++) {
            char temporary = Y.charAt(i);
            numberCountY[Character.getNumericValue(temporary)]++;
        }

        StringBuilder answerStringBuilder = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int count;
            if (numberCountX[i] >= numberCountY[i]) {
                count = numberCountY[i];
            } else {
                count = numberCountX[i];
            }
            if (count == 0) {
                continue;
            }
            for (int j = 0; j < count; j++) {
                answerStringBuilder.append(i);
            }
        }

        if (answerStringBuilder.toString().startsWith("0")) {
            return "0";
        }

        if (answerStringBuilder.toString().equals("")) {
            return "-1";
        }

        return answerStringBuilder.toString();
    }
}