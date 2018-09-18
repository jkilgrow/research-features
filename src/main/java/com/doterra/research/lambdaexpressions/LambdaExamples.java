package com.doterra.research.lambdaexpressions;

import java.util.Comparator;

/*
 * Java lambda expressions let you have functions as objects. They are objects. You can pass them around
 * just like you can other objects.
 * A lambda is an anonymous implementation of a single method interface.
 */
public class LambdaExamples
{
    public static void main (String [] args)
    {
        /*
         * Part 1: The old way...
         */
        // anonymous implementation of an interface without using lambda expression
        Comparator<String> stringComparator = new Comparator<String>()
        {
            @Override
            public int compare(String s1, String s2)
            {
                return s1.compareTo(s2);
            }
        };

        int comparison = stringComparator.compare("hello", "hello");
        System.out.println("comparison: " + comparison);


        /*
         * Part 2: The new way with verbose syntax
         */
        // use a lambda to do the same thing as above. remember, a lambda implements a single method interface.
        // (String s1, String s2)   are the lambda parameters
        // the method implemented is the compareTo() method on the Comparator interface
        // compare() takes two parameters. hence, we must pass it two parameters.
        // ->  is the lambda operator. it tells the jvm this is a lambda expression.
        // the stuff between the braces {} is the body of the lambda. this is the code that is executed when the expression is called.
        Comparator<String> lambdaComparator = (String s1, String s2) -> { return s1.compareTo(s2); };

        int lambdaComparison = lambdaComparator.compare("hello", "hello");
        System.out.println("lambdaComparison: " + lambdaComparison);



        /*
         * Part 3: lambda syntax simplified
         */
        // because of type inference in java 8, we can omit the types on the parameters
        // in cases where the lambda body contains a single statement, we can simplify that too.
        // remove the braces and the return statement.
        Comparator<String> lambdaSimpler = (s1, s2) -> s1.compareTo(s2);
        int simpleLambdaComparison = lambdaSimpler.compare("hello", "world");
        System.out.println("simpler lambda comparison: " + simpleLambdaComparison);



        /*
         * Part 4: zero parameters
         */
        // zero parameters require parenthesis for the parameter
        MyFunction myFunction = () -> { System.out.println("Hello World"); };
        myFunction.apply();



        /*
         * Part 5: Single parameter
         */
        // a single parameter and you can omit the parenthesis around the parameter body
        MyOtherFunction myOtherFunction = text -> System.out.println(text);
        myOtherFunction.applyOne("Hello Function Body!");



        /*
         * Part 6: Multiple parameters
         */
        // multiple parameters requires the parenthesis around the parameter body
        MyTwoParameterFunction twoParameterFunction = (s1, s2) -> System.out.println(s1 + " + " + s2);
        twoParameterFunction.applyTwo("Hello", "to the World");



        /*
         * Part 7: method that returns something
         */
        MyMethod myMethod = (s1, s2) -> {
            System.out.println("inside lambda: " + s1 + " + " + s2);
            return s1 + " + " + s2;
        };
        String returnString = myMethod.applyString("Hello", "World");
        System.out.println("outside lambda: " + returnString);
    }
}
