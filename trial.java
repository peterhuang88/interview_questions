import java.util.*;

public class trial {
	public static void main(String[] args) {
		Map<Integer, String> meme = new HashMap<>();

		meme.put(1, "meme");
		meme.put(2, "lol");
		meme.put(3, "kek");

		for (String word : meme.values()) {
			System.out.println(word);
		}
	}
}
