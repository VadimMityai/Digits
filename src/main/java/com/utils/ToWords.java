package main.java.com.utils;

import main.java.com.numbers.*;

import java.util.ArrayList;

public class ToWords {

    private ArrayList<Num> myNums;
    private final Units units;
    private final Tens tens;
    private final Hundreds hundreds;
    private final Degrees degrees;

    public ToWords() {
        this.units = new Units();
        this.tens = new Tens();
        this.hundreds = new Hundreds();
        this.degrees = new Degrees();
        this.myNums = new ArrayList<>();
        this.myNums.add(this.units);
        this.myNums.add(this.tens);
        this.myNums.add(this.hundreds);
        this.myNums.add(this.degrees);
    }

    public String makeNum(long i) {
        StringBuilder numb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        numb.append(i);
        numb.reverse();
        double d = numb.length() / 3.0;
        ArrayList<String> digits = new ArrayList<>();
        for (double j = 0; j < d; j++) {
            String value;
            try {
                value = numb.substring(0, 2) + (int) j;
            } catch (Exception e) {
                value = String.valueOf(numb.charAt(0)) + (int) j;
            }
            String degree = degrees.transform(value);
            for (int k = 0; k < 3; k++) {
                try {
                    String digit = String.valueOf(numb.charAt(k));
                    if (digit.equals("0")) {
                        digits.add("");
                        continue;
                    }
                    if (digit.equals("1") && k == 1) {
                        digit = digit + String.valueOf(numb.charAt(0));
                        digits.remove((int )j * 3);
                        digits.add(myNums.get(k).transform(digit) + degree);
                    } else if (k == 0) {
                        if ((int) j == 1 && (digit.equals("1") || digit.equals("2"))) {
                            digits.add(degree);
                        } else {
                            digits.add(myNums.get(k).transform(digit) + degree);
                        }
                    } else if (String.valueOf(numb.charAt(0)).equals("0")){
                        digits.add(myNums.get(k).transform(digit) + degree);
                    } else {
                        digits.add(myNums.get(k).transform(digit));
                    }
                } catch (Exception e) {
                    break;
                }
            }
            numb.delete(0, 3);
        }
        for (int k = digits.size() - 1; k >= 0; k--) {
            word.append(digits.get(k));
        }

        return word.toString();
    }
}
