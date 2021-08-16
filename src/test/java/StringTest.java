import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void sort() {
        String string = "cba";
        char[] chars = string.toCharArray(); // System.arraycopy
        Arrays.sort(chars); // O(nlog(n)) : Dual-Pivot Quicksort
        String expected = new String(chars);
        assertThat(expected).isEqualTo("abc");
    }

    @Test
    void equals() {
        String a = "a";
        String b = "a";
        assertThat(a.equals(b)).isTrue();
        assertThat(a == b).isTrue();
    }
}
