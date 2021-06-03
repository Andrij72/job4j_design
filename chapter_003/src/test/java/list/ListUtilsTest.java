package list;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 4));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3, 4), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> inp = new ArrayList<>(Arrays.asList(11, 22, 33));
        List<Integer> bazeArr = new ArrayList<>(Arrays.asList(1, 2, 3, 11, 22, 33));
        ListUtils.removeIf(bazeArr, s -> s % 2 == 0);
        assertThat(bazeArr, Is.is(Arrays.asList(1, 3, 11, 33)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> inp = new ArrayList<>(Arrays.asList(11, 22, 33));
        List<Integer> bazeArr = new ArrayList<>(Arrays.asList(1, 2, 3, 11, 22, 33));
        ListUtils.removeAll(bazeArr, inp);
        assertThat(bazeArr, Is.is(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> bazeArr = new ArrayList<>(Arrays.asList(1, 2, 3, 11, 22, 33));
        ListUtils.replaceIf(bazeArr, s -> s > 10, 0);
        assertThat(bazeArr, Is.is(Arrays.asList(1, 2, 3, 0, 0, 0)));
    }
}
