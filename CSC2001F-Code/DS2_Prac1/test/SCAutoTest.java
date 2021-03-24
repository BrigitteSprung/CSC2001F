import dictionary.AbstractHashTable;
import dictionary.ChainedEntry;
import dictionary.Dictionary;
import dictionary.SCHashTable;
//
//
import java.io.IOException;
//
public class SCAutoTest extends AutoTest {


	private class DumpableSCHashTable extends SCHashTable {
		
		protected DumpableSCHashTable() { super(); }
		protected DumpableSCHashTable(final int size) { super(size); }
		
	    /**
		 * Prints contents of table to screen. (Method provided to facilitate testing and debugging.)
		 */
		@Override
		public void dump() {
			ChainedEntry[] table = this.table;
			for(int i=0; i<tableSize(); i++) {
				if (table[i]==null) {
					System.out.printf("\n%6d : %s", i, table[i]);
				}
				else {
					ChainedEntry entry = table[i];
					while (entry!=null) {
						System.out.printf("\n%6d : %s", i, entry);
						entry = entry.getNext();
					}
				}
			}
			System.out.printf("\n#Entries: %d.", this.entries);
		}
	}

	protected AbstractHashTable makeTable(final int size) {
		return new DumpableSCHashTable(size);
	}
	
	public static void main(final String[] args) throws IOException {
		(new SCAutoTest()).run();
	}
}
