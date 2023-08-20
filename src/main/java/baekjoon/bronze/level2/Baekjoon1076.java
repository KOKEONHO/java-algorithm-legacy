package baekjoon.bronze.level2;

import java.io.*;
import java.util.HashMap;

public class Baekjoon1076 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String color;
        StringBuilder result = new StringBuilder();
        HashMap<String, Integer> colorValue = new HashMap<>();
        colorValue.put("black", 0);
        colorValue.put("brown", 1);
        colorValue.put("red", 2);
        colorValue.put("orange", 3);
        colorValue.put("yellow", 4);
        colorValue.put("green", 5);
        colorValue.put("blue", 6);
        colorValue.put("violet", 7);
        colorValue.put("grey", 8);
        colorValue.put("white", 9);

        for (int i = 0; i < 3; i++) {
            color = br.readLine();
            if (i < 2) {
                result.append(colorValue.get(color));
                continue;
            }
            HashMap<String, Long> colorMultiply = new HashMap<>();
            colorMultiply.put("black", 1L);
            colorMultiply.put("brown", 10L);
            colorMultiply.put("red", 100L);
            colorMultiply.put("orange", 1000L);
            colorMultiply.put("yellow", 10000L);
            colorMultiply.put("green", 100000L);
            colorMultiply.put("blue", 1000000L);
            colorMultiply.put("violet", 10000000L);
            colorMultiply.put("grey", 100000000L);
            colorMultiply.put("white", 1000000000L);
            Long firstPart = Long.parseLong(result.toString());
            Long temporary = firstPart * colorMultiply.get(color);
            bw.write(Long.toString(temporary));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
