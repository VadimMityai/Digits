package test;

import main.java.com.utils.Check;
import main.java.com.utils.ToWords;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

class ToWordsTest {

    @Test
    void makeNum() {
        TreeMap<String, ArrayList<String>> expexted = new TreeMap<>();
        TreeMap<String, ArrayList<String>> actual = new TreeMap<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> wordsAct = new ArrayList<>();
        words.add("десять миллионов Неверно");
        words.add("две тысячи Неверно");
        words.add("один миллион двадцать тысяч два Верно");
        wordsAct.add("десять миллионов");
        wordsAct.add("две тысячи");
        wordsAct.add("один миллион двадцать тысяч два");
        expexted.put("1020002", words);

        ToWords toWords = new ToWords();
        for (Map.Entry<String, ArrayList<String>> entry : expexted.entrySet()) {
            String key = entry.getKey();
            String transformNumber = toWords.makeNum(key);
            Check.checkEquals(wordsAct, transformNumber);
            actual.put(key, wordsAct);

        }
        Assertions.assertEquals(expexted, actual);
    }
}