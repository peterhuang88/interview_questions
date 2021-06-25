import java.util.*;

public class mypq {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(5);
		pq.add(3);
		pq.add(1);

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
