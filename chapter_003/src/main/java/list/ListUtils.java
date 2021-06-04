package list;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListUtils {
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.next();
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filterr) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filterr.test((T) i.next())) {
                i.remove();
            }
        }

    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();

        while (i.hasNext()) {
            if (filter.test((T) i.next())) {
                i.set(value);
            }
        }

    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T elmF = i.next();
            boolean fltr = elements.contains(elmF);
            if (fltr) {
                i.remove();
            }
        }

    }

    public static void main(String[] args) {
        List<Integer> lst = Stream.of(1, 2, 4).collect(Collectors.toCollection(ArrayList::new));
        addBefore(lst, 2, 3);
        lst.stream().peek(s -> System.out.println(s)).collect(Collectors.toList());
        System.out.println("******");

        // addAfter
        List<Integer> lt = Stream.of(1, 2, 4, 5).collect(Collectors.toCollection(ArrayList::new));
        addAfter(lt, 1, 3);
        lt.stream().peek(s -> System.out.println(s)).collect(Collectors.toList());

// removeIf
        System.out.println("******");
        List<Integer> lst1 = Stream.of(11, 33, 44, 100, 55, 44).collect(Collectors.toCollection(ArrayList::new));
        removeIf(lst1, s -> s == 44);
        lst1.stream().peek(s -> System.out.println(s)).collect(Collectors.toList());
        // removeAll
        System.out.println("******");
        List<Integer> inpt = Stream.of(11, 33, 44).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> bz = new ArrayList<>(Arrays.asList(1, 2, 3, 11, 33, 44));
        removeAll(bz, inpt);
        bz.stream().peek(s -> System.out.println(s)).collect(Collectors.toList());
    }

}
