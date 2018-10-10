package com.doterra.research.guice.simpleProvider;

public class NightOwlDiscount implements Discountable
{
    @Override
    public double getDiscount()
    {
        return 0.35d;
    }
}
