package character;

public abstract class CharacterDataDemo {

    abstract int getType(final int ch);

    static final CharacterDataDemo of(int codePoint) {
        // ASCII
        if (codePoint >>> 8 == 0) {
            return CharacterDataLatin1Demo.instance;
        }
        return null;
    }

}
