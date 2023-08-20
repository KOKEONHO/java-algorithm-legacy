package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterNumber {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = {9, 1, 5, 3, 6, 2};

        int[] result = solution(numbers);

        bw.write(Arrays.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] numbers) {
        // 어떻게 하면 시간 초과가 나지 않게 Stack을 써서 풀 수 있을까 ?
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            answer[i] = stack.empty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }

        return answer;
    }
}
