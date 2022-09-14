package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ConverterTest {
    @Test
    public void convertToList() {
        Converter converter = new Converter();

        int[][] twoArray = {{5, 7, 3, 17}, {7, 0, 1, 12}};

        List<Integer> expected = new ArrayList<>(Arrays.asList(5, 7, 3, 17, 7, 0, 1, 12));
        List<Integer> result = converter.convertToList(twoArray);

        Assertions.assertIterableEquals(expected, result);
    }
}