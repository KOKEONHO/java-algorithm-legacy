package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon1966 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int printCount = 0;
            boolean nowNodeIsMax;

            LinkedList<int[]> printerQueue = new LinkedList<>();
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                printerQueue.offer(new int[]{i, Integer.parseInt(stringTokenizer.nextToken())});
            }

            while (!printerQueue.isEmpty()) {
                nowNodeIsMax = true;
                int[] nowNode = printerQueue.poll();
                for (int i = 0; i < printerQueue.size(); i++) {
                    int[] comparisonNode = printerQueue.get(i);
                    if (nowNode[1] < comparisonNode[1]) {
                        printerQueue.offer(nowNode);
                        nowNodeIsMax = false;
                        break;
                    }
                }
                if (nowNodeIsMax) {
                    printCount++;
                    if (nowNode[0] == M) {
                        break;
                    }
                }
            }
            bw.write(Integer.toString(printCount));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
