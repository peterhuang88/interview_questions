import java.util.*;
import java.util.Map.Entry;

public class sort_hashmap {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(5, "ant");
		map.put(2, "lol");
		map.put(3, "excalibur");
		map.put(1, "meme");

		Comparator<Entry<Integer, String>> comp = new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> e1, Entry<Integer, String> e2) {
				// String v1 = e1.getKey().toString();
				String v1 = e1.getValue();
				// String v2 = e2.getKey().toString();
				String v2 = e2.getValue();
				// return v1.compareTo(v2);
				return v2.compareTo(v1);
			}
		};

		// get Entry Set
		Set<Entry<Integer, String>> entries = map.entrySet();
		List<Entry<Integer, String>> listEntries = new ArrayList<Entry<Integer, String>>(entries);
		
		Collections.sort(listEntries, comp);
		
		for (Entry<Integer, String> ent : listEntries) {
			System.out.println(ent.getKey() + " " + ent.getValue());
		}
	}
}
