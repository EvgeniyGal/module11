package edu.goit.galamaga.module11;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UtilsTest {

    @Test
    void selectOddNames() {

        ArrayList<String> names = new ArrayList<>(Arrays.asList("1. Ivan",
                "2. Peter", "3. Susanna", "4. John", "5. Ted", "6. Anna", "7. Julia"));

        String actualNamesLine = Utils.selectOddNames(names);

        String expectedNamesLine = "1. Ivan, 3. Susanna, 5. Ted, 7. Julia";

        assertEquals(expectedNamesLine, actualNamesLine);

    }

    @Test
    void listConverter() {

        List<String> names = new ArrayList<>(Arrays.asList("Ivan",
                "Peter", "Susanna", "John", "Ted", "Anna", "Julia"));

        List<String> actualNames = Utils.listConverter(names);
        List<String> expectedNames = new ArrayList<>(Arrays.asList("TED", "SUSANNA", "PETER",
                "JULIA", "JOHN", "IVAN", "ANNA"));

        assertEquals(expectedNames, actualNames);
    }

    @Test
    void sortNumbers() {

        String[] strNumbers = new String[]{"1, 2, 0", "4, 5"};

        String actualStrNumbers = Utils.sortNumbers(strNumbers);
        String expectedStrNumbers = "0, 1, 2, 4, 5";

        assertEquals(expectedStrNumbers, actualStrNumbers);

    }

    @Test
    void getRandomStreamTest() {

        Stream<Long> actualStream = Utils.getRandomStream(11, (long) Math.pow(2, 48), 0);

        assertThat(actualStream).containsExactly(11L, 277363943098L, 11718085204285L,
                49720483695876L, 102626409374399L);

    }
}