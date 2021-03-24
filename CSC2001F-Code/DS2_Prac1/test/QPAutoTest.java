import dictionary.AbstractHashTable;
import dictionary.Dictionary;
import dictionary.QPHashTable;
//
import java.io.IOException;
//
public class QPAutoTest extends AutoTest {


	protected AbstractHashTable makeTable(final int size) {
		return new QPHashTable(size);
	}
	
	public static void main(final String[] args) throws IOException {
		(new QPAutoTest()).run();
	}
}
