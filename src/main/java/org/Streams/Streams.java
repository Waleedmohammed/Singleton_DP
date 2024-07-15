package org.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 20, 30, 4, 5, 8);

        // 1-
        Optional<Integer> Sum = list.stream()
                .reduce((a, b) -> a + b);
        System.out.println("sum of numbers : " + Sum.get());

        // 2-
        double avg = list.stream()
                .mapToInt(e -> e)
                .average()
                .getAsDouble();
        System.out.println("AVG of numbers : " + avg);


        // 3-
        double avg2 = list.stream()
                .map(e -> e * e)
                .filter(e -> e > 100)
                .mapToInt(e -> e)
                .average()
                .getAsDouble();

        System.out.println("AVG with filter : " + avg2);


        // 4. Odd/Even Numbers
        List<Integer> numbers = Arrays.asList(11, 2, 3, 45, 67, 87, 90, 0);
        List<Integer> evenNumbers = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        List<Integer> oddNumbers = numbers.stream()
                .filter(e -> e % 2 != 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);
        System.out.println(oddNumbers);


        // 5.
        List<Integer> numbers2 = Arrays.asList(2, 222, 234, 567, 890, -432, 211, 22);
        List<Integer> matchList = numbers2.stream()
                .map(e -> String.valueOf(e))
                .filter(e -> e.startsWith("2") || e.startsWith("-"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(matchList);


        // 6. Duplicate Numbers
        List<Integer> duplicateNumber = Arrays.asList(1, 3, 10, 20, 30, 15, 10, 20, 30, 30, 30);
        Set<Integer> duplicate = duplicateNumber.stream()
                .filter(e -> Collections.frequency(duplicateNumber, e) > 1)
                .collect(Collectors.toSet());
        System.out.println(duplicate);

        // 7. Max Min Numbers
        List<Integer> maxMinNumber = Arrays.asList(1, 20, 80, 7, 29, 0);
        int maxNumber = maxMinNumber.stream()
                .max(Comparator.comparing(Integer::valueOf))
                .get();

        int minNumber = maxMinNumber.stream()
                .min(Comparator.comparing(Integer::valueOf))
                .get();

        System.out.println(maxNumber);
        System.out.println(minNumber);


        // 8. sort Numbers
        List<Integer> sortNumber = Arrays.asList(1, 20, 80, 7, 29, 0);

        List<Integer> sortedNumberAsc = sortNumber.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> sortedNumberDesc = sortNumber.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(sortedNumberAsc);
        System.out.println(sortedNumberDesc);

        // 9. Limit number (get first 5 numbers from list) + their sum
        List<Integer> listAllNumbers = Arrays.asList(1, 3, 10, 20, 30, 15, 10, 20, 30, 30, 30);

        List<Integer> firtNumbers = listAllNumbers.stream()
                .limit(5)
                .collect(Collectors.toList());

        int sumfirstNumbers = listAllNumbers.stream()
                .limit(5)
                .reduce((a, b) -> a + b)
                .get();

        System.out.println(firtNumbers);
        System.out.println(sumfirstNumbers);


        // 10 . Limit number (Skip first 5 numbers from list) + their sum
        List<Integer> lastNumbers = listAllNumbers.stream()
                .skip(5)
                .collect(Collectors.toList());

        int sumlastNumbers = listAllNumbers.stream()
                .skip(5)
                .reduce((a, b) -> a + b)
                .get();


        System.out.println(lastNumbers);
        System.out.println(sumlastNumbers);


        // 11 . Second lowest/highest Number
        List<Integer> secLowestHighestNum = Arrays.asList(1, 20, 80, 7, 29, 0);

        int secondEdge = secLowestHighestNum.stream()
                .sorted(Collections.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .get();

        int firstEdge = secLowestHighestNum.stream()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst()
                .get();

        System.out.println(secondEdge);
        System.out.println(firstEdge);
    }
}
