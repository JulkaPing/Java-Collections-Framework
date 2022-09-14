package set.mathset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Выполняет операции с множествами
 */
public class Operations {
    /**
     * Пересечение множеств
     */
    public Set<Integer> intersection(Set<Integer> firstSet, Set<Integer> secondSet) {
        //return firstSet.stream().filter(secondSet::contains).collect(Collectors.toSet());

        Set<Integer> tmp = new TreeSet<>();
        for (Integer value: firstSet)
            if (secondSet.contains(value))
                tmp.add(value);
        return tmp;

    }

    /**
     * Симметричная разность множеств
     */
    public Set<Integer> simmetricalDifference(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> tmpFirst;
        Set<Integer> tmpSecond;

        tmpFirst = union(firstSet, secondSet);
        tmpSecond = intersection(firstSet, secondSet);
        return subtract(tmpFirst, tmpSecond);
    }

    /**
     * Объединение множеств
     */
    public Set<Integer> union(Set<Integer> firstSet, Set<Integer> secondSet) {
        //return Stream.concat(firstSet.stream(), secondSet.stream()).collect(Collectors.toSet());
        Set<Integer> tmp = new TreeSet<>(firstSet);
        tmp.addAll((secondSet));
        return tmp;
    }

    /**
     * Разность множеств
     */
    public Set<Integer> subtract(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> tmp = new TreeSet<>(firstSet);
        tmp.removeAll(secondSet);
        return tmp;
    }
}