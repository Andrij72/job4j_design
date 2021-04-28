package generic.simplarr;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class SimpleArrayTest {

    SimpleArray arr;
    Integer[] smplArr;

    @Before
    public void setUp() {
        smplArr = new Integer[]{1, 2, 3, 4, 5, null};
        arr = new SimpleArray(smplArr, 6);
    }

    @Test
    public void whenAddElementThanHaveItInArray() {
        arr.add(100);
        assertThat(arr.get(5), is(100));
        assertThat(Arrays.asList(smplArr).toString(), is("[1, 2, 3, 4, 5, 100]"));
    }

    @Test
    public void whenSetElementWithIndexFourThenHaveOneOneOne() {
        arr.set(4, 111);
        assertThat(arr.get(4), is(111));
        assertThat(Arrays.asList(smplArr).toString(), is("[1, 2, 3, 4, 111, null]"));
    }

    @Test
    public void whenRemoveElementWithIndexThreeThanHaveFive() {
        arr.remove(3);
        assertThat(arr.get(3), is(5));
        assertThat(Arrays.asList(smplArr).toString(), is("[1, 2, 3, 5, null, null]"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveElementWithIndexOutOfBounds() {
        arr.remove(6);
    }
}
