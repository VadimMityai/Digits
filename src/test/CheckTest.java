package test;

import main.java.com.utils.Check;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CheckTest {

    @Test
    void CheckEquals () {
        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> actual = new ArrayList<>();
        actual.add("десять миллионов");
        actual.add("две тысячи");
        actual.add("один миллион двадцать тысяч два");
        expected.add("десять миллионов Неверно");
        expected.add("две тысячи Неверно");
        expected.add("один миллион двадцать тысяч два Верно");
        String transform = "один миллион двадцать тысяч два";

        Check.checkEquals(actual, transform);

        Assertions.assertEquals(expected, actual);
    }
}
