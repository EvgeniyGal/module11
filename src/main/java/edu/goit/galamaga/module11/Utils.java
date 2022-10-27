package edu.goit.galamaga.module11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static String selectOddNames(List<String> names) {

        return names.stream().
                filter((name) -> Integer.parseInt(name.replaceAll("\\D+", "")) % 2 != 0).
                collect(Collectors.joining(", "));

    }

    public static List<String> listConverter(List<String> names) {

        return names.stream().map(String::toUpperCase).
                sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    }

    public static String sortNumbers(String[] numbers) {

        List<String> listNumbers = new ArrayList<>();

        for (String strNumbers :
                numbers) {
            listNumbers.addAll(Arrays.asList(strNumbers.split(", ")));
        }

        return listNumbers.stream().sorted().collect(Collectors.joining(", "));

    }

    public static Stream<Long> getRandomStream(int c, long m, int seed) {

        long a = 25214903917L;

        int limit = 5;

        long prevElement = seed;

//        Stream<Long> outStream = (Stream<Long>) Stream.builder();
        List<Long> randomNumbers = new ArrayList<>();

        for (int i = 0; i < limit; i++) {

            prevElement = (a * prevElement + c) % m;
            randomNumbers.add(prevElement);
        }

        return randomNumbers.stream();
    }

}
