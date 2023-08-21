package programmers.level2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Process {

	public static void main(String[] args) {

		int[] priorities = {1,1,9,1,1,1};
		int location = 0;

		int answer = solution(priorities, location);

		System.out.println(answer);

	}

	static int solution(int[] priorities, int location) {

		Queue<Data> dataQueue = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			dataQueue.add(Data.of(priorities[i], i));
		}

		int count = 0;
		Iterator<Data> iterator;
		boolean flag;

		while (!dataQueue.isEmpty()) {
			flag = true;
			Data poll = dataQueue.poll();
			iterator = dataQueue.iterator();
			while (iterator.hasNext()) {
				if (poll.value < iterator.next().value) {
					dataQueue.add(poll);
					flag = !flag;
					break;
				}
			}
			if (flag) {
				count++;
				if (poll.initialIndex == location) {
					break;
				}
			}
		}

		return count;

	}

}

class Data {

	int value;
	int initialIndex;

	private Data(int value, int initialIndex) {
		this.value = value;
		this.initialIndex = initialIndex;
	}

	public static Data of(int value, int initialIndex) {
		return new Data(value, initialIndex);
	}

}
