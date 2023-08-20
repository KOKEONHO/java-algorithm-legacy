package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));

		list.stream()
			.filter("b"::equals)
			.forEach(System.out::println);

	}

}
