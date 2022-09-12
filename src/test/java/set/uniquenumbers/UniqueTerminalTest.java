package set.uniquenumbers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class UniqueTerminalTest {

    @Test
    public void uniqueNumbers() {

        int[] numbers = {5, -3, 12, 10, 83, -1, 0, 8, 53, 6, 17, -33};

        UniqueTerminal uniqueTerminal = new UniqueTerminal();

        Set<Integer> expected = new HashSet<>(Arrays.asList(83, 53, 17, 12, 10, 8, 6, 5, 0, -1, -3, -33));
        Set<Integer> result = uniqueTerminal.getUniqueNumbersByDesc(numbers);

        Assert.assertEquals(expected, result);
        System.out.println(result);
    }

}