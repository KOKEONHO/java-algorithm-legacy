package programmers.level1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class HamburgerMaking {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};

        int result = solution(ingredient);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    static int solution(int[] ingredient) {

        List<Integer> ingredientList = new ArrayList<>(Arrays.asList(1, 2, 3, 1));
        int ingredientNumber, burgerCount = 0;
        boolean checkBurgerMade = false;

        Stack<Integer> burger = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {
            ingredientNumber = ingredient[i];
            burger.push(ingredientNumber);
            if (ingredientNumber == 1 && burger.size() > 3) {
                List<Integer> burgerSubList = burger.subList(burger.size() - 4, burger.size());
                if (burgerSubList.equals(ingredientList)) {
                    for (int j = 0; j < 4; j++) {
                        burger.pop();
                    }
                    burgerCount++;
                    checkBurgerMade = true;
                }
            }
        }

        while (checkBurgerMade) {
            checkBurgerMade = false;
            for (int i = 0; i < burger.size() - 1; i++) {
                ingredientNumber = burger.get(i);
                if (ingredientNumber == 1 && i > 3) {
                    List<Integer> burgerSubList = burger.subList(burger.size() - 4, burger.size());
                    if (burgerSubList.equals(ingredientList)) {
                        for (int j = 0; j < 4; j++) {
                            burger.pop();
                        }
                        burgerCount++;
                        checkBurgerMade = true;
                    }
                }
            }
        }

        return burgerCount;
    }
}
