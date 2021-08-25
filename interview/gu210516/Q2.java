package gu210516;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {

    public static void main(String[] args) {

       assert rotateList(Arrays.asList(1, 2, 3, 4, 5), 2).equals(Arrays.asList(3, 4, 5, 1, 2)) : "list: [1, 2, 3, 4, 5], count: 2";
       assert rotateList(Arrays.asList(1, 2, 3, 4, 5), 8).equals(Arrays.asList(4, 5, 1, 2, 3)) : "list: [1, 2, 3, 4, 5], count: 8";
       assert rotateList(Arrays.asList(1, 2, 3, 4, 5), -1).equals(Arrays.asList(5, 1, 2, 3, 4)) : "list: [1, 2, 3, 4, 5], count: -1";
    }
    
    private static List<Integer> rotateList(List<Integer> list, int count) {;
        final int size = list.size();
        List<Integer> newList = new ArrayList();

        count = (count >= 0) ? count % size : count + size;

        int index = 0;
        while(index < size) {
            int value = (index + count < size) ? list.get(index+count) : list.get(index+count-size);
            newList.add(value);
            index++;
        }
        return newList;
    }
}
