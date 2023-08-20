package baekjoon.bronze.level2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon1009 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> lastNumberArrayList;
        StringTokenizer tokenizerAB;

        int a, b, step, index, size;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            lastNumberArrayList = new ArrayList<>();
            tokenizerAB = new StringTokenizer(br.readLine());
            a = Integer.parseInt(tokenizerAB.nextToken());
            if ((a %= 10) == 0) {
                bw.write("10");
                bw.newLine();
                continue;
            }
            b = Integer.parseInt(tokenizerAB.nextToken());
            a %= 10;
            step = a;
            while (!lastNumberArrayList.contains(a)) {
                lastNumberArrayList.add(a);
                a *= step;
                a %= 10;
            }
            size = lastNumberArrayList.size();
            index = b % size;
            if (index == 0) {
                index += size;
            }
            index--;
            bw.write(Integer.toString(lastNumberArrayList.get(index)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
