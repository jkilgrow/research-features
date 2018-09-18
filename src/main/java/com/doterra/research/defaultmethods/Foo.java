package com.doterra.research.defaultmethods;

public interface Foo
{
    public void myFoo();

    public default void defaultFoo()
    {
        System.out.println("this is default Foo");
    }

    public default void frooFoo()
    {
        System.out.println("This is the Froo Foo");
    }
}
