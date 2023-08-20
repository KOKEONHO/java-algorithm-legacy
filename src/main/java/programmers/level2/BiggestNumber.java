package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[1001];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        String result = solution(numbers);

        bw.write(result);
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static String solution(int[] numbers) {

        String[] stringArray = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            stringArray[i] = Integer.toString(numbers[i]);
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String string12 = o1 + o2;
                String string21 = o2 + o1;
                if (Integer.parseInt(string12) > Integer.parseInt(string21)) {
                    return -1;
                }
                if (Integer.parseInt(string12) < Integer.parseInt(string21)) {
                    return 1;
                }
                return 0;
            }
        };

        Arrays.sort(stringArray, comp);
        if (stringArray[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            result.append(stringArray[i]);
        }

        return result.toString();
    }
}
