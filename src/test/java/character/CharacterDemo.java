package character;

public class CharacterDemo {

    public static final int MAX_CODE_POINT = 0X10FFFF;
    public static final int MIN_SUPPLEMENTARY_CODE_POINT = 0X010000;
    public static final char MIN_LOW_SURROGATE = '\uDC00';
    public static final char MAX_LOW_SURROGATE = '\uDFFF';;
    public static final char MIN_HIGH_SURROGATE = '\uD800';
    public static final char MAX_HIGH_SURROGATE = '\uDBFF';
    public static final char MIN_SURROGATE = MIN_HIGH_SURROGATE;
    public static final char HIGH_SURROGATE = MAX_LOW_SURROGATE;


    private final char value;

    public CharacterDemo(final char value) {
        this.value = value;
    }

    /**
     * Cache된 값을 반환, 대략 35배 차이 (캐시 유 : 7ms, 캐시 무 250ms)
     * 자주 사용되는 utf8은 캐싱된다
     * @param c
     * @return CharacterDemo
     */
    public static CharacterDemo valueOf(final char c) {
        if (c <= 127) {
            return CharacterCacheDemo.cache[(int)c];
        }
        return new CharacterDemo(c);
    }

    /**
     * valueOf와 퍼포먼스 비교용
     * @param c
     * @return CharacterDemo
     */
    public static CharacterDemo valueOfWithoutCache(final char c) {
        return new CharacterDemo(c);
    }

    /**
     * 해당 문자가 BMP인지 확인 (BMP = plane1)
     * BMP 범위 : 000000 ~ 00FFFF
     * @param codePoint
     * @return true, 만약 문자의 codepoint가 bmp 범위에 있는 경우
     */
    public static boolean isBmpCodePoint(final int codePoint) {
        return (codePoint >>> 16) == 0;
    }

    /**
     * 해당 문자가 SupplementaryCodePoint인지 확인 (BMP = plane1)
     * SupplementaryCodePoint 범위 : 010000 ~ 10FFFF
     * @param codePoint
     * @return true, 만약 문자의 codepoint가 SupplementaryCodePoint인지 범위에 있는 경우
     */
    public static boolean isSupplementaryCodePoint(final char codePoint) {
        return codePoint >= MIN_SUPPLEMENTARY_CODE_POINT
                && codePoint <= MAX_CODE_POINT;
    }

    public static boolean isSurrogate(final char c) {
        return c >= MIN_SURROGATE && c < HIGH_SURROGATE + 1;
    }

    public static boolean isLowSurrogate(final char c) {
        return c >= MIN_LOW_SURROGATE && c <= MAX_LOW_SURROGATE + 1;
    }

    public static boolean isHighSurrogate(final char c) {
        return c >= MIN_HIGH_SURROGATE && c <= MAX_HIGH_SURROGATE;

    }

    /**
     * char 값 반환
     * @return value
     */
    public char charValue() {
        return this.value;
    }

    /**
     * 문자의 codepoint의 plane이 범위 사이에 존재하는지 확인
     *
     * codepoint의 범위 : 0 <= codepoint <= 0x10FFFF
     * plane의 범위 : 0 <= plane <= 16
     *
     * 아래 코드는 아래와 같이 표현
     * codepoint의 범위 : 0 <= codepoint < 0x10FFFF + 1
     * plane의 범위 : 0 <= plane < 17
     *
     * @param codePoint
     * @return true 만약 문자의 codepoint가 0x10FFFF보다 작은 경우
     */
    public static boolean isValueCodePoint(final int codePoint) {
        final int plane = codePoint >>> 16;
        return plane < ((MAX_CODE_POINT + 1) >>> 16);
    }



    /**
     * 각 127개의 Unicode 문자를 CharacterDemo로 Wrapping한 배열을 메모리에 캐싱
     */
    public static class CharacterCacheDemo {

        static final CharacterDemo cache[] = new CharacterDemo[127 + 1];

        static {
            for (int i = 0; i < cache.length; i++) {
                cache[i] = new CharacterDemo((char) i);
            }
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o instanceof CharacterDemo) {
            return this.value == ((CharacterDemo) o).charValue();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(value);
    }

    public static int hashCode(final char value) {
        return (int) value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
