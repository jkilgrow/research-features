package com.doterra.research.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams
{
    public static void main(String[] args)
    {
        /*
         * Part 1: Integer Stream
         */
        IntStream.range(1, 10).forEach(System.out::print);
        System.out.println();



        /*
         * Part 2: Integer Stream with skip
         */
        IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));
        System.out.println();



        /*
         * Part 3: Integer Stream with sum
         */
        System.out.println(
            IntStream.range(1, 5).sum()
        );
        System.out.println();



        /*
         * Part 4: Stream.of, sorted, findFirst
         */
        Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(System.out::println);
        System.out.println();



        /*
         * Part 5: Stream from array, sort, filter, print
         */
        String[] names = {"Albert", "Andrew", "Kumar", "Brent", "Bruce", "Steven", "Stephen", "Phteven", "jason", "Paul", "Toney", "Qian", "Pratap"};
        Arrays.stream(names)   // can also use Stream.of
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();




        /*
         * Part 6: Average of squares of an int array
         */
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();




        /*
         * Part 7: Stream from a List, filter, and print
         */
        List<String> people = Arrays.asList("Albert", "Andrew", "Kumar", "Brent", "Bruce", "Steven", "Stephen", "Phteven", "jason", "Paul", "Toney", "Qian", "Pratap");
        people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);
        System.out.println();

        // the next two forEach lines are equivalent
        people.forEach(System.out::println);
        System.out.println("=========================");
        people.forEach(x -> System.out.println(x));
    }
}
