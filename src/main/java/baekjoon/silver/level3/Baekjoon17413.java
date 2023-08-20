package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Baekjoon17413 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> characterStack = new Stack<>();
        StringBuilder stringBuilder;
        Character tempCharacter;

        String string = br.readLine();
        stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            tempCharacter = string.charAt(i);
            if (tempCharacter == '<') {     // 태그일 경우
                if (!characterStack.isEmpty()) {
                    while (!characterStack.isEmpty()) {
                        stringBuilder.append(characterStack.pop());
                    }
                }
                stringBuilder.append(tempCharacter);
                for (int j = i + 1; j < string.length(); j++) {
                    stringBuilder.append(string.charAt(j));
                    if (string.charAt(j) == '>') {
                        i = j;
                        break;
                    }
                }
            } else if (tempCharacter == ' ') {     // 공백일 경우
                if (!characterStack.isEmpty()) {
                    while (!characterStack.isEmpty()) {
                        stringBuilder.append(characterStack.pop());
                    }
                }
                stringBuilder.append(tempCharacter);
            } else {
                characterStack.push(tempCharacter);
            }
            if (i == string.length() - 1) {
                while (!characterStack.isEmpty()) {
                    stringBuilder.append(characterStack.pop());
                }
            }
        }

        bw.write(stringBuilder.toString());
        bw.newLine();

        bw.flush();
        bw.close();
    }
}
