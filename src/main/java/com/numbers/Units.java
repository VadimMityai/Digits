package main.java.com.numbers;

import java.util.TreeMap;

public class Units extends Num {

    private TreeMap<Long, String> unit;

    public Units() {
        this.unit = new TreeMap<>();
        init("src/resources/UnitsNumbers.txt", this.unit);
    }

    @Override
    public String transform(String s) {
        long i = Long.parseLong(s);
        return this.unit.get(i);
    }

}
