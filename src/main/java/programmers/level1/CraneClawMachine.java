package programmers.level1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class CraneClawMachine {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int result = solution(board, moves);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    static int solution(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        int cranePosition;

        for (int i = 0; i < moves.length; i++) {
            cranePosition = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                if (board[j][cranePosition] != 0) {
                    int temp = board[j][cranePosition];
                    board[j][cranePosition] = 0;
                    if (!basket.isEmpty()) {
                        if (basket.peek().intValue() == temp) {
                            basket.pop();
                            answer += 2;
                            break;
                        }
                    }
                    basket.push(temp);
                    break;
                }
            }
        }

        return answer;
    }
}
