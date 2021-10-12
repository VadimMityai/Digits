package test;

import main.java.com.utils.ToWords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

class ToWordsTest {

    @Test
    void makeNum() {
        TreeMap<String, String> expexted = new TreeMap<>();
        TreeMap<String, String> actual = new TreeMap<>();
        expexted.put("10000000", "десять миллионов");
        expexted.put("2000", "две тысячи");
        expexted.put("1020003", "один миллион двадцать тысяч три");
        expexted.put("1345", "одна тысяча триста сорок пять");


        ToWords toWords = new ToWords();
        for (Map.Entry<String, String> entry : expexted.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            expexted.replace(key, value.toLowerCase(Locale.ROOT).replaceAll("\\s+",""));
            String transformNumber = toWords.makeNum(key);
            actual.put(key, transformNumber);

        }
        Assertions.assertEquals(expexted, actual);
    }
}