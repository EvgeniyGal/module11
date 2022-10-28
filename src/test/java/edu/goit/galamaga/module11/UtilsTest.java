package edu.goit.galamaga.module11;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UtilsTest {

    @Test
    void selectOddNames() {

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Ivan",
                "Peter", "Susanna", "John", "Ted", "Anna", "Julia"));

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
        Stream<Long> expectedStream = Stream.of(11L, 277363943098L, 11718085204285L,
                49720483695876L, 102626409374399L);

        Iterator<?> iteratorActual = actualStream.iterator(), iteratorExpected = expectedStream.iterator();

        while(iteratorActual.hasNext() && iteratorExpected.hasNext()){
            assertEquals(iteratorActual.next(), iteratorExpected.next());
        }

        assert !iteratorActual.hasNext() && !iteratorExpected.hasNext();

    }

    @Test
    void zip() {

        Stream<Double> stream1 = Stream.of(3.2, 6.9, 9.5, -65.0);
        Stream<Double> stream2 = Stream.of(-15.2, 56.9);

        Stream<Double> actualStream = Utils.zip(stream1,stream2);
        Stream<Double> expectedStream = Stream.of(3.2, -15.2,6.9, 56.9);

        Iterator<?> iteratorActual = actualStream.iterator(), iteratorExpected = expectedStream.iterator();

        while(iteratorActual.hasNext() && iteratorExpected.hasNext()){
            assertEquals(iteratorActual.next(), iteratorExpected.next());
        }

        assert !iteratorActual.hasNext() && !iteratorExpected.hasNext();

    }

}