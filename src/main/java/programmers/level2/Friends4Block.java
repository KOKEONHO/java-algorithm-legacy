package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Friends4Block {

    static final char EMPTY = 'X';
    static char[][] charBoard;

    public static void main(String[] args) {

        int m = 4, n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int result = solution(m, n, board);
        System.out.println(result);
    }

    static int solution(int m, int n, String[] board) {

        int result = 0;
        int savedResult;
        char initial;
        char right, below, diagonal;
        List<int[]> blockList;

        charBoard = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                charBoard[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            savedResult = result;
            blockList = new ArrayList<>();      // 행열 배열을 저장해놓는 리스트
            for (int i = 0; i < charBoard.length - 1; i++) {
                for (int j = 0; j < charBoard[i].length - 1; j++) {
                    initial = charBoard[i][j];
                    if (initial == EMPTY || charBoard[i][j + 1] == EMPTY || charBoard[i + 1][j] == EMPTY || charBoard[i + 1][j + 1] == EMPTY) {
                        continue;
                    }
                    right = charBoard[i][j + 1];        // 오른쪽
                    below = charBoard[i + 1][j];        // 아래
                    diagonal = charBoard[i + 1][j + 1];     // 대각선
                    if (initial != right || initial != below || initial != diagonal) {
                        continue;
                    }
                    if (!blockList.contains(new int[]{i, j})) {
                        blockList.add(new int[]{i, j});
                    }
                    if (!blockList.contains(new int[]{i, j + 1})) {
                        blockList.add(new int[]{i, j + 1});
                    }
                    if (!blockList.contains(new int[]{i + 1, j})) {
                        blockList.add(new int[]{i + 1, j});
                    }
                    if (!blockList.contains(new int[]{i + 1, j + 1})) {
                        blockList.add(new int[]{i + 1, j + 1});
                    }
                }
            }

            for (int i = 0; i < blockList.size(); i++) {
                int[] temporary = blockList.get(i);
                if (charBoard[temporary[0]][temporary[1]] == EMPTY) {
                    continue;
                }
                charBoard[temporary[0]][temporary[1]] = EMPTY;
                result++;
            }

            sortCharBoard(m, n);

            if (result == savedResult) {
                break;
            }
        }

        return result;
    }

    static void sortCharBoard(int m, int n) {

        List<Character> colList;
        int index;

        for (int i = 0; i < n; i++) {
            colList = new ArrayList<>();
            index = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (charBoard[j][i] != EMPTY) {
                    colList.add(charBoard[j][i]);
                }
            }
            if (colList.isEmpty()) {
                continue;
            }

            for (int j = m - 1; j >= 0; j--) {
                if (index < colList.size()) {
                    charBoard[j][i] = colList.get(index);
                    index++;
                    continue;
                }
                charBoard[j][i] = EMPTY;
            }
        }
    }
}
