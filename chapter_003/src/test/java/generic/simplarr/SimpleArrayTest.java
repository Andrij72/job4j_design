package generic.simplarr;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SimpleArrayTest {

    SimpleArray arr;

    @Before
    public void setUp() {
         arr = new SimpleArray(3);
    }

    @Test
    public void whenAddElementThanHaveItInArray() {
        arr.add(100);
        arr.add(200);
        assertThat(arr.get(1), is(200));

    }
    @Test
    public void whenSetElementWithIndexFourThenHaveOneOneOne() {
        arr.add(10);
        arr.add(20);
        arr.set(1, 111);
        assertThat(arr.get(1), is(111));
    }

    @Test
    public void whenRemoveElementWithIndexThreeThanHaveFive() {
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.remove(1);
        assertThat(arr.get(1), is(30));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveElementWithIndexOutOfBounds() {
        arr.remove(6);
    }
}
