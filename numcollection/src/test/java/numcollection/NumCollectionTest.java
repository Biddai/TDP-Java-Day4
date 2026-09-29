package numcollection;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class NumCollectionTest {
    @Test
    void containsASingleNumberAndExcludesItsNeighbours() {
        NumCollection numbers = new NumCollection("5");
        assertThat(numbers.contains(5)).isTrue();
        assertThat(numbers.contains(4)).isFalse();
        assertThat(numbers.contains(6)).isFalse();
    }

    @ParameterizedTest()
    @CsvSource({
            "3, '1-5'",
            "20, '8-22'",
            "-5, '-10-5'"
    })
    void containsASingleNumberParameterized(int target, String col) {
        NumCollection numbers = new NumCollection(col);
        assertThat(numbers.contains(target))
                .withFailMessage("==> %s expected to be in %s but wasn't", target, col)
                .isTrue()
        ;
    }

    static Stream<Arguments> getNumColWithIncludedAndExcluded() {
        return Stream.of(
                Arguments.of("1, 6", new int[]{1, 6}, new int[]{0, 10}),
                Arguments.of("1-3, 6-9", new int[]{2, 3, 8}, new int[]{0, 10}),
                Arguments.of("-5--3, 6-9", new int[]{-4, -3, 7, 8}, new int[]{0, 1, 2, 10})
        );
    }

    @ParameterizedTest()
    @MethodSource("getNumColWithIncludedAndExcluded")
    void containsAndNotContainsParameterized1(
            String col,
            int[] values_in,
            int[] values_not_in) {
        NumCollection numbers = new NumCollection(col);
        for (int val : values_in) {
            assertThat(numbers.contains(val))
                    .withFailMessage("==> %s expected to be in %s but wasn't", val, col)
                    .isTrue();
        }
        for (int val : values_not_in) {
            assertThat(numbers.contains(val))
                    .withFailMessage("==> %s expected NOT to be in %s but is in", val, col)
                    .isFalse();
        }
    }

    @ParameterizedTest()
    @MethodSource("getNumColWithIncludedAndExcluded")
    void containsAndNotContainsParameterized2(
            String col,
            int[] values_in,
            int[] values_not_in) {
        NumCollection numbers = new NumCollection(col);
        SoftAssertions.assertSoftly(softly -> {
            for (int val : values_in) {
                softly.assertThat(numbers.contains(val))
                        .withFailMessage("==> %s expected to be in %s but wasn't", val, col)
                        .isTrue();
            }
            for (int val : values_not_in) {
                softly.assertThat(numbers.contains(val))
                        .withFailMessage("==> %s expected NOT to be in %s but is in", val, col)
                        .isFalse();
            }
        });
    }
}
