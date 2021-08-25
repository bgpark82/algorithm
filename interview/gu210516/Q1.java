package gu210516;

public class Q1 {
    
    public static void main(String[] args) {
        assert stringToInteger("123") == 123 : "123";
        assert stringToInteger("123.456") == null : "123.456";
        assert stringToInteger("-123") == -123 : "-123";
    }

    private static Integer stringToInteger(String value) {

        final int length = value.length();
        int result = 0;
        for(int i = length-1; i > 0; i--){

            final char character = value.charAt(i);
            int c =  Character.getNumericValue(character);
            final int digit = i * 10;
            result += c * (int)Math.pow(10.0,digit);
        }

        return result;

    }
}
