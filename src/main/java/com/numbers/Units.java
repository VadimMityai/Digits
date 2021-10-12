package main.java.com.numbers;

import java.util.TreeMap;

public class Units extends Num {

    private TreeMap<String, String> unit;

    public Units() {
        this.unit = new TreeMap<>();
        init("src/resources/UnitsNumbers.txt", this.unit);
    }

    @Override
    public String transform(String s) {
        return this.unit.get(s);
    }

}
