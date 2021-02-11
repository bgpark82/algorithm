package data_structure;

import org.junit.Test;

public class StringTest {

    @Test
    public void substring_test() {
        String s = "dsfsdf.";
        System.out.println(s.charAt(s.length() -1));
        String substring = s.substring(0, s.length() - 1);
        System.out.println(substring);
    }

    @Test
    public void substring_length() {
        String s = "12345678901234567890";
        String substring = s.substring(0, 15);
        System.out.println(substring);
    }

    @Test
    public void append_recursively() {
        String newId = "23";
        if(newId.length() <= 2) {
            char lastChar = newId.charAt(newId.length() - 1);
            while(newId.length() <= 2) {
                newId += lastChar;
            }
        }
        System.out.println(newId);

    }
}
