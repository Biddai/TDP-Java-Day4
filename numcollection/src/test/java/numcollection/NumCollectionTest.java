package numcollection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class NumCollectionTest {
    @Test void containsASingleNumberAndExcludesItsNeighbours() {
        NumCollection numbers = new NumCollection("5");
        assertThat(numbers.contains(5)).isTrue();
        assertThat(numbers.contains(4)).isFalse();
        assertThat(numbers.contains(6)).isFalse();
    }
}
