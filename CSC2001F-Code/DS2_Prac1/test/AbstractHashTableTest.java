import dictionary.AbstractHashTable;
import dictionary.Definition;
import dictionary.WordType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Brigitte on 2016/04/10.
 */
public class AbstractHashTableTest {
    AbstractHashTable table = new AbstractHashTable() {
        @Override
        protected int findIndex(String word) {
            return 0;
        }
    };
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void hashFunction() throws Exception {
        int hash = hashFunction("");
    }

    @Test
    public void tableSize() throws Exception {
        table.insert("Hello", new Definition( WordType.toWordType("n"), "Greeting"));
        assertTrue(tableSize()==1);
    }

    @Test
    public void containsWord() throws Exception {

    }

    @Test
    public void getDefinitions() throws Exception {

    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void empty() throws Exception {

    }

    @Test
    public void size() throws Exception {

    }

    @Test
    public void loadFactor() throws Exception {

    }

    @Test
    public void rebuild() throws Exception {

    }


}