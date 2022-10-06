package map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookiesUtils {

    private final static String SPEC_SYMBOL = ";";
    private final static String EMPTY = "";
    private final static String SPEC_SYMBOL_KEY_VALUE = ":";
    public static Map<String, Pair> getCookies(List<String> cookiesStringList) {

        Map<String, Pair> result = new HashMap<>();

        for (String value : cookiesStringList) {
            String[] arrayString = value.split(SPEC_SYMBOL_KEY_VALUE);
            String[] cookieVandF = arrayString[1].split(SPEC_SYMBOL);
            if (cookieVandF.length == 2) {
                result.put(arrayString[0], Pair.of(arrayString[0], cookieVandF[0], Flag.valueOf(cookieVandF[1]), Flag.HTTP_ONLY));
            } else {
                result.put(arrayString[0], Pair.of(arrayString[0], cookieVandF[0], Flag.values()));
            }
        }
        return result;
    }
}

