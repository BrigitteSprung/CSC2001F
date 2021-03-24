import dictionary.AbstractHashTable;
//
import java.util.Scanner;
//
public class TestHashFunction extends AbstractHashTable {

	protected int findIndex(final String word) {
		throw new IllegalStateException("Not actually using this.");
	}
	
	public TestHashFunction(final int size) {
		super(size);
	}
	
	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final TestHashFunction test = new TestHashFunction(scanner.nextInt());
		while (scanner.hasNext()) {
			System.out.println(test.hashFunction(scanner.next()));
		}
	}

}
