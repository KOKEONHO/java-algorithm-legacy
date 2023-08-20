package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class ContinuousSubsequence {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] elements = {7, 9, 1, 1, 4};
        int result = solution(elements);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int solution(int[] elements) {

        Set<Integer> totalSet = new HashSet<>();
        int size = 1, total = 0, indexJ;
        while (size <= elements.length) {
            total = 0;
            for (int i = 0; i < elements.length; i++) {
                if (i > 0) {
                    total -= elements[i - 1];
                }
                for (int j = i; j < i + size; j++) {
                    if (j < elements.length) {
                        if (i > 0 && j < i + size - 1) {
                            continue;
                        }
                        total += elements[j];
                        continue;
                    }
                    indexJ = j - elements.length;
                    if (indexJ < (i + size) - elements.length - 1) {
                        continue;
                    }
                    total += elements[indexJ];
                }
                totalSet.add(total);
            }
            size++;
        }
        return totalSet.size();
    }
}
