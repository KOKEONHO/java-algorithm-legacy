package programmers.level2;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SaleEvent {
	public static void main(String[] args) {

		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
			"pot", "banana", "apple", "banana"};

		int answer = solution(want, number, discount);
		System.out.println(answer);

	}

	static int solution(String[] want, int[] number, String[] discount) {

		int answer = 0;
		int totalNumber = 0;
		for (int i = 0; i < want.length; i++) {
			totalNumber += number[i];
		}
		List<String> wantList = new ArrayList<>(Arrays.asList(want));
		boolean flag;

		for (int i = 0; i <= discount.length - totalNumber; i++) {
			flag = true;
			int[] temporaryNumber = number.clone();
			String[] temporaryDiscount = Arrays.copyOfRange(discount, i, i + totalNumber);
			for (int j = 0; j < temporaryDiscount.length; j++) {
				if (wantList.contains(temporaryDiscount[j])) {
					temporaryNumber[wantList.indexOf(temporaryDiscount[j])]--;
				}
			}
			for (int j = 0; j < temporaryNumber.length; j++) {
				if (temporaryNumber[j] > 0) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				continue;
			}
			answer++;
		}

		return answer;

	}
}
