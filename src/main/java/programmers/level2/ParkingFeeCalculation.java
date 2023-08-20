package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParkingFeeCalculation {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] result = solution(fees, records);

        bw.write(Arrays.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] fees, String[] records) {

        String carNumber, inTime, outTime;
        int totalTime, fee;

        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];


        Map<String, String> carNumberWithTime = new HashMap<>();
        Map<String, Integer> carNumberWithTotalTime = new HashMap<>();
        for (String record : records) {
            String[] splittedRecord = record.split(" ");        // 시각 | 차량 번호 | 내역
            carNumber = splittedRecord[1];      // 차량 번호
            if (splittedRecord[2].equals("IN")) {       // 차량 입차 시
                if (!carNumberWithTotalTime.containsKey(carNumber)) {        // carNumberWithCost에 해당 carNumber가 없다면 추가
                    carNumberWithTotalTime.put(carNumber, 0);
                }
                carNumberWithTime.put(carNumber, splittedRecord[0]);        // carNumberWithTime에 입차 시간과 차량 번호 등록
                continue;
            }
            // 차량 출차 시
            outTime = splittedRecord[0];        // 출차 시간
            inTime = carNumberWithTime.get(carNumber);      // 입차 시간
            totalTime = calculateTime(inTime, outTime);     // 분으로 나타낸 총 시간
            totalTime += carNumberWithTotalTime.get(carNumber);
            carNumberWithTotalTime.put(carNumber, totalTime);
            carNumberWithTime.remove(carNumber);
        }
        if (!carNumberWithTime.isEmpty()) {     // 비어있지 않다면 -> 23:59분에 출차했다는 뜻으로 간주
            for (Map.Entry<String, String> entry : carNumberWithTime.entrySet()) {
                carNumber = entry.getKey();
                outTime = "23:59";
                inTime = carNumberWithTime.get(carNumber);
                totalTime = calculateTime(inTime, outTime);
                totalTime += carNumberWithTotalTime.get(carNumber);
                carNumberWithTotalTime.put(carNumber, totalTime);
//                carNumberWithTime.remove(carNumber);
            }
        }

        Set<Map.Entry<String, Integer>> entrySet = carNumberWithTotalTime.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            carNumber = entry.getKey();
            totalTime = entry.getValue();
            if (totalTime <= defaultTime) {     // 총 주차 시간이 기본 시간보다 작거나 같을 경우
                fee = defaultFee;
                carNumberWithTotalTime.put(carNumber, fee);
                continue;
            }
            // 총 주차 시간이 기본 시간보다 클 경우
            fee = defaultFee;
            if ((totalTime - defaultTime) % unitTime != 0) {        // 올림이 필요한 경우
                fee += ((totalTime - defaultTime) / unitTime + 1) * unitFee;
            } else {
                fee += (totalTime - defaultTime) / unitTime * unitFee;
            }
            carNumberWithTotalTime.put(carNumber, fee);
        }


        entrySet = carNumberWithTotalTime.entrySet();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);

        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        int[] result = new int[carNumberWithTotalTime.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = entryList.get(i).getValue();
        }

        return result;
    }

    public static int calculateTime(String inTime, String outTime) {
        int totalTime;
        String[] splittedInTime = inTime.split(":");
        String[] splittedOutTime = outTime.split(":");
        int hours = Integer.parseInt(splittedOutTime[0]) - Integer.parseInt(splittedInTime[0]);
        int minutes = Integer.parseInt(splittedOutTime[1]) - Integer.parseInt(splittedInTime[1]);
        if (minutes < 0) {
            hours -= 1;
            minutes += 60;
        }
        totalTime = hours * 60 + minutes;
        return totalTime;
    }
}
