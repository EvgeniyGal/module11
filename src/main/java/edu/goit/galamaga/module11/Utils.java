package edu.goit.galamaga.module11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static String selectOddNames(List<String> names) {

        List<String> oddNames = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {

            if (i % 2 == 0) {
                oddNames.add((i + 1) + ". " + names.get(i));
            }

        }

        return oddNames.stream().collect(Collectors.joining(", "));

    }

    public static List<String> listConverter(List<String> names) {

        return names.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

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

        List<Long> randomNumbers = new ArrayList<>();

        for (int i = 0; i < limit; i++) {
            prevElement = (a * prevElement + c) % m;
            randomNumbers.add(prevElement);
        }

        return randomNumbers.stream();
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        List<T> firstList = first.toList();
        List<T> secondList = second.toList();

        int minStreamSize = Math.min(firstList.size(), secondList.size());

        List<T> resultList = new ArrayList<>();

        for (int i = 0; i < minStreamSize; i++) {
            resultList.add(firstList.get(i));
            resultList.add(secondList.get(i));
        }

        return resultList.stream();

    }

}
