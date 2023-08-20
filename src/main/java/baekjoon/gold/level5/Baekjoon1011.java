package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 정말 오래 고민하고 풀은 문제
 * 난이도에 조금 쫄은 것도 있지만 여러가지 생각해 본 로직들이 다 나사가 하나씩 빠져 있는지
 *
 */

public class Baekjoon1011 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x, y, distance, result;
        int T = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer;

        for (int i = 0; i < T; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            x = Integer.parseInt(stringTokenizer.nextToken());
            y = Integer.parseInt(stringTokenizer.nextToken());
            distance = y - x;
            result = solution(distance);
            bw.write(Integer.toString(result));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static int solution(int distance) {
        long x = 0;
        int step = 2;
        while (true) {
            x += step;
            if (x >= distance) {
                if (distance > x - (step / 2)) {
                    return step;
                }
                return step - 1;
            }
            step += 2;
        }
    }
}
