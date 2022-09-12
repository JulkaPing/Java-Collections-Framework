package numbersbigandsmall;

import java.util.ArrayList;
import java.util.List;

public class ConverterNumbers {

    public List<SizeNumber> getTypeNumbersByNumbers(List<Integer> numbers) {
        List<SizeNumber> result = new ArrayList<>();
        for (Integer value: numbers) {
            if (value >= 1000) {
                result.add(SizeNumber.BIG);
            } else if (value == 0) {
                result.add(SizeNumber.ZERO);
            } else {
                result.add(SizeNumber.SMALL);
            }
        }
        return result;
    }
}