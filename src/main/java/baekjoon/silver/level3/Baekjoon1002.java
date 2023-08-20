package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon1002 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int x1, y1, r1, x2, y2, r2, totalR, bigR, smallR;
        double pointDistance;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            pointDistance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            totalR = r1 + r2;

            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) {
                    bw.write("-1");
                    bw.newLine();
                    continue;
                }
                bw.write("0");
                bw.newLine();
                continue;
            }
            if (pointDistance > totalR) {
                bw.write("0");
                bw.newLine();
                continue;
            }
            if (pointDistance == totalR) {
                bw.write("1");
                bw.newLine();
                continue;
            }
            if (pointDistance < totalR) {
                bigR = Math.max(r1, r2);
                smallR = Math.min(r1, r2);
                if (bigR == pointDistance + smallR) {
                    bw.write("1");
                    bw.newLine();
                    continue;
                }
                if (bigR > pointDistance + smallR) {
                    bw.write("0");
                    bw.newLine();
                    continue;
                }
                bw.write("2");
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
