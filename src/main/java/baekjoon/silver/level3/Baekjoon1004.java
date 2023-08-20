package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1004 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        Point start, destination, planet;
        List<Point> planetList;
        int T, N, answer;
        double startDistance, destinationDistance;
        boolean startFlag, destinationFlag;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            answer = 0;
            planetList = new ArrayList<>();
            stringTokenizer = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
            destination = new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
            N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                planetList.add(new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
            }

            for (int j = 0; j < planetList.size(); j++) {
                planet = planetList.get(j);
                startDistance = Math.sqrt(Math.pow(planet.x - start.x, 2) + Math.pow(planet.y - start.y, 2));
                destinationDistance = Math.sqrt(Math.pow(planet.x - destination.x, 2) + Math.pow(planet.y - destination.y, 2));
                if (startDistance > planet.r) {
                    startFlag = false;
                } else {
                    startFlag = true;
                }
                if (destinationDistance > planet.r) {
                    destinationFlag = false;
                } else {
                    destinationFlag = true;
                }

                if (startFlag && destinationFlag) {
                    continue;
                }
                if (startFlag || destinationFlag) {
                    answer++;
                }
            }

            bw.write(Integer.toString(answer));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}

class Point {

    int x, y, r;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}