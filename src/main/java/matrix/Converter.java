package matrix;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public List<Integer> convertToList(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int[] i: matrix) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}