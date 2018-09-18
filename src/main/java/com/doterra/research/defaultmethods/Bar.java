package com.doterra.research.defaultmethods;

public class Bar implements Foo
{
    @Override
    public void myFoo()
    {
        System.out.println("this is overridden foo Bar");
    }
}
