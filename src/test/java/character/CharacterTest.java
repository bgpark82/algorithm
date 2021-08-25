package character;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterTest {

    @Test
    void valueOf_캐싱된다() {
        CharacterDemo character = CharacterDemo.valueOf('c');
        assertThat(character).isEqualTo(new CharacterDemo('c'));
    }

    @Test
    void valueOfWithoutCache_캐싱되지_않는다() {
        CharacterDemo character = CharacterDemo.valueOfWithoutCache('c');
        assertThat(character).isEqualTo(new CharacterDemo('c'));
    }

    @Test
    void charValue() {
        CharacterDemo character = CharacterDemo.valueOf('c');
        assertThat(character.charValue()).isEqualTo('c');
    }

    @Test
    void hashcode() {
        CharacterDemo characterDemo = CharacterDemo.valueOf('a');
        assertThat(characterDemo.hashCode()).isEqualTo(97);
    }

    @Test
    void hashcode_값을_받는다() {
        assertThat(CharacterDemo.hashCode('a')).isEqualTo(97);
    }

    @Test
    void equals() {
        CharacterDemo a1 = CharacterDemo.valueOf('a');
        CharacterDemo a2 = CharacterDemo.valueOf('a');
        assertThat(a1.equals(a2)).isTrue();
    }

    @Test
    void tostring() {
        CharacterDemo characterDemo = CharacterDemo.valueOf('a');
        assertThat(characterDemo.toString()).isEqualTo("a");
    }

    @Test
    void hexCode_16진법_계산법() {
        assertThat(0x1).isEqualTo(1);
        assertThat(0xA).isEqualTo(10);
        assertThat(0x11).isEqualTo(1  * 16 + 1);
        assertThat(0xAA).isEqualTo(10 * 16 + 10);
        assertThat(0xFF).isEqualTo(15 * 16 + 15);
    }

    @Test
    void unsigned_right_shift() {
        assertThat(Integer.toBinaryString(0xF)).isEqualTo("1111");
        assertThat(Integer.toBinaryString(0xFF)).isEqualTo("11111111");
        assertThat(Integer.toBinaryString(0xFF >> 4)).isEqualTo("1111");
        assertThat(Integer.toBinaryString(0xFF >> 8)).isEqualTo("0");
    }

    @Test
    void max() {
        assertThat(CharacterDemo.MAX_CODE_POINT).isEqualTo(0x10FFFF);

        assertThat(Integer.toHexString(CharacterDemo.MAX_CODE_POINT)).isEqualTo("10ffff"); // 16 진수
        assertThat(Integer.toHexString(CharacterDemo.MAX_CODE_POINT >>> 16 )).isEqualTo("10");
        assertThat(Integer.toHexString(CharacterDemo.MAX_CODE_POINT + 1)).isEqualTo("110000");
        assertThat(Integer.toHexString((CharacterDemo.MAX_CODE_POINT + 1) >>> 16)).isEqualTo("11");

        assertThat(Integer.toBinaryString(CharacterDemo.MAX_CODE_POINT)).isEqualTo("100001111111111111111"); // 2진수
        assertThat(Integer.toBinaryString(CharacterDemo.MAX_CODE_POINT >>> 16)).isEqualTo("10000"); // 2진수
        assertThat(Integer.toBinaryString(CharacterDemo.MAX_CODE_POINT + 1)).isEqualTo("100010000000000000000");
        assertThat(Integer.toBinaryString((CharacterDemo.MAX_CODE_POINT + 1) >>> 16)).isEqualTo("10001"); // 00010001
    }

    @Test
    void codePoint() {
        assertThat(0x10ffff).isEqualTo(1114111);
        assertThat((0x10ffff) >>> 16).isEqualTo(16);

        assertThat(Integer.toHexString(0x10ffff)).isEqualTo("10ffff");
        assertThat(Integer.toBinaryString(0x10ffff)).isEqualTo("100001111111111111111");

        assertThat(Integer.toHexString(0x10ffff + 1 )).isEqualTo("110000"); // 16진수
        assertThat(Integer.toBinaryString(0x10ffff + 1)).isEqualTo("100010000000000000000"); // 2진수

        assertThat(Integer.toHexString((0x10ffff + 1) >>> 16 )).isEqualTo("11"); // 16진수
        assertThat(Integer.toBinaryString((0x10ffff + 1) >>> 16 )).isEqualTo("10001"); // 2진수
    }

    @Test
    void korean() {
        assertThat((int) '멀').isEqualTo(47680);
        assertThat(Integer.toHexString('멀')).isEqualTo("ba40");
        assertThat(Integer.toBinaryString('멀')).isEqualTo("1011101001000000");

        assertThat(((int) '멀') >>> 16).isEqualTo(0);
        assertThat(Integer.toHexString('멀')).isEqualTo("ba40");
        assertThat(Integer.toBinaryString('멀')).isEqualTo("1011101001000000");
    }

    @Test
    void isValidCodePoint() {
        assertThat(CharacterDemo.isValueCodePoint('멀')).isTrue();
    }

    @Test
    void isBmpCodePoint() {
        boolean isBmp = CharacterDemo.isBmpCodePoint('a');
        assertThat(isBmp).isTrue();
    }

    @Test
    void isSupplementaryCodePoint() {
        assertThat(CharacterDemo.isSupplementaryCodePoint('a')).isFalse();
    }

    @Test
    void isSurrogate() {
        assertThat(CharacterDemo.MIN_SURROGATE).isEqualTo('\uD800');
        assertThat(CharacterDemo.HIGH_SURROGATE).isEqualTo('\uDFFF');
        assertThat(CharacterDemo.HIGH_SURROGATE + 1).isEqualTo('\uE000');

        assertThat(CharacterDemo.isSurrogate('\uD811')).isTrue();

        assertThat('가').isEqualTo('\uAC00');
        assertThat('가').isEqualTo((char) 0xac00);

        String str = new String("가");
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        for(byte i : bytes) {
            System.out.println(Integer.toBinaryString(i));;
            System.out.println(i);
        }
    }

    @Test
    void utf8encoding() {
        byte[] utf8 = "ℤ".getBytes(StandardCharsets.UTF_8);
        assertThat(utf8.length).isEqualTo(3);
        for (byte b: utf8) {
            System.out.print(Integer.toBinaryString(b) + " ");
        }

        byte[] a = "a".getBytes(StandardCharsets.UTF_8);
        assertThat(a.length).isEqualTo(1);
        for (byte b: a) {
            System.out.print(Integer.toBinaryString(b) + " ");
        }

        byte[] k = "가".getBytes(StandardCharsets.UTF_8);
        assertThat(k.length).isEqualTo(3);
        for (byte b: k) {
            System.out.print(Integer.toBinaryString(b) + " ");
        }

        byte[] utf16 = "ℤ".getBytes(StandardCharsets.UTF_16);
        assertThat(utf16.length).isEqualTo(4);
    }

    @Test
    void utf8_3byte() {
        assertThat('\u2124').isEqualTo('ℤ'); // ℤ를 자바 char로 표현
        assertThat(0x2124).isEqualTo('ℤ'); // ℤ를 16진법으로 표현
        assertThat(Integer.toBinaryString(0x2124)).isEqualTo("10000100100100"); // ℤ를 2진수로 표현


        assertThat('ℤ').isEqualTo('\u2124'); // ℤ를 자바 char로 표현
        assertThat(Integer.toHexString('ℤ')).isEqualTo("2124"); // ℤ를 16진법으로 표현
        assertThat(Integer.toBinaryString('ℤ')).isEqualTo("10000100100100"); // ℤ를 2진수로 표현

        byte[] bytes = "ℤ".getBytes(StandardCharsets.UTF_8);
        StringBuffer sb = new StringBuffer();
        for (byte b : bytes) {
            sb.append(Integer.toBinaryString(b)).append(" ");
        }
        assertThat(sb.toString()).isEqualTo("11111111111111111111111111100010 11111111111111111111111110000100 11111111111111111111111110100100 ");
        //11100010 10000100 10100100
        //1110xxxx 10xxxxxx 10xxxxxx
    }

    @Test
    void isLowSurrogate() {
        assertThat(CharacterDemo.MIN_LOW_SURROGATE).isEqualTo('\uDC00');
        assertThat(CharacterDemo.MAX_LOW_SURROGATE).isEqualTo('\uDFFF');
        assertThat(CharacterDemo.isLowSurrogate('\uDC00')).isTrue();
        assertThat(CharacterDemo.isLowSurrogate('\uDFFF')).isTrue();
    }

    @Test
    void isHighSurrogate() {
        assertThat(CharacterDemo.MIN_HIGH_SURROGATE).isEqualTo('\uD800');
        assertThat(CharacterDemo.MAX_HIGH_SURROGATE).isEqualTo('\uDBFF');
        assertThat(CharacterDemo.isHighSurrogate('\uD800')).isTrue();
        assertThat(CharacterDemo.isHighSurrogate('\uDBFF')).isTrue();
    }

    @Test
    void getType() {
        assertThat(CharacterDataDemo.of('a')).isInstanceOf(CharacterDataLatin1Demo.class);

        String A_DATA =
                "\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800"+
                        "\u100F\u4800\u100F\u4800\u100F\u5800\u400F\u5000\u400F\u5800\u400F\u6000\u400F"+
                        "\u5000\u400F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800"+
                        "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F"+
                        "\u4800\u100F\u4800\u100F\u5000\u400F\u5000\u400F\u5000\u400F\u5800\u400F\u6000"+
                        "\u400C\u6800\030\u6800\030\u2800\030\u2800\u601A\u2800\030\u6800\030\u6800"+
                        "\030\uE800\025\uE800\026\u6800\030\u2000\031\u3800\030\u2000\024\u3800\030"+
                        "\u3800\030\u1800\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u1800"+
                        "\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u3800\030\u6800\030"+
                        "\uE800\031\u6800\031\uE800\031\u6800\030\u6800\030\202\u7FE1\202\u7FE1\202"+
                        "\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1"+
                        "\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202"+
                        "\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1"+
                        "\202\u7FE1\uE800\025\u6800\030\uE800\026\u6800\033\u6800\u5017\u6800\033\201"+
                        "\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2"+
                        "\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201"+
                        "\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2"+
                        "\201\u7FE2\201\u7FE2\201\u7FE2\uE800\025\u6800\031\uE800\026\u6800\031\u4800"+
                        "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u5000\u100F"+
                        "\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800"+
                        "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F"+
                        "\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800"+
                        "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F"+
                        "\u3800\014\u6800\030\u2800\u601A\u2800\u601A\u2800\u601A\u2800\u601A\u6800"+
                        "\034\u6800\030\u6800\033\u6800\034\000\u7005\uE800\035\u6800\031\u4800\u1010"+
                        "\u6800\034\u6800\033\u2800\034\u2800\031\u1800\u060B\u1800\u060B\u6800\033"+
                        "\u07FD\u7002\u6800\030\u6800\030\u6800\033\u1800\u050B\000\u7005\uE800\036"+
                        "\u6800\u080B\u6800\u080B\u6800\u080B\u6800\030\202\u7001\202\u7001\202\u7001"+
                        "\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202"+
                        "\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001"+
                        "\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\u6800\031\202\u7001\202"+
                        "\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\u07FD\u7002\201\u7002"+
                        "\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201"+
                        "\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002"+
                        "\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\u6800"+
                        "\031\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002"+
                        "\u061D\u7002";

        char[] chars = A_DATA.toCharArray();
        assertThat(chars.length).isEqualTo(512);
        int i = 0, j = 0;
        while (i < 512) {

            int entry = chars[i++] << 16;
            String entryHex = Integer.toHexString(entry);

            char nextEntry = chars[i++];
            String nextEntryHex = Integer.toHexString(nextEntry);

            int result = entry | nextEntry;
            String resultHex = Integer.toHexString(result);
            System.out.println(entryHex + ":" + nextEntryHex + "=" +resultHex + "(" + ((char) result) + "), ");
//            System.out.println(j++ + ":" +resultHex + "(" + ((char) result) + "), ");
        }
    }

    @Test
    void toLowerCaseCharacter() {
        assertThat(Character.getNumericValue('1')).isEqualTo(1);
        assertThat(Character.getNumericValue('a')).isEqualTo(10);
    }

    @Test
    void isSpace() {
        assertThat(Character.isSpaceChar(' ')).isTrue();
        assertThat(Character.isSpaceChar('\t')).isFalse();
    }

    @Test
    void isWhiteSpace() {
        assertThat(Character.isWhitespace(' ')).isTrue();
        assertThat(Character.isWhitespace('\t')).isTrue();
        assertThat(Character.isWhitespace('\n')).isTrue();
        assertThat(Character.isWhitespace('\u000B')).isTrue();
        assertThat(Character.isWhitespace('\f')).isTrue();
        assertThat(Character.isWhitespace('\r')).isTrue();
        System.out.println('\u000B');
    }

    @Test
    void isDigit() {
        assertThat(Character.isDigit('1')).isTrue();
        assertThat(Character.isDigit('a')).isFalse();
    }

    @Test
    void isAlphabetic() {
        assertThat(Character.isAlphabetic('a')).isTrue();
        assertThat(Character.isAlphabetic('1')).isFalse();
        assertThat(Character.isAlphabetic('$')).isFalse();
    }

    @Test
    void isLetterOrDigit() {
        assertThat(Character.isLetterOrDigit('a')).isTrue();
        assertThat(Character.isLetterOrDigit('1')).isTrue();
        assertThat(Character.isLetterOrDigit('$')).isFalse();
    }

    @Test
    void isLetter() {
        assertThat(Character.isLetter('a')).isTrue();
        assertThat(Character.isLetter('1')).isFalse();
        assertThat(Character.isLetter('가')).isTrue();
    }

    @Test
    void isJavaIdentifier() {
        assertThat(Character.isJavaIdentifierStart('$')).isTrue();
        assertThat(Character.isJavaIdentifierStart('_')).isTrue();
        assertThat(Character.isJavaIdentifierStart('a')).isTrue();
    }
}
