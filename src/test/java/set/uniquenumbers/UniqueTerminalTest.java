package set.uniquenumbers;

import org.junit.jupiter.api.Test;

import java.util.Set;

class UniqueTerminalTest {

    @Test
    public void uniqueNumbers() {

        int[] numbers = {5, -3, 12, 10, 83, -1, 0, 8, 53, 6, 17, -33};

        UniqueTerminal uniqueTerminal = new UniqueTerminal();


        Set<Integer> result = uniqueTerminal.getUniqueNumbersByDesc(numbers);

        System.out.println(result);
    }

}