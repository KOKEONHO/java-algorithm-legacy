package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon1063 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] chessBoard = new char[8][8];
        String command;

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        String kingPosition = st.nextToken();
        String stonePosition = st.nextToken();
        int test = Integer.parseInt(st.nextToken());

        int[] kingPositionArray = {8 - Character.getNumericValue(kingPosition.charAt(1)), getIndex(kingPosition)};
        int[] stonePositionArray = {8 - Character.getNumericValue(stonePosition.charAt(1)), getIndex(stonePosition)};

        for (int i = 0; i < test; i++) {
            command = br.readLine();
            if (command.length() == 2) {
                checkTwoCommand(command, kingPositionArray, stonePositionArray);
                continue;
            }
            checkOneCommand(command.charAt(0), kingPositionArray, stonePositionArray);
        }

        bw.write(makeString(kingPositionArray));
        bw.newLine();
        bw.write(makeString(stonePositionArray));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static void checkTwoCommand(String command, int[] king, int[] stone) {
        switch (command) {
            case "LT":
                if (king[0] > 0 && king[1] > 0) {       // 무조건 만족시켜야 하는 조건
                    if (king[0] - 1 == stone[0] && king[1] - 1 == stone[1]) {       // LT 위치에 돌이 있을 때
                        if (stone[0] > 0 && stone[1] > 0) {
                            king[0] -= 1;
                            king[1] -= 1;
                            stone[0] -= 1;
                            stone[1] -= 1;
                            return;
                        }
                        return;
                    }
                    king[0] -= 1;
                    king[1] -= 1;
                    return;
                }
                return;
            case "RT":
                if (king[0] > 0 && king[1] < 7) {
                    if (king[0] - 1 == stone[0] && king[1] + 1 == stone[1]) {
                        if (stone[0] > 0 && stone[1] < 7) {
                            king[0] -= 1;
                            king[1] += 1;
                            stone[0] -= 1;
                            stone[1] += 1;
                            return;
                        }
                        return;
                    }
                    king[0] -= 1;
                    king[1] += 1;
                    return;
                }
                return;
            case "RB":
                if (king[0] < 7 && king[1] < 7) {
                    if (king[0] + 1 == stone[0] && king[1] + 1 == stone[1]) {
                        if (stone[0] < 7 && stone[1] < 7) {
                            king[0] += 1;
                            king[1] += 1;
                            stone[0] += 1;
                            stone[1] += 1;
                            return;
                        }
                        return;
                    }
                    king[0] += 1;
                    king[1] += 1;
                    return;
                }
                return;
            case "LB":
                if (king[0] < 7 && king[1] > 0) {
                    if (king[0] + 1 == stone[0] && king[1] - 1 == stone[1]) {
                        if (stone[0] < 7 && stone[1] > 0) {
                            king[0] += 1;
                            king[1] -= 1;
                            stone[0] += 1;
                            stone[1] -= 1;
                            return;
                        }
                        return;
                    }
                    king[0] += 1;
                    king[1] -= 1;
                }
        }
    }

    public static void checkOneCommand(char command, int[] king, int[] stone) {
        switch (command) {
            case 'L':
                if (king[1] == 0) {     // 0열에 있을 때 움직일 수 없음
                    return;
                }
                if (king[0] == stone[0] && king[1] - 1 == stone[1]) {        // 돌을 밀고 움직여야 할 때
                    if (stone[1] > 0) {
                        king[1] -= 1;
                        stone[1] -= 1;
                        return;
                    }
                    return;
                }
                king[1] -= 1;
                return;
            case 'T':
                if (king[0] == 0) {
                    return;
                }
                if (king[0] - 1 == stone[0] && king[1] == stone[1]) {
                    if (stone[0] > 0) {
                        king[0] -= 1;
                        stone[0] -= 1;
                        return;
                    }
                    return;
                }
                king[0] -= 1;
                return;
            case 'R':
                if (king[1] == 7) {
                    return;
                }
                if (king[0] == stone[0] && king[1] + 1 == stone[1]) {
                    if (stone[1] < 7) {
                        king[1] += 1;
                        stone[1] += 1;
                        return;
                    }
                    return;
                }
                king[1] += 1;
                return;
            case 'B':
                if (king[0] == 7) {
                    return;
                }
                if (king[0] + 1 == stone[0] && king[1] == stone[1]) {
                    if (stone[0] < 7) {
                        king[0] += 1;
                        stone[0] += 1;
                        return;
                    }
                    return;
                }
                king[0] += 1;
        }
    }

    public static int getIndex(String position) {
        char ch = position.charAt(0);
        switch (ch) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
        }
        return -1;
    }

    public static String makeString(int[] positionArray) {
        StringBuilder sb = new StringBuilder();
        if(positionArray[1]==0) {
            sb.append("A");
        }
        if(positionArray[1]==1) {
            sb.append("B");
        }
        if(positionArray[1]==2) {
            sb.append("C");
        }
        if(positionArray[1]==3) {
            sb.append("D");
        }
        if(positionArray[1]==4) {
            sb.append("E");
        }
        if(positionArray[1]==5) {
            sb.append("F");
        }
        if(positionArray[1]==6) {
            sb.append("G");
        }
        if(positionArray[1]==7) {
            sb.append("H");
        }
        int number = 8-positionArray[0];
        sb.append(Integer.toString(number));
        return sb.toString();
    }
}
