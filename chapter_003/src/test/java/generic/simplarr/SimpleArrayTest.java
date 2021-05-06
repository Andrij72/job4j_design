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
        smplArr = new Integer[3];
        arr = new SimpleArray(smplArr, 3);
        arr.add(100);
        arr.add(200);
        System.out.println(Arrays.asList(smplArr).toString());
        assertThat(arr.get(1), is(200));
        assertThat(Arrays.asList(smplArr).toString(), is("[100, 200, null]"));
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
