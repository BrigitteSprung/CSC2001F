import dictionary.AbstractHashTable;
import dictionary.Definition;
import dictionary.Dictionary;
import dictionary.Entry;
import dictionary.Loader;
import dictionary.WordType;
//
import java.io.File;
import java.io.IOException;
//
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/**
 * Write a description of class AutoHarness here.
 * 
 * @author Stephan Jamieson	
 * @version 7/3/2016
 */
public abstract class AutoTest {

    protected AutoTest() {}	
    
    protected abstract AbstractHashTable makeTable(final int size);
    
			
    public void run() throws IOException {
		final Scanner scanner = new Scanner(System.in);
        assert(scanner.hasNextLine());
		final int size = Integer.parseInt(scanner.nextLine().trim());
		
        final AbstractHashTable table = makeTable(size);
        final Dictionary dictionary = table;
		final Loader loader = new Loader(dictionary);
		
        while (scanner.hasNextLine()) {
            Scanner parse = new Scanner(scanner.nextLine());
            assert(parse.hasNext());
            final String command = parse.next().trim().toUpperCase();
            if (command.equals("INSERT")) {
                assert(parse.hasNext());
				loader.load(parse.nextLine());
            }
            else if (command.equals("ISEMPTY")) {
				//System.out.print("isEmpty(): ");
				System.out.println(dictionary.isEmpty());
            }
            else if (command.equals("SIZE")) {
				//System.out.print("Size: ");
				System.out.println(dictionary.size());
            }
            else if (command.equals("DUMP")) {
				table.dump();
				System.out.println();
			}
            else if (command.equals("CONTAINS")) {
                assert(parse.hasNext());
                final String word = parse.next();
                //System.out.print("Contains \'"+word+"\': ");
                System.out.println(dictionary.containsWord(word));
            }
            else if (command.equals("GET")) {
                assert(parse.hasNext());
                final String word = parse.next();
				final List<Definition> definitions = dictionary.getDefinitions(word);
				if (definitions==null) {
					System.out.println(definitions);
				}
				else {
					for (Definition definition : definitions) {
						System.out.println(definition);
					}
				}
			}
            else if (command.equals("LOAD")) {
				assert(parse.hasNext());
				final File file = new File(parse.nextLine().trim());
				loader.load(file);
			}
        }
    }
    

}
