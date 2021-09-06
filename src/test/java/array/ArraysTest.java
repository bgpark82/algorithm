package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class ArraysTest {

    @Test
    void intTest() {
        Integer[] numbers = {1,2,4,7,8,3,4,7,8};

        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o1-o2;
            }
        });

        assertThat(numbers).isEqualTo(new Integer[]{1,2,3,4,4,7,7,8,8});
    }

    @Test
    void intTest2() {
        int[][] numbers = {{1,2},{4,7},{8,3},{4,7},{8,7}};

        Arrays.sort(numbers, (n1, n2) -> n1[1] - n2[1]);

        for (int[] number : numbers) {
            System.out.println(number[1]);
        }
    }

    @Test
    void intTest3() {
        int[] numbers = {1,2,4,7,8,3,4,7,8};
    }
}
