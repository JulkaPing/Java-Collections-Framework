package set.uniquenumbers;

import java.util.*;

public class UniqueTerminal {


    public Set<Integer> getUniqueNumbersByDesc(int[] numbers) {
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        for (Integer value: numbers) {
           navigableSet.add(value);
        }

        return navigableSet.descendingSet();
    }
}