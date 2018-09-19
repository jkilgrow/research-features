package com.doterra.research.lambdaexpressions;

public class LambdaExamples2
{
    static String thirdVariable = "Kitty: ";
    private String monkey = "monkey";

    public static void main(String[] args)
    {
        /*
         * Using a local variable declared outside of the lambda
         * The variable must be declared as final or "effectively final" or never changed after initially set.
         */
        final String otherText = "Hello: ";

        MyInterface myInterface = (text) ->
        {
            System.out.println(otherText + text);
        };
        myInterface.printIt("monkey");


        /*
         * Using a static member.
         * The static member can be referenced as any other static member and can be changed.
         * Think about what the differences are between a static member and a member property.
         */
        MyInterface otherInterface = (text) ->
        {
            System.out.println(thirdVariable + text);
        };
        otherInterface.printIt("before");
        thirdVariable = "What now: ";
        otherInterface.printIt("after");

        LambdaExamples2 lambdaExamples2 = new LambdaExamples2();
        lambdaExamples2.doIt();
    }

    /*
     * Let's see how lambdas work with instance properties.
     */
    public void doIt()
    {
        final String doItText = "Lets do this: ";
        MyInterface instanceInterface = (text) ->
        {
            System.out.println(doItText + text + " " + this.monkey);
        };

        instanceInterface.printIt("ABCD");
        this.monkey = "doofus";
        instanceInterface.printIt("defg");
    }
}
