import dictionary.AbstractHashTable;
import dictionary.Dictionary;
import dictionary.LPHashTable;
//
import java.io.IOException;
//
public class LPAutoTest extends AutoTest {


	protected AbstractHashTable makeTable(final int size) {
		return new LPHashTable(size);
	}
	
	public static void main(final String[] args) throws IOException {
		(new LPAutoTest()).run();
	}
}
