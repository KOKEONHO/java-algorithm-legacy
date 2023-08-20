package programmers.level1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Keypad {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = solution(numbers, hand);

        bw.write(result);
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static String solution(int[] numbers, String hand) {

        StringBuilder leftRightResult = new StringBuilder();
        String[] keyPad = {"123", "456", "789", "*0#"};
        String leftIndex = "30";
        String rightIndex = "32";

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (checkLeftNumber(number)) {
                leftRightResult.append("L");
                leftIndex = findRowColIndex(number, keyPad);
                continue;
            }
            if (checkRightNumber(number)) {
                leftRightResult.append("R");
                rightIndex = findRowColIndex(number, keyPad);
                continue;
            }
            String middleNumberIndex = findRowColIndex(number, keyPad);
            int leftDistance = calculateDistance(leftIndex, middleNumberIndex);
            int rightDistance = calculateDistance(rightIndex, middleNumberIndex);
            int distance = leftDistance - rightDistance;
            if (distance > 0) {
                leftRightResult.append("R");
                rightIndex = middleNumberIndex;
                continue;
            }
            if (distance < 0) {
                leftRightResult.append("L");
                leftIndex = middleNumberIndex;
                continue;
            }
            if (hand.equals("right")) {
                leftRightResult.append("R");
                rightIndex = middleNumberIndex;
                continue;
            }
            if (hand.equals("left")) {
                leftRightResult.append("L");
                leftIndex = middleNumberIndex;
            }
        }

        return leftRightResult.toString();
    }

    private static boolean checkLeftNumber(int number) {
        if (number == 1 || number == 4 || number == 7) {
            return true;
        }
        return false;
    }

    private static boolean checkRightNumber(int number) {
        if (number == 3 || number == 6 || number == 9) {
            return true;
        }
        return false;
    }

    private static String findRowColIndex(int number, String[] keyPad) {
        StringBuilder resultStringBuilder = new StringBuilder();
        int keyPadIndex = 0;
        String numberString = String.valueOf(number);
        for (int i = 0; i < keyPad.length; i++) {
            if (keyPad[i].contains(numberString)) {
                keyPadIndex = i;
                resultStringBuilder.append(keyPadIndex);
            }
        }
        String keyPadString = keyPad[keyPadIndex];
        for (int i = 0; i < keyPadString.length(); i++) {
            if (keyPadString.charAt(i) == numberString.charAt(0)) {
                resultStringBuilder.append(i);
                break;
            }
        }

        return resultStringBuilder.toString();
    }

    private static int calculateDistance(String index, String numberIndex) {
        int indexRow = Integer.parseInt(String.valueOf(index.charAt(0)));
        int indexCol = Integer.parseInt(String.valueOf(index.charAt(1)));
        int numberIndexRow = Integer.parseInt(String.valueOf(numberIndex.charAt(0)));
        int numberIndexCol = Integer.parseInt(String.valueOf(numberIndex.charAt(1)));

        return Math.abs(indexRow - numberIndexRow) + Math.abs(indexCol - numberIndexCol);
    }
}
