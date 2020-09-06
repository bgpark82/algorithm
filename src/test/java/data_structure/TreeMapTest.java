package data_structure;

import org.junit.Test;

import java.util.TreeMap;

public class TreeMapTest {

    @Test
    public void basic() {
        TreeMap<Integer,String> map = new TreeMap<Integer,String>();//TreeMap생성
        map.put(2, "two");
        map.put(1, "one");
        map.put(3, "three");
        map.put(6, "six");
        map.put(5, "five");



    }
}
