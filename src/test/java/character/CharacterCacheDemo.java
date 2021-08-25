package character;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterCacheDemo {

    @Test
    void construct_CharacterCache_생성_시점에_Unicode가_캐싱된다() {
        int i = 0;
        for (CharacterDemo c : CharacterDemo.CharacterCacheDemo.cache) {
            assertThat(c).isEqualTo(new CharacterDemo((char) i));
            i++;
        }
    }
}
