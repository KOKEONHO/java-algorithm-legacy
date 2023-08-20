package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BridgeCrossingTruck {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        int result = solution(bridge_length, weight, truck_weights);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int timeCount = 0, trucksIndex = 0;
        Queue<Integer> onBridge = new LinkedList<>();
        Queue<Integer> timeCountIndex = new LinkedList<>();

        while (true) {
            timeCount++;
            if (!onBridge.isEmpty() && timeCount == timeCountIndex.peek()) {
                weight += onBridge.poll();
                timeCountIndex.poll();
            }
            if (trucksIndex < truck_weights.length) {
                if (weight - truck_weights[trucksIndex] >= 0) {
                    weight -= truck_weights[trucksIndex];
                    onBridge.add(truck_weights[trucksIndex]);
                    timeCountIndex.add(timeCount + bridge_length);
                    trucksIndex++;
                }
            }
            if (onBridge.isEmpty()) {
                break;
            }
        }

        return timeCount;
    }
}
