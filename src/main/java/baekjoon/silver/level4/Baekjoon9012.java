package baekjoon.silver.level4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Baekjoon9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> characterStack;
        String parenthesisString = null;
        boolean checkYesOrNo = true;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            checkYesOrNo = true;
            int flag = 0;
            characterStack = new Stack<>();
            parenthesisString = br.readLine();
            for (int j = 0; j < parenthesisString.length(); j++) {
                char tempChar = parenthesisString.charAt(j);
                characterStack.push(tempChar);
            }
            char charFromStack;
            while (!characterStack.isEmpty()) {
                charFromStack = characterStack.pop();
                if (charFromStack == ')') {
                    flag++;
                    continue;
                }
                if (charFromStack == '(') {
                    flag--;
                    if (flag < 0) {
                        checkYesOrNo = false;
                        break;
                    }
                }
            }
            if (checkYesOrNo && flag == 0) {
                bw.write("YES");
                bw.newLine();
                continue;
            }
            bw.write("NO");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
